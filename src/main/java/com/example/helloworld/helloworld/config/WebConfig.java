
package com.example.helloworld.helloworld.config;
 
import org.springframework.context.annotation.Configuration;

import org.springframework.web.servlet.config.annotation.CorsRegistry;

import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
 
@Configuration

public class WebConfig implements WebMvcConfigurer {

    @Override

    public void addCorsMappings(CorsRegistry registry) {

        registry.addMapping("/**")

                .allowedOrigins("*") // Allow requests from any origin

                .allowedMethods("GET", "POST", "PUT", "DELETE"); // Allow only specific methods

    }

}
