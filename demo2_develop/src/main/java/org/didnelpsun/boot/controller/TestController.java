// TestController
package org.didnelpsun.boot.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;

@Slf4j
@RestController
public class TestController {
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
}
