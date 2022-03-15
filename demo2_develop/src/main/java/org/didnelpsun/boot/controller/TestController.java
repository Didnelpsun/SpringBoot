// TestController
package org.didnelpsun.boot.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.extern.slf4j.Slf4j;
import org.didnelpsun.boot.bean.User;
import org.didnelpsun.boot.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.List;

@Slf4j
@RestController
public class TestController {
    UserServiceImpl userService;

    @Autowired
    public void setUserService(UserServiceImpl userService) {
        this.userService = userService;
    }

    @RequestMapping("/img/test.jpg")
    public String test(){
        return "test";
    }
    @RequestMapping("/login")
    public String login(String name, String password, HttpServletRequest request){
        HttpSession session = request.getSession();
        session.setAttribute("name", name);
        session.setAttribute("password", password);
        System.out.println(name + password);
        return "登录成功！";
    }
    @PostMapping("/upload")
    public String upload(@RequestPart("file") MultipartFile file, HttpSession session) throws IOException {
        // 类标注@Slf4j来获取日志打印信息对象log进行信息打印
        log.info("文件信息：原始名称：{}，大小：{}，路径：{}",file.getOriginalFilename(), file.getSize(), file.getResource());
        if(!file.isEmpty()){
            // 利用transferTo进行文件传输到项目静态资源的img文件夹下
            file.transferTo(new File(session.getServletContext().getRealPath("")+ File.separator +file.getOriginalFilename()));
            return "上传成功！";
        }
        else
            return "文件为空！";
    }
    @GetMapping("/selectAllUsers")
    public List<User> selectAllUsers(){
//        return userService.selectAllUsers();
        return userService.list();
    }
    // 通用查询，如果传入的值可以转为数字就是根据ID，否则使用模糊查询
    @RequestMapping("/user/{query}")
    public List<User> selectUsers(@PathVariable String query){
        try {
            return List.of(userService.getById(Integer.valueOf(query)));
        }
        catch (NumberFormatException e){
            QueryWrapper<User> queryWrapper = new QueryWrapper<>();
            // 第一个参数：该参数是一个布尔类型，只有该参数是true时，才将like条件拼接到sql中；本例中，如果name字段不为空，则拼接name字段的like查询条件；
            // 第二个参数：该参数是数据库中的字段名；
            // 第三个参数：该参数值字段值；
            queryWrapper.like(StringUtils.isNotBlank(query), "name", query);
            return userService.list(queryWrapper);
        }
        catch (NullPointerException e){
            return null;
        }
    }
    @PostMapping ("/user")
    public Boolean insertUser(User user){
        return userService.save(user);
    }
    @PutMapping ("/user")
    public Boolean updateUser(User user){
        return userService.updateById(user);
    }
    @DeleteMapping("/user/{id}")
    public Boolean deleteUser(@PathVariable Integer id){
        return userService.removeById(id);
    }
    @RequestMapping("/user/getUsersSum")
    public long getUsersSum(){
        return userService.count();
    }
    // 参数为当前查询页码
    @GetMapping("/selectAllUsers/{page}")
    public List<User> selectAllUsersByPage(@PathVariable Integer page){
        // 泛型为数据操作对象
        // 创建有两个参数，第一个是当前页面页码，第二个是页面大小
        Page<User> userPage = new Page<>(page,10);
        // page的第一个参数为Page对象，对分页的页面进行配置，第二个参数为查询条件
        return userService.page(userPage, null).getRecords();
    }
}
