package com.demo.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.demo.spring.entity.Emp;

@Service
public class HrService {

	@Autowired
	@Qualifier("empDaoJdbcImpl")
	private EmpDao dao;
	
	
	public String registerEmp(int id, String name, String city, double salary) {
			return dao.save(new Emp(id, name, city, salary));
	}
}
