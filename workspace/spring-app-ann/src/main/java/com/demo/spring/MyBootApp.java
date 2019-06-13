package com.demo.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MyBootApp {

	public static void main(String[] args) {
		SpringApplication.run(MyBootApp.class, args);
		
		System.out.println("Hello Spring Boot");

	}

}
