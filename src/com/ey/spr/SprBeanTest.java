package com.ey.spr;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SprBeanTest {
		
		public static void main(String[] args) {
			@SuppressWarnings("resource")
			ApplicationContext ioc = new AnnotationConfigApplicationContext(MyConfig.class);
			PersnBean person =(PersnBean)ioc.getBean("p");
			person.setId(1);
			person.setName("java");
			person.print();
		
		}

}
