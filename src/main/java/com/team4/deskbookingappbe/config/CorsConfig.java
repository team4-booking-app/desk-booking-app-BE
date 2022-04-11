package com.team4.deskbookingappbe.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig {

    @Bean
    public WebMvcConfigurer corsConfigurer(){
        return new WebMvcConfigurer(){
            @Override
            public void addCorsMappings(CorsRegistry registry){
                registry.addMapping("/**")
                        .allowedMethods("GET","POST","PUT","DELETE")
                        .allowedHeaders("*")
                        .allowedOrigins("http://team4-frontend-stage-app.herokuapp.com",
                                        "http://team4-frontend-stage-app.herokuapp.com:80",
                                        "https://team4-frontend-stage-app.herokuapp.com:80",
                                        "https://team4-frontend-stage-app.herokuapp.com",
                                        "https://team4-frontend-stage-app.herokuapp.com/registration");
            }
        };
    }
}
