package com.demo.spring.client;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.demo.spring.HrService;

public class MainApp1 {

	public static void main(String[] args) {
		ApplicationContext ctx=new ClassPathXmlApplicationContext("context.xml");
		HrService service=(HrService)ctx.getBean("service");
		System.out.println(service.registerEmp(100, "A", "B", 45000));

	}

}
