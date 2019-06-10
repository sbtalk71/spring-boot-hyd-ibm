package com.demo.spring;

import com.demo.spring.entity.Emp;

public class EmpDaoJdbcImpl implements EmpDao {
	
	

	@Override
	public String save(Emp e) {
		
		return "JDBC:Emp Saved with id "+e.getEmpId();
	}

}
