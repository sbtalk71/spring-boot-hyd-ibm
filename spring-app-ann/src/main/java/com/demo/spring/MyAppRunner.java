package com.demo.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class MyAppRunner implements CommandLineRunner {

	@Autowired
	HrService service;
	@Override
	public void run(String... args) throws Exception {
		System.out.println(service.getClass().getName());
		System.out.println(service.registerEmp(100, "A", "B", 45000));

	}

}
