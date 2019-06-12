package zy.springbootdemo.mvcdemo.config;

import org.apache.catalina.User;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class SessionHandlerInterceptor implements HandlerInterceptor {
    public boolean preHandle (HttpServletRequest request, HttpServletResponse response, Object handler) throws IOException {
        User user = (User)request.getSession().getAttribute("user");
        if (user == null) {
            // 没有登录，重定向到login.html
            response.sendRedirect("/login.html");
            return false;
        }
        return true;
    }

    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) {
        // Controller方法处理完后调用
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        // 页面渲完后调用此方法，通常用来清理资源，类似java语法的finally
    }

}
