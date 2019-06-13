package com.demo.spring;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.demo.spring.entity.Emp;

//@Component
public class RestClient1 implements CommandLineRunner {

	@Override
	public void run(String... args) throws Exception {
		RestTemplate rt= new RestTemplate();
		
		ResponseEntity<Emp> response=rt.getForEntity("http://localhost:8081/emp/find?id=106", Emp.class);
			
		System.out.println(response.getBody());
		
		
		//---
		HttpHeaders headers=new HttpHeaders();
		headers.set("Accept", "application/json");
		
		HttpEntity entity=new HttpEntity<>(headers);
		
		ResponseEntity<String> response1=rt.exchange("http://localhost:8081/emp/find?id=106",HttpMethod.GET,entity,String.class);
	
		System.out.println(response1.getBody());
		
		ResponseEntity<List<Emp>> responseList=rt.exchange("http://localhost:8081/emp",HttpMethod.GET,
				entity,
				new ParameterizedTypeReference<List<Emp>>() {
		});
		
		responseList.getBody().stream().forEach(System.out::println);
	}

}
