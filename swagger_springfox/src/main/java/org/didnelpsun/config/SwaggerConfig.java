// SwaggerConfig.java
package org.didnelpsun.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.Tag;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import java.util.ArrayList;

// 开发环境dev、测试环境test、生产环境prod
// 只有开发模式和测试模式Swagger才有效
@Profile({"dev","test"})
// 通过yaml文件注入
@ConfigurationProperties("swagger")
// 必须设置@Data为私有字段添加Setter/Getter方法，否则配置文件无法注入
@Data
@Configuration
public class SwaggerConfig {
    private String version;
    private String termsOfServiceUrl;
    private String name;
    private String url;
    private String email;
    private String license;
    private String licenseUrl;
    // 设置静态成员Tag来引用
    public static final String userTag = "UserController";
    public static final String accountTag = "AccountController";
    // 配置Swagger，Docket为文档插件
    @Bean
    public Docket userDocket(){
        // 点击Docket具体代码中查看有哪些配置可以修改
        // 首先新建一个Docket实例，传入的参数为Swagger的版本号，我们使用的是3.0版本所以传入OAS_30
        return new Docket(DocumentationType.OAS_30)
                // 设置默认的API组的组名
                .groupName("user")
                // 修改Swagger头部信息，没有Setter所以只能通过构造器
                // 参数：
                // 文档标题
                // 文档介绍
                // 文档版本
                // 服务的组织的URL连接
                // 联系方式，是一个定义的实体类，有三个参数，第一个是作者名，第二个是作者网页，第三个是邮箱
                // 证件类型
                // 证件地址
                // 补充，默认为空
                .apiInfo(new ApiInfo("API文档", "User用户类", version, termsOfServiceUrl, new Contact(name, url, email), license, licenseUrl, new ArrayList<>()))
                .select()
                // paths表示过滤请求路径，PathSelectors为路径选择器
                // ant为ant风格的路径，之前SpringMVC中提到
                // /**表示所有路径都能被扫描
                .paths(PathSelectors.ant("/user/**"))
                // apis表示对哪些包进行扫描定位，RequestHandlerSelectors为请求处理选择器
                // basePackage：扫描包的类路径
                // any：扫描所有包
                // none：不扫描包
                // withClassAnnotation：通过类的注解扫描，如传入GetMapping.class会扫描所有标注@GeMapping的控制器
                // withMethodAnnotation：通过方法的注解扫描，如传入RestController.class会扫描所有标注@RestContorller的类下的控制器
                .apis(RequestHandlerSelectors.basePackage("org.didnelpsun.controller")).build()
                // 添加标签
                // 两个string值，分别为名称和描述
                .tags(new Tag(SwaggerConfig.userTag,"用户控制类"))
                ;
    }
    @Bean
    public Docket accountDocket(){
        return new Docket(DocumentationType.OAS_30)
                .groupName("account")
                .apiInfo(new ApiInfo("API文档", "Account账户类", version, termsOfServiceUrl, new Contact(name, url, email), license, licenseUrl, new ArrayList<>()))
                .select()
                .paths(PathSelectors.ant("/account/**"))
                .apis(RequestHandlerSelectors.basePackage("org.didnelpsun.controller")).build()
                .tags(new Tag(SwaggerConfig.accountTag, "账户控制类"))
                ;
    }
}