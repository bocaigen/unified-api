package com.bobo.properties;

import com.bobo.interceptor.ResponseResultInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

/**
 * Created by Administrator on 2020/12/19.
 */
@Configuration
public class ContextConfig extends WebMvcConfigurationSupport {
    @Override
    protected void addInterceptors(InterceptorRegistry registry) {
        //需要拦截的路径，/**表示需要拦截所有请求
        String[] addPathPatterns={"/**"};
        //不需要拦截的路径
        //拦截器配置不拦截路径如果失效，是因为不拦截路径配置错误，请仔细查看
        String [] excludePathPaterns={
                "/girls/*"
        };

        registry.addInterceptor(new ResponseResultInterceptor())
                .addPathPatterns(addPathPatterns);
//                .excludePathPatterns(excludePathPaterns);

//        super.addInterceptors(registry);
    }

    @Override
    protected void addResourceHandlers(ResourceHandlerRegistry registry) {
//        String[] excludes = new String[] { "/static/**", "**.html", "/login.html" };

        registry.addResourceHandler("/**").addResourceLocations("classpath:/META-INF/resources/")
                .addResourceLocations("classpath:/resources/").addResourceLocations("classpath:/static/")
                .addResourceLocations("classpath:/public/");
        super.addResourceHandlers(registry);
    }
}
