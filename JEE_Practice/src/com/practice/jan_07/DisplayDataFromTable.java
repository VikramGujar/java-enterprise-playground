package com.practice.jan_07;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DisplayDataFromTable 
{

	public static void main(String[] args) 
	{
		try
		{

		// Step-1 : Loading driver
		// Path for Driver = "oracle.jdbc.driver.OracleDriver"
		Class.forName("oracle.jdbc.driver.OracleDriver");
		
		//Step-2 : Creating Connection
		//Database URL = jdbc:oracle:thin:@localhost:1521:xe
		//Username     = system
		//Password     = tonystark
		//Connection con = DriverManager.getConnection(dburl,uname,pass);
		Connection con = DriverManager.getConnection
				("jdbc:oracle:thin:@localhost:1521:xe","system","tonystark");
		
		// Step-3 : Creating JDBC-statement
		Statement st = con.createStatement();
		
		//Step-4 : Executing query
		//Execute query for select operations in SQL
		ResultSet rs = st.executeQuery("select * from employees");
		
		while(rs.next())
		{
			int id = rs.getInt(1);
			String name = rs.getString(2);
			double salary = rs.getDouble(3);
			
			System.out.println("Employee : [Id :"+id+"\t Name :"+name+"\t Salary :"+salary+"]");
		}
		
		// Step-5 : Closing the Connection
		}catch (Exception e) 
		{
			e.printStackTrace();
		}

	}

}
