package com.demo.spring.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.demo.spring.EmpRepository;
import com.demo.spring.entity.Emp;

@RestController
public class EmpRestController {
	
	@Autowired
	private EmpRepository repo;
	
	@RequestMapping(path="/emp/find/{id}",
			method=RequestMethod.GET,
			produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity findEmp(@PathVariable("id")int id) {
		
		Optional<Emp> o=repo.findById(id);
		if(o.isPresent()) {
			return ResponseEntity.ok(o.get());
		}else {
			return ResponseEntity.ok("{\"status\":\"No Employee Found\"}");
		}
	}

}
