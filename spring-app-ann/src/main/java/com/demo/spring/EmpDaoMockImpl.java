package com.demo.spring;

import org.springframework.stereotype.Repository;

import com.demo.spring.entity.Emp;

@Repository
public class EmpDaoMockImpl implements EmpDao {
	
	

	@Override
	public String save(Emp e) {
		
		return "Emp Saved with id "+e.getEmpId();
	}

}
