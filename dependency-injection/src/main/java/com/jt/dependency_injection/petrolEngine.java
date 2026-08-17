package com.jt.dependency_injection;

import org.springframework.stereotype.Component;

@Component
public class petrolEngine implements Engine {

    @Override
    public void startEngine() {
       System.out.println("Petrol Engine Starting");
    }

    @Override
    public void stopEngine() {
         System.out.println("Petrol Engine Stopping");
    }
    
}
