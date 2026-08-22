package com.jt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BeanLifeCycleApplication {

	public static void main(String[] args) {
		var context=SpringApplication.run(BeanLifeCycleApplication.class, args);
         var greet=context.getBean(Greet.class);
		 greet.greet();
	}
	/*
	Bean Life Cycle
	1.Bean Instantiated - bean object is created- constructor
	2.Dependency Injected(if available) - by using any way of DI
	3.Bean Initialized  - PostConstruct
	4.Bean used
	5.Bean Destroyed    - @PreDestroy

	-Managed by Spring Container-
	 */

}
