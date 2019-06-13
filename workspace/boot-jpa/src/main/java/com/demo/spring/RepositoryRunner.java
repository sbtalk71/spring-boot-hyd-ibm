package com.demo.spring;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.demo.spring.entity.Emp;

@Component
public class RepositoryRunner implements CommandLineRunner {
	@Autowired
	EmpRepository repo;
	
	@Override
	public void run(String... args) throws Exception {
		
			repo.save(new Emp(110, "Manoj", "Chennai", 77000));
			
			Optional<Emp> o=repo.findById(114);
			if(o.isPresent()) {
				System.out.println(o.get());
			}else {
				System.out.println("No Emp Found");
			}
			
			
			//repo.findAll().stream().forEach(System.out::println);
			repo.getEmpWithin(40000, 80000).stream().forEach(System.out::println);
			
			
	}
}
