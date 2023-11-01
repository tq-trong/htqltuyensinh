package com.cusc.htqltuyensinh.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer{
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
            .allowedOrigins("*")  // Cho phép truy cập từ mọi nguồn
            .allowedMethods("GET", "POST", "PUT", "DELETE")
            .allowCredentials(true);
    }

}
