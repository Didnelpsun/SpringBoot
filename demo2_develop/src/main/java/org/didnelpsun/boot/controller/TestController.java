// TestController
package org.didnelpsun.boot.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    @RequestMapping("/img/test.jpg")
    public String test(){
        return "test";
    }
}
