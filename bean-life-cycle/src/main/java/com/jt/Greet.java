package com.jt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

@Component
public class Greet {
    private Greeting greeting;
    public Greet(){
        System.out.println("Greet Object is Construucted.");
    }
    @Autowired
    public void setGreeting(Greeting greeting){
        System.out.println("Greeting Object is Injected");
        this.greeting=greeting;
    }
    @PostConstruct
    public void init1(){
        System.out.println("Bean is initialized");
    }
    @PreDestroy
    public void destroy(){
        System.out.println("Greet bean is destroyd");
    }
    public void greet(){
        System.out.println("hello everyone!!!");
        greeting.sayHello();
    }

}
