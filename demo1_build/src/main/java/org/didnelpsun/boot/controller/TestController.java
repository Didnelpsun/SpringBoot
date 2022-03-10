// TestController.java
package org.didnelpsun.boot.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// 返回都为响应体内容
@RestController
public class TestController {
    @RequestMapping("/hello")
    public String hello(){
        return "hello";
    }
}
