// UserController.java
package org.didnelpsun.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.didnelpsun.bean.User;
import org.didnelpsun.config.SwaggerConfig;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

// value的值不会显示，为这个API的说明值
// tags的值会显示在最左边的粗体，如果tags中有多个值会有多个标签组，每个标签里面有该接口的所有方法
// description的值会显示在粗体旁边的说明，但是被弃用
// 在swagger-annotations jar包中1.5.X版本以上, 注解io.swagger.annotations.API中的description被废弃了。
// 新的swagger组件中使用了新的方法来对Web api进行分组。原来使用description，默认一个Controller类中包含的方法构成一 个api分组。现在使用tag，可以更加方便的分组。
// 比如把两个Controller类里的方法划分成同一个分组。tag的key用来区分不同的分组。tag的value用做分组的描述。
@Api(tags = {SwaggerConfig.userTag}, value = "UserController")
@RestController
@RequestMapping("/")
public class UserController {
    @ApiOperation(value = "主页", notes = "主页面")
    // @ApiOperation中value是api的简要说明，在界面api链接的右侧，少于120个字符。
    // @ApiOperation中notes是api的详细说明，需要点开api链接才能看到。
    // @ApiOperation中produces用来标记api返回值的具体类型。这里是json格式，utf8编码。
    // @ApiOperation中httpMethod为接口请求方式
    @RequestMapping("")
    public String index(){
        return "index";
    }
    @ApiOperation(value = "返回新用户", notes = "返回的新用户是一个无参构造类")
    @RequestMapping("/user")
    public User user(){
        return new User();
    }
    @ApiOperation(value = "返回新用户并设置用户名", notes = "返回的新用户是含有name")
    @RequestMapping("/user/{name}")
    public User user(@PathVariable @ApiParam("用户名") String name){
        User user = new User();
        user.setName(name);
        return user;
    }
}