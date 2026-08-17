package com.jt.dependency_injection;



// import org.springframework.stereotype.Component;

// @Component
// public class Engine{
//     public void startEngine(){
//         System.out.println("Engine is Starting");

//     }
//     public void stopEngine(){
//         System.out.println("Engine is Stopping.");
//     }
// }
public interface Engine{
    void startEngine();
    void stopEngine();

}