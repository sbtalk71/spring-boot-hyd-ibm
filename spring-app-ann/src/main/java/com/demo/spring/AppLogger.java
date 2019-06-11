package com.demo.spring;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class AppLogger {
	@Pointcut("execution(* com.demo.spring.HrService.register*(..))")
	private void pcut() {}

	@Before("pcut()")
	public void logBefore() {
		System.out.println("Before method call...");
	}
	
	@AfterReturning("pcut()")
	public void logAfter() {
		System.out.println("After method call...");
	}
}
