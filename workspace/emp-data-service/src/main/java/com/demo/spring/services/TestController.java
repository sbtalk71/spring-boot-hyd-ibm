package com.demo.spring.services;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

	@RequestMapping(path="/greet/{n}",method=RequestMethod.GET)
	public String greet( @PathVariable("n")String name) {
		return name+", Welcome to Spring REST";
	}
}
