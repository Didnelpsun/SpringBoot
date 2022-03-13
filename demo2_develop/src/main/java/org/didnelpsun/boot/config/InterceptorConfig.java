// InterceptorConfig.java
package org.didnelpsun.boot.config;

import org.didnelpsun.boot.interceptor.LoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration(proxyBeanMethods = false)
// 添加拦截器配置
public class InterceptorConfig implements WebMvcConfigurer {
    // 登录拦截器
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginInterceptor()).addPathPatterns("/login");
    }
}
