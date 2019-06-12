package zy.springbootdemo.mvcdemo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.format.datetime.DateFormatter;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfigurer implements WebMvcConfigurer {

    // 拦截器
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new SessionHandlerInterceptor())
                .addPathPatterns("/admin/**");
    }

    // 跨域cors
    @Override
    public void addCorsMappings(CorsRegistry registry){
        registry.addMapping("/api/**").allowedOrigins("*").allowedMethods("POST", "GET");
    }

    // 格式化
    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addFormatter(new DateFormatter("yyyy-MM-dd"));
    }

    // 注册Controller
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/index.html").setViewName("/index.html");
        registry.addViewController("/login.html").setViewName("/login.html");
        registry.addRedirectViewController("/**/*.do", "/index.html");
    }

}
