// AccountController.java
package org.didnelpsun.controller;

import io.swagger.annotations.*;
import org.didnelpsun.config.SwaggerConfig;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

@Api(tags = {SwaggerConfig.accountTag})
@RestController()
@RequestMapping("/account")
public class AccountController {
    @RequestMapping("/test")
    public String test(){
        return "test";
    }
    @GetMapping("/{id}/{name}")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "账户ID", required = true, paramType = "path", dataType = "String"),
            @ApiImplicitParam(name = "name", value = "账户名", required = true, paramType = "path", dataType = "String")
    })
    @ApiResponses({
            @ApiResponse(code = 200,message = "账户测试成功！", responseHeaders = @ResponseHeader(name = "TestHeader", description = "测试响应头部")),
            @ApiResponse(code = 400, message = "参数不完整"),
            @ApiResponse(code = 401, message = "用户未授权，请登录"),
            @ApiResponse(code = 403, message = "用户没有权限访问"),
            @ApiResponse(code = 404, message = "路径出错"),
            @ApiResponse(code = 500, message = "参数异常")
    })
//    @ApiIgnore
    public String account(@PathVariable Integer id, @PathVariable String name){
        return id+name;
    }
}
