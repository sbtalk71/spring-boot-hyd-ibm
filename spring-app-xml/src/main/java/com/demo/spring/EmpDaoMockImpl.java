package com.demo.spring;

import com.demo.spring.entity.Emp;

public class EmpDaoMockImpl implements EmpDao {
	
	

	@Override
	public String save(Emp e) {
		
		return "Emp Saved with id "+e.getEmpId();
	}

}
