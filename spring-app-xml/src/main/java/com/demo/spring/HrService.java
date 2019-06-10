package com.demo.spring;

import com.demo.spring.entity.Emp;

public class HrService {

	private EmpDao dao;

	public void setDao(EmpDao dao) {
		this.dao = dao;
	}
	
	public String registerEmp(int id, String name, String city, double salary) {
			return dao.save(new Emp(id, name, city, salary));
	}
}
