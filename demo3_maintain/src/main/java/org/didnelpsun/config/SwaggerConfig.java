// SwaggerConfig.java
package org.didnelpsun.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import java.util.ArrayList;

// 开发环境develop、测试环境test、生产环境master
// 只有开发模式和测试模式Swagger才有效
@Profile({"dev","test"})
@Configuration
public class SwaggerConfig {
    // 配置Swagger，Docket为文档插件
    @Bean
    public Docket docket(){
        // 点击Docket具体代码中查看有哪些配置可以修改
        // 首先新建一个Docket实例，传入的参数为Swagger的版本号，我们使用的是3.0版本所以传入OAS_30
        Docket docket = new Docket(DocumentationType.OAS_30);
        // 此时Swagger生效
        docket.enable(true);
        // 设置默认的API组的组名
        docket.groupName("group");
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
        docket.apiInfo(new ApiInfo("API文档", "项目Swagger文档", "0.0", "https://didnelpsun.github.io", new Contact("Didnelpsun", "https://didnelpsun.github.io", "didnelpsun@163.com"), "", "", new ArrayList<>()));
        // apis表示对哪些包进行扫描定位，RequestHandlerSelectors为请求处理选择器
        // basePackage：扫描包的类路径
        // any：扫描所有包
        // none：不扫描包
        // withClassAnnotation：通过类的注解扫描，如传入GetMapping.class会扫描所有标注@GeMapping的控制器
        // withMethodAnnotation：通过方法的注解扫描，如传入RestController.class会扫描所有标注@RestContorller的类下的控制器
        docket.select().apis(RequestHandlerSelectors.basePackage("org.didnelpsun.controller")).build();
        // paths表示过滤请求路径，PathSelectors为路径选择器
        // ant为ant风格的路径，之前SpringMVC中提到
        // /**表示所有路径都能被扫描
        docket.select().paths(PathSelectors.ant("/**"));
        return docket;
    }
}
