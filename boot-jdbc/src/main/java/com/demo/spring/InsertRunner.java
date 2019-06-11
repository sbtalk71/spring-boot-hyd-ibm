package com.demo.spring;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.stereotype.Component;

//@Component
public class InsertRunner implements CommandLineRunner {

	@Autowired
	JdbcTemplate jt;
	
	@Override
	public void run(String... args) throws Exception {
		
		String INSERT_STMT="insert into emp(empno,name,address,salary) values(?,?,?,?)";
		
		int rows=jt.update(new PreparedStatementCreator() {
			
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				PreparedStatement pst= con.prepareStatement(INSERT_STMT);
				pst.setInt(1, 107);
				pst.setString(2, "John");
				pst.setString(3, "Pune");
				pst.setDouble(4, 89000);
				return pst;
			}
		});
		
		System.out.println("Rows Inserted : "+rows);
	}

}
