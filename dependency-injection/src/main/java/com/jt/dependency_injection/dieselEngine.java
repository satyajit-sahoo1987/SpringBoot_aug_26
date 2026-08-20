package com.jt.dependency_injection;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component("Diesel")
@Primary
public class dieselEngine  implements Engine{
     @Override
    public void startEngine() {
       System.out.println("Diesel Engine Starting");
    }

    @Override
    public void stopEngine() {
         System.out.println("Diseal Engine Stopping");
    }
    
}
