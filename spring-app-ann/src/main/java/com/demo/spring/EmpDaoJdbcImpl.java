package com.demo.spring;

import org.springframework.stereotype.Repository;

import com.demo.spring.entity.Emp;

@Repository
public class EmpDaoJdbcImpl implements EmpDao {
	
	

	@Override
	public String save(Emp e) {
		
		return "JDBC:Emp Saved with id "+e.getEmpId();
	}

}
