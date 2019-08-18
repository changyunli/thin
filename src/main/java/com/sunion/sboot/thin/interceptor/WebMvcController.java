package com.sunion.sboot.thin.interceptor;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;


/**
 * Created by Administrator on 2019/8/17.
 */
@Configuration
public class WebMvcController extends WebMvcConfigurerAdapter {

    static {
        OneInterceptor oneInterceptor=new OneInterceptor();
        System.out.println(oneInterceptor);
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new OneInterceptor()).addPathPatterns("/article/getArticle/**");
        super.addInterceptors(registry);
    }
}
