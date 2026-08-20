package com.jt.dependency_injection;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class DependencyInjectionApplication {

	public static void main(String[] args) {
		ApplicationContext context=SpringApplication.run(DependencyInjectionApplication.class, args);
		// Engine engine=context.getBean(Engine.class);
		// engine.startEngine();

		Car car=context.getBean(Car.class);
		car.startCar();
		car.stopCar();
	}

}
