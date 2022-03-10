// MainApplication
package org.didnelpsun.boot;

import org.didnelpsun.boot.entity.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

// 这个注解表示这是个SpringBoot应用，标注的这个类是主程序类，所以应用的入口
@SpringBootApplication
public class MainApplication {
    // 主方法
    public static void main(String[] args){
        // SpringApplication表示这个Spring应用，run表示启动一个Spring应用
        // 传入的参数为对这个Spring应用进行配置，一个是主程序类，一个是初始化参数
        // 为默认固定写法
        // 1.返回的是一个IoC配置应用容器
        ConfigurableApplicationContext context = SpringApplication.run(MainApplication.class, args);
        User user1 = context.getBean("user", User.class);
        User user2 = context.getBean("user", User.class);
        System.out.println(user1 == user2);
//        // 2.查看容器里所有组件
//        String[] contextBeanDefinitionNames = context.getBeanDefinitionNames();
//        for(String name:contextBeanDefinitionNames){
//            System.out.println(name);
//        }
    }
}
