package com.demo.spring.client;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.demo.spring.AppConfig;
import com.demo.spring.HrService;

public class MainApp1 {

	
	public static void main(String[] args) {
		ApplicationContext ctx=new AnnotationConfigApplicationContext(AppConfig.class);
		HrService service=(HrService)ctx.getBean("hrService");
		System.out.println(service.registerEmp(100, "A", "B", 45000));

	}

}
