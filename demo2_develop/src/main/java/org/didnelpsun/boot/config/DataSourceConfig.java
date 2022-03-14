//// DataSourceConfig.java
//package org.didnelpsun.boot.config;
//
//import com.alibaba.druid.pool.DruidDataSource;
//import com.alibaba.druid.support.http.StatViewServlet;
//import com.alibaba.druid.support.http.WebStatFilter;
//import org.springframework.boot.context.properties.ConfigurationProperties;
//import org.springframework.boot.web.servlet.FilterRegistrationBean;
//import org.springframework.boot.web.servlet.ServletRegistrationBean;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import javax.sql.DataSource;
//import java.sql.SQLException;
//import java.util.List;
//
//@Configuration
//public class DataSourceConfig {
//    // 使用配置文件注入，Druid的配置名和默认的一样所以可以直接配置
//    @ConfigurationProperties("spring.datasource")
//    @Bean
//    public DataSource dataSource() throws SQLException {
//        DruidDataSource dataSource = new DruidDataSource();
//        // 开启监控和防火墙功能
//        dataSource.setFilters("stat,wall");
//        return dataSource;
//    }
//    // 配置Druid官方教程的数据库连接池监控页
//    // Druid内置提供了一个StatViewServlet用于展示Druid的统计信息。
//    //这个StatViewServlet的用途包括：
//    //提供监控信息展示的html页面
//    //提供监控信息的JSON API
//    @Bean
//    public ServletRegistrationBean<?> statViewServlet(){
//        // 监控首页地址为/druid/index.html
//        ServletRegistrationBean<StatViewServlet> servletRegistrationBean = new ServletRegistrationBean<>(new StatViewServlet(), "/druid/*");
//        // 添加监控页的用户密码
//        servletRegistrationBean.addInitParameter("loginUsername","admin");
//        servletRegistrationBean.addInitParameter("loginPassword", "root");
//        return servletRegistrationBean;
//    }
//    // WebStatFilter用于监控Web-JDBC应用数据
//    @Bean
//    public FilterRegistrationBean<?> webStatFilter(){
//        FilterRegistrationBean<WebStatFilter> filterRegistrationBean = new FilterRegistrationBean<>(new WebStatFilter());
//        filterRegistrationBean.setUrlPatterns(List.of("/*"));
//        // 对静态资源和druid监控页进行排除，使用初始化参数
//        filterRegistrationBean.addInitParameter("exclusions", "*.js,*.gif,*.jpg,*.png,*.css,*ico,/druid/*");
//        return filterRegistrationBean;
//    }
//}
