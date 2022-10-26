package com.ey.spr;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Ioc {
	
	@Bean
	public Student stud() {
		return new Student();
	}

}
