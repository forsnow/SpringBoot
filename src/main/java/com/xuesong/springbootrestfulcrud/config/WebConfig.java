package com.xuesong.springbootrestfulcrud.config;

import com.xuesong.springbootrestfulcrud.component.LoginHandlerInterceptor;
import com.xuesong.springbootrestfulcrud.component.MyLocaleReolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author: Snow
 * @create: 2020-07-16 15:16
 * 既保留了所有的自动配置，也能用我们扩展的配置
 * 创建一个配置类 继承 WebMvcConfigurer 可以来扩展SpringMVC的功能
 *
 * @@EnableWebMvc   这个注解全面接管SpringMVC的配置
 **/

@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addRedirectViewController("xuesong","success");
        registry.addViewController("/").setViewName("login");
        registry.addViewController("/index.html").setViewName("login");
        registry.addViewController("/main.html").setViewName("dashboard");
    }

    @Bean
    public LocaleResolver localeResolver(){
        return new MyLocaleReolver();
    }

    //配置拦截器
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
//        registry.addInterceptor(new LoginHandlerInterceptor()).addPathPatterns("/**")
//        .excludePathPatterns("/index.html","/","/user/login","/asserts/**","/webjars/**");
//        //静态资源 spring2.0以上还是拦截的 需要配置
    }
}
