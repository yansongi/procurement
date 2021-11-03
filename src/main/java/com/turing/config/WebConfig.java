package com.turing.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@MapperScan("com.turing.mapper")
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("login.html").setViewName("login");
        registry.addViewController("index.html").setViewName("index");
        registry.addViewController("leftRequire.html").setViewName("leftRequire");
        registry.addViewController("bar.html").setViewName("bar");
        registry.addViewController("mainRequire.html").setViewName("mainRequire");
    }
}
