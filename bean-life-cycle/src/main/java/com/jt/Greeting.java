package com.jt;

import org.springframework.stereotype.Component;

@Component
public class Greeting {
public Greeting(){
    System.out.println("Greeting object is constructed");
}
public void sayHello(){
    System.out.println("Hello......");
}
}    
