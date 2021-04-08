package com.example.myspringboot.onfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
/*声明该类是一个配置类，实现接口*/
@Configuration
public class WebMvcConfigration implements WebMvcConfigurer {
/*spring已经不new对象了，直接注入即可*/
    @Autowired
    private HandlerInterceptor myInterceptor;

    /**
     * 拦截器注册器，重写接口中的addInterceptors方法，添加自定义拦截器
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        /*注明拦截路径，/*拦截一级的，**拦截多级目录*/
        registry.addInterceptor(myInterceptor).addPathPatterns("/**");
    }
}