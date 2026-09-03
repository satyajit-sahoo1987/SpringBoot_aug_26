package com.jt.intr_to_rest;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tools.jackson.core.JacksonException;
import tools.jackson.databind.ObjectMapper;

// @Controller
// @ResponseBody 
@RestController  
public class StudentController {
    private ObjectMapper mapper;
    public StudentController(ObjectMapper mapper){
     this.mapper=mapper;
    }
    @RequestMapping(value="/student" ,method=RequestMethod.GET)
    // @ResponseBody //it tells Springboot to return a JSON Object instead of a view file
    public Student getStudent(){
        
        Student student= new Student(101,"Rahul",new String[]{"Java","Python"});
        System.out.println("/////"+student);
        return student;
    }
    @RequestMapping("/student1")
    public Student convtJavaObjToJSON() throws JacksonException{
        Student student=new Student(101,"Rahul",new String[]{"Python","Spring"});
       
        String json=mapper.writeValueAsString(student);
        System.out.println("Java to JSON :"+json);
        return student;//if we only print then use void no return type-in terminal
    }
    @RequestMapping("/student2")
    public Student convtJSONobjToJavaObj() throws JacksonException{
        String json="""
                {
        "id":102,
"name":"Ankit",
"courses":["c","c++"] 
      }
                """;
                Student student=mapper.readValue(json,Student.class);
                System.out.println("After converting from json to java object"+student);
                return student;//if we only print then use void no return type-in terminal
    }
     @RequestMapping("/fruits")
    //  @ResponseBody//it tells Springboot to return a JSON Object instead of a view file
    public List<String>getStrings(){
        return List.of("Apple","Mango","Grapes");
    }
}
