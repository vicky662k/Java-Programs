package com.ey.spr;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
public class Iocnt {
	
	@Bean
	public Stud stud() {
		return new Stud();
	}
	
	@Bean
	public Employee emp() {
		return new Employee();
	}
	
	@Bean
	public DataSource datasource() {
		DriverManagerDataSource ds = new DriverManagerDataSource();
		ds.setUrl("jdbc:mysql://localhost:3306/test");
		ds.setUsername("root");
		ds.setPassword("root");
		ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
		return ds;
	}
	
	@Bean
	public JdbcTemplate jdbctemp() {
		JdbcTemplate temp =  new JdbcTemplate();
		temp.setDataSource(datasource());
		return temp;
		
	}

}
