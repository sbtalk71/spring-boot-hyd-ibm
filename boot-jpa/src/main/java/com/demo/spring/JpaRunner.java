package com.demo.spring;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.demo.spring.entity.Emp;

//@Component
@Transactional
public class JpaRunner implements CommandLineRunner {

	@PersistenceContext
	EntityManager em;
	
	@Override
	public void run(String... args) throws Exception {
		
		Emp e= new Emp(108, "Pavan", "Hyderabad", 80000);
		//em.persist(e);
		
		
		Emp e1=em.find(Emp.class, 108);
		System.out.println(e1);
		
		
		Query query=em.createQuery("select e from Emp as e");
		List<Emp> empList=query.getResultList();
		
		for(Emp e2:empList) {
			System.out.println(e2);
		}

	}

}
