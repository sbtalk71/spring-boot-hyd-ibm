package com.demo.spring.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.demo.spring.EmpRepository;
import com.demo.spring.entity.Emp;

@RestController
public class EmpRestController {
	
	@Autowired
	private EmpRepository repo;
	
	/*@RequestMapping(path="/emp/find/{id}",
			method=RequestMethod.GET,
			produces=MediaType.APPLICATION_JSON_VALUE)*/
	
	@GetMapping(path="/emp/find",
	produces= {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
	public ResponseEntity findEmp(@RequestParam("id")int id) {
		
		Optional<Emp> o=repo.findById(id);
		if(o.isPresent()) {
			return ResponseEntity.ok(o.get());
		}else {
			return ResponseEntity.ok("{\"status\":\"No Employee Found\"}");
		}
	}
	
	@PostMapping(path="/emp/save",
			consumes=MediaType.APPLICATION_JSON_VALUE,
			produces=MediaType.TEXT_PLAIN_VALUE)
	public ResponseEntity<String> saveEmp(@RequestBody Emp e){
		
		if(repo.existsById(e.getEmpId())) {
			return ResponseEntity.ok("Employee exists in the database");
		}else {
			repo.save(e);
			return ResponseEntity.ok("Employee saved successfully..");
		}
	}
	@PutMapping(path="/emp/update",
			consumes=MediaType.APPLICATION_JSON_VALUE,
			produces=MediaType.TEXT_PLAIN_VALUE)
	public ResponseEntity updateEmp(@RequestBody Emp e) {
		repo.save(e);
		return ResponseEntity.ok("Employee updated successfully..");
	}
	
	@DeleteMapping(path="/emp/delete",
						produces=MediaType.TEXT_PLAIN_VALUE)
	public ResponseEntity deleteEmp(@RequestParam("id")int id) {
		
		if(repo.existsById(id)) {
			repo.deleteById(id);
			return ResponseEntity.ok("Employee deleted successfully..");
		}else {
			return ResponseEntity.ok("Employee Does not exist");
		}
	}

}
