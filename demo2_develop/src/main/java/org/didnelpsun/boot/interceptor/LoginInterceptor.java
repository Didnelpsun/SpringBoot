// LoginInterceptor.java
package org.didnelpsun.boot.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// 登录检查
public class LoginInterceptor implements HandlerInterceptor {
    @Override
    // 如果session中存在name就代表已经登录，需要对新用户进行拦截
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        if(request.getSession().getAttribute("name") == null){
            System.out.println("登录成功");
            return true;
        }
        System.out.println("登录失败");
        return false;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
    }
}