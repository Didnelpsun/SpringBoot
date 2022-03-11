// WebConfig.java
package org.didnelpsun.boot.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.HiddenHttpMethodFilter;

// 不使用代理模式，因为定义的实例不存在依赖关系，所以不进行实例依赖检查，从而加快实例化速度
@Configuration(proxyBeanMethods = false)
public class WebConfig {
    @Bean
    public HiddenHttpMethodFilter hiddenHttpMethodFilter(){
        HiddenHttpMethodFilter hiddenHttpMethodFilter = new HiddenHttpMethodFilter();
        // _method为默认设置值，HiddenHttpMethodFilter提供一个setMethodParam修改这个默认值
        hiddenHttpMethodFilter.setMethodParam("_m");
        // 将自定义过滤器作为配置实例返回
        // 这样在过滤器链的配置中，首先会从容器中查找是否有这个过滤器，我们自己自定义了所以就不会默认生成一个过滤器
        return hiddenHttpMethodFilter;
    }
}
