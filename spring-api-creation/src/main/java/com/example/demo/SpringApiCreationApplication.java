package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringApiCreationApplication {

	public static void main(String[] args) {
	ApplicationContext context=	SpringApplication.run(SpringApiCreationApplication.class, args);
	
//	for(String s:context.getBeanDefinitionNames()) {
//		//System.out.println("All App context is "+s);
//	}
	}

}
