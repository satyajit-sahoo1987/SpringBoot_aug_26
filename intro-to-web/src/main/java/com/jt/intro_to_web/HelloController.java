package com.jt.intro_to_web;

import java.io.PrintWriter;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
// 1.it marks the class as a controller class
//2.which means that class is responsible to handle http request
// @Component
public class HelloController{
    @RequestMapping("/home") //1.This annotation handles a custom path inside  a controller class
public void sayHello( PrintWriter writer){
    System.out.println("Hello Web");
    writer.println("<h1>Hello Spring Web</h1><p>Welcome Home</p>");
}
@RequestMapping("/contact")
public String contact(){
    System.out.println("html server site");
    return "contact-page";
}
}