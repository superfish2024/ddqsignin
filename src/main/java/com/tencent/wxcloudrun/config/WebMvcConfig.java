package com.tencent.wxcloudrun.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig extends WebMvcConfigurationSupport {
    @Override
    protected void addResourceHandlers(ResourceHandlerRegistry registry)
    {
        registry.addResourceHandler("**/**.css").addResourceLocations("classpath:/static/");
        registry.addResourceHandler("**/**.js").addResourceLocations("classpath:/static/");
        registry.addResourceHandler("**/**.woff2").addResourceLocations("classpath:/static/");
        registry.addResourceHandler("**/**.woff").addResourceLocations("classpath:/static/");
        registry.addResourceHandler("**/**.png").addResourceLocations("classpath:/static/");
        registry.addResourceHandler("**/**.ttf").addResourceLocations("classpath:/static/");
    }


}