// RegisterConfig.java
package org.didnelpsun.boot.config;

import org.didnelpsun.boot.filter.TestFilter;
import org.didnelpsun.boot.listener.TestListener;
import org.didnelpsun.boot.servlet.TestServlet;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import java.util.List;

@Configuration
public class RegisterConfig {
    @Bean
    public ServletRegistrationBean<TestServlet> testServlet(){
        // 将定义的Servlet注册
        return new ServletRegistrationBean<>(new TestServlet(),"/testServlet");
    }
    @Bean
    public FilterRegistrationBean<TestFilter> testFilter(){
        // 对Servlet进行过滤
//        return new FilterRegistrationBean<>(new TestFilter(), testServlet());
        // 对URL进行过滤
        FilterRegistrationBean<TestFilter> filterRegistrationBean = new FilterRegistrationBean<>(new TestFilter());
        filterRegistrationBean.setUrlPatterns(List.of("/*"));
        return filterRegistrationBean;
    }
    @Bean
    public ServletListenerRegistrationBean<TestListener> testListener(){
        return new ServletListenerRegistrationBean<>(new TestListener());
    }
}
