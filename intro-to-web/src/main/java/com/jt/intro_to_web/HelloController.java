package com.jt.intro_to_web;

import java.io.PrintWriter;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpServletRequest;

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
// @RequestMapping("/submit-details")
// public String submitDetails(HttpServletRequest request,Model model){
//     System.out.println("Submit");
//     String name=request.getParameter("name");
//     String phone=request.getParameter("phone");
//     // System.out.println("Name is :"+name);
//     // System.out.println("Phone number  is :"+phone);

//     model.addAttribute("name",name);
//     model.addAttribute("phone",phone);

//     return "details-page";
@RequestMapping("/submit-details")
public String submitDetails(@RequestParam(value="name") String name1,@RequestParam String phone,Model model){

    model.addAttribute("name",name1);
    model.addAttribute("phone",phone);

    return "details-page";
}
}