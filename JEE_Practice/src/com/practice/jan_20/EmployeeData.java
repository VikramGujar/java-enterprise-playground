package com.practice.jan_20;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EmployeeData 
{

	public static void main(String[] args) 
	{
		
		Scanner sc = new Scanner(System.in);
		List<Employee> empList = new ArrayList<Employee>();
		try (sc;)
		{
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			Connection con = DriverManager.getConnection
					("jdbc:oracle:thin:@localhost:1521:xe","system","tonystark");
			
			
			Statement st = con.createStatement();
		
		
			ResultSet rs = st.executeQuery("Select * from employee20");
			
			
			while(rs.next())
			{
				
				int id = rs.getInt(1);
				String name = rs.getString(2);
				int age = rs.getInt(3);
				double sal = rs.getDouble(4);
				
				empList.add( new Employee(id, name, age, sal)); 
				/*
				System.out.println(" Id = "
						+id+ "Name = "
						+name+ "Age = "
						+age+ "Salary = "
								+sal+ " ");
								*/
			}
			empList.forEach(System.out::println);
			
			
		
			
		} catch (Exception e) 
		{
			
		}

	}

}
