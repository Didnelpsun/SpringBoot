// TestController
package org.didnelpsun.boot.controller;

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
    @RequestMapping("/allUser")
    public List<User> allUser(){
        return userService.selectAllUsers();
    }
    @RequestMapping("/user/{id}")
    public User user(@PathVariable Integer id){
        return userService.selectUser(id);
    }
}
