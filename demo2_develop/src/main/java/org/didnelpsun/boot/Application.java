// Application.java
package org.didnelpsun.boot;

import org.didnelpsun.boot.bean.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        ApplicationContext applicationContext = SpringApplication.run(Application.class, args);
        User user = (User) applicationContext.getBean("user");
        System.out.println(user);
    }

}
