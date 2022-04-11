package com.team4.deskbookingappbe.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
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
                                        "https://team4-frontend-stage-app.herokuapp.com",
                                        "https://team4-frontend-stage-app.herokuapp.com/registration",
                                        "http://team4-frontend-stage-app.herokuapp.com/registration",
                                        "*");
            }
        };
    }
}
