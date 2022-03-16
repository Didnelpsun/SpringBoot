package org.didnelpsun.config;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.Paths;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.tags.Tag;
import org.springdoc.core.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {
//    // 配置User组
//    @Bean
//    public GroupedOpenApi userOpenApi(){
//        // 使用GroupedOpenApi的静态工厂构建实例
//        return GroupedOpenApi.builder()
//                // 组名
//                .group("user")
//                // 扫描包路径
//                .packagesToScan("org.didnelpsun.controller")
//                // 配置匹配路径
//                .pathsToMatch("/user/**")
//                .pathsToMatch("/")
//                .build();
//    }
//    // 配置Account组
//    @Bean
//    public GroupedOpenApi accountOpenApi(){
//        return GroupedOpenApi.builder()
//                .group("account")
//                .packagesToScan("org.didnelpsun.controller")
//                .pathsToMatch("/account/**")
//                .build();
//    }
    // 配置OpenAPI
    @Bean
    public OpenAPI userOpenAPI(){
        Tag user = new Tag();
        user.setName("user");
        return new OpenAPI()
                // 设置标签组
//                .addTagsItem(user)
                // 设置OpenAPI基本信息
                .info(new Info()
                        .title("OpenAPI文档")
                        .description("SpringDoc版本的Swagger3")
                        .version("0.0")
                        // 设置证明
                        .license(new License()
                                .name("")
                                .url("")
                        )
                )
                // 设置外部文档信息
                .externalDocs(new ExternalDocumentation()
                        .description("作者网页")
                        .url("https://didnelpsun.github.io")
                );
    }
}
