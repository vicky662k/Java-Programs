package com.ey.spr;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;

public class Studtest {

	public static void main(String[] args) {
		//String n ,b;
		//int r,a;
		@SuppressWarnings("resource")
		ApplicationContext ioc= new AnnotationConfigApplicationContext(Iocnt.class);
		JdbcTemplate t =(JdbcTemplate)ioc.getBean("jdbctemp");
		Scanner sc= new Scanner(System.in);
		String sql;
		for(int i=0;i<9;i++)
		{sql="insert test.student(roll_no,student_name,age,branch)values(7,'ramu',12,'it')";
		t.execute(sql);
		}
		/**for(int i=1;i<=10;i++) {
			System.out.println("Enter Student"+i+"detail...");
			System.out.println("Enter Student roll no.: ");
			r=sc.nextInt();
			System.out.println("Enter Student name: ");
			n=sc.next();
			System.out.println("Enter Student age: ");
			a=sc.nextInt();
			System.out.println("Enter Student branch: ");
			b=sc.next();
			sql="insert test.student(roll_no,student_name,age,branch)values("+r+","+n+","+a+","+b+")";
			t.execute(sql);
		}*/
		
		List<Stud> slist= new ArrayList<>();
		t.query("select * from test.student", new ResultSetExtractor <List<Stud>>() {
			public List<Stud> extractData(ResultSet rs) throws SQLException,DataAccessException{
				
				while(rs.next()) {
					Stud s=new Stud();
					s.setRoll(rs.getInt("roll_no"));
					s.setName(rs.getString("student_name"));
					s.setAge(rs.getInt("age"));
					s.setBranch(rs.getString("branch"));
					
					slist.add(s);
				}
				return slist;
			}
		});
		
		slist.stream().forEach(x->{
			System.out.println(x.getRoll()+"\t"+x.getName()+"\t"+x.getAge()+"\t"+x.getBranch());
		});
	}
}
