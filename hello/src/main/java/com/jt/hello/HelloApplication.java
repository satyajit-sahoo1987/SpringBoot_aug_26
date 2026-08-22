package com.jt.hello;
import com.Teacher;
import com.jt.Employee;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportResource;
import org.springframework.stereotype.Component;
@ImportResource("beans.xml")
@SpringBootApplication
// @ComponentScan(basePackages={"com."})
@ComponentScan(basePackages={"com.jt"})
public class HelloApplication {

	public static void main(String[] args) {
		ApplicationContext context= SpringApplication.run(HelloApplication.class, args);
		//1.using XML file
		Greet greet=context.getBean(Greet.class);
		greet.sayHello();
		//2.using stereotype annotation
		Person person=context.getBean(Person.class);
		person.sayHello();
        
		//3.using configuration file
        Student std=context.getBean(Student.class);
		std.sayHello();

        // //outside package
		// Teacher teacher=context.getBean(Teacher.class);
		// teacher.sayHello();

		Employee emp1=context.getBean(Employee.class);
		emp1.show();
		System.out.println("Employee1:"+emp1.hashCode());
		Employee emp2=context.getBean(Employee.class);
		System.out.println("Employee2:"+emp2.hashCode());

		// System.out.println("techer1:"+teacher.hashCode());
		// Teacher teacher1=context.getBean(Teacher.class);
		// System.out.println("teacher2:"+teacher1.hashCode());

		System.out.println("student1:"+std.hashCode());
		Student std2=context.getBean(Student.class);
		System.out.println("student2:"+std2.hashCode());
		System.out.println("greet1:"+greet.hashCode());
		Greet greet2=context.getBean(Greet.class);
		System.out.println("greet2:"+greet2.hashCode());
		
	}
	 
}
