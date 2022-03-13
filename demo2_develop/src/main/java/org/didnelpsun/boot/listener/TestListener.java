// TestListener.java
package org.didnelpsun.boot.listener;

import lombok.extern.slf4j.Slf4j;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@Slf4j
@WebListener
public class TestListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        log.info("容器初始化完成");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        log.info("容器销毁完成");
    }
}
