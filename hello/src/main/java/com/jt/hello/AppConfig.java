package com.jt.hello;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
@Configuration
public class AppConfig {
    @Bean
    @Scope(value="singleton")
    public Student student(){
        return new Student();
    }
    @Bean
    public CommandLineRunner commandLineRunner(){
        return args->{
            System.out.println("This method is called after spring container is initialized");
        };
    }
}
