// ApplicationConfig.java
package org.didnelpsun.boot.config;

import org.didnelpsun.boot.entity.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// 这是一个配置类
@Configuration
public class ApplicationConfig {
    // 给容器添加组件，以方法名为组件id，以返回类型为组件类型，以返回值为容器中实例
    @Bean
    public User user(){
        return new User();
    }
}
