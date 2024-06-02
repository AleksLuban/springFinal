package com.intellekta.springFinal.configure;


import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MessageConfiguration implements WebMvcConfigurer {

    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/messages").setViewName("messages");
        registry.addViewController("/login").setViewName("login");
        registry.addViewController("/filter").setViewName("filter");
    }

}
