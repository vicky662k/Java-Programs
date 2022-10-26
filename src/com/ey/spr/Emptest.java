package com.ey.spr;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;

public class Emptest {

	public static void main(String[] args) {

		@SuppressWarnings("resource")
		ApplicationContext ioc= new AnnotationConfigApplicationContext(Iocnt.class);
		JdbcTemplate t =(JdbcTemplate)ioc.getBean("jdbctemp");

		String sql;

		//sql="insert test.employee(emp_id,employee_name,age,gender)values(3,'Reshma',24,'F')";
		//sql="insert test.payroll(emp_id,salary,bank_name)values(2,250,'Axis')";
		//sql="update test.payroll set bank_name ='HDFC' where bank_name='null'";
		//t.execute(sql);

		//"select * from test.employee E inner join test.payroll P on E.emp_id=P.emp_id where salary !='null' order by E.emp_id "

		List<Employee> elist= new ArrayList<>();
		t.query("select * from test.employee E inner join test.payroll P on E.emp_id=P.emp_id where salary !='null' order by E.emp_id ", new ResultSetExtractor <List<Employee>>() {
			public List<Employee> extractData(ResultSet rs) throws SQLException,DataAccessException{

				while(rs.next()) {
					Employee e=new Employee();
					e.setId(rs.getInt("emp_id"));
					e.setName(rs.getString("employee_name"));
					e.setAge(rs.getInt("age"));
					e.setGend(rs.getString("gender"));
					e.setSal(rs.getFloat("salary"));
					e.setBank(rs.getString("bank_name"));

					elist.add(e);
				}
				return elist;
			}
		});

		elist.stream().forEach(x->{
			System.out.println(x.getId()+"\t"+x.getName()+"\t"+x.getAge()+"\t"+x.getGend()+"\t"+x.getSal()+"\t"+x.getBank());
		});
	}
}
