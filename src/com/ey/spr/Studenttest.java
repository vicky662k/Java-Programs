package com.ey.spr;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Studenttest {
		
	public static void main(String[] args) {
		Map<Integer,Student> smap = new HashMap<>();
		@SuppressWarnings("resource")
		ApplicationContext ioc = new AnnotationConfigApplicationContext(Ioc.class);
		Student s1=(Student)ioc.getBean("stud");
		s1.setId(1);
		s1.setName("Ramu");
		s1.setSub("PHY");
		//s1.print();
		smap.put(s1.getId(), s1);
		Student s2=(Student)ioc.getBean("stud");
		s2.setId(2);
		s2.setName("Manu");
		s2.setSub("Chem");
		//s2.print();
		smap.put(s2.getId(), s2);
		
		Student s3=(Student)ioc.getBean("stud");
		s3.setId(3);
		s3.setName("Shyam");
		s3.setSub("Maths");
		//s3.print();
		smap.put(s3.getId(), s3);
		
		Student s4=(Student)ioc.getBean("stud");
		s4.setId(4);
		s4.setName("Rajesh");
		s4.setSub("IT");
		//s4.print();
		smap.put(s4.getId(), s4);
		
		Student s5=(Student)ioc.getBean("stud");
		s5.setId(5);
		s5.setName("Mohan");
		s5.setSub("EVS");
		//s5.print();
		smap.put(s5.getId(), s5);
				
		ArrayList<Integer> t= new ArrayList<>();
		t.addAll(smap.keySet());
		for(Integer i: t) {
			System.out.println(smap.get(i).getId()+"\t"+smap.get(i).getName()+"\t"+smap.get(i).getSub());
		}
		
		
		
	}

}
