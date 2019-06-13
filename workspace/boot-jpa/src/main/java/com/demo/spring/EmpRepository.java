package com.demo.spring;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.demo.spring.entity.Emp;

public interface EmpRepository extends JpaRepository<Emp, Integer> {

	
	@Query(value="select o from Emp as o where salary between ?1 and ?2")
	public List<Emp> getEmpWithin(double sal1,double salary2);
}
