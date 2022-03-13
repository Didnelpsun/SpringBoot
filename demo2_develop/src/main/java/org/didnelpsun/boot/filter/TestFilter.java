// TestFilter.java
package org.didnelpsun.boot.filter;

import lombok.extern.slf4j.Slf4j;
import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@Slf4j
@WebFilter(filterName = "TestFilter", value = "/*")
public class TestFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig){
        log.info("过滤器初始化完成");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        log.info("过滤器工作");
        // 过滤器放行
        filterChain.doFilter(servletRequest,servletResponse);
    }

    @Override
    public void destroy() {
        log.info("过滤器销毁完成");
    }
}
