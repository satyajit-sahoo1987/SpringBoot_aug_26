package com.jt;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class AppConfig1 {
    @Bean
    @Scope(value="prototype")
    public Employee emp(){
        return new Employee();
    }
}
