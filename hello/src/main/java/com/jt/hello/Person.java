package com.jt.hello;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

@Component
public class Person {
    public void sayHello(){
        System.out.println("Person saya hello!!!!!");
    }
}
