package com.demo.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
public class HrController {

	@Autowired
	private RestTemplate rt;

	@GetMapping(path = "/hr/get/{id}", produces = "application/json")
	@HystrixCommand(fallbackMethod="fallback1")
	public ResponseEntity<String> getEmpDetails(@PathVariable("id")int empid) {
		HttpHeaders headers = new HttpHeaders();
		headers.set("Accept", "application/json");

		HttpEntity entity = new HttpEntity<>(headers);

		ResponseEntity<String> response = rt.exchange("http://emp-service/emp/find?id="+empid, HttpMethod.GET, entity,
				String.class);
		return response;
	}
	
	

	@GetMapping(path = "/hr/list", produces = "application/json")
	public ResponseEntity<String> listAllEmps() {
		HttpHeaders headers = new HttpHeaders();
		headers.set("Accept", "application/json");

		HttpEntity entity = new HttpEntity<>(headers);

		ResponseEntity<String> response = rt.exchange("http://emp-service/emp", HttpMethod.GET, entity,String.class);
		return response;
	}
	
	
	//fallbacks
	
	public ResponseEntity<String> fallback1(int empid) {
		return ResponseEntity.ok("Emp Details Service is down, try after sometime");
	}
}
