package com.demo.spring;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

@Configuration
public class JpaConfig {
	
	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory(DataSource ds) {
		LocalContainerEntityManagerFactoryBean lb=new LocalContainerEntityManagerFactoryBean();
		lb.setDataSource(ds);
		lb.setPackagesToScan("com.demo.spring.entity");
		
		HibernateJpaVendorAdapter va= new HibernateJpaVendorAdapter();
		va.setDatabase(Database.MYSQL);
		va.setShowSql(true);
		lb.setJpaVendorAdapter(va);
		
		return lb;
	}
	
	@Bean
	public JpaTransactionManager transactionManager(EntityManagerFactory emf) {
		JpaTransactionManager txm= new JpaTransactionManager();
		txm.setEntityManagerFactory(emf);
		return txm;
	}

}
