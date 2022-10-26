package com.ey.spr;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyConfig {

	@Bean
	public PersnBean p() {
		return new PersnBean();
	}

}
