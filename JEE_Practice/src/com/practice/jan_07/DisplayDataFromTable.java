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
		Class.forName("orcle.jdbc.driver.OracleDriver");
		
		//Step-2 : Creating Connection
		//jdbc:oracle:thin:@localhost:1521:xe
		//Username = system
		//Password = tonystark
		Connection con = DriverManager.getConnection(null)
		
		// Step-3 : Creating JDBC-statement
		
		
		//Step-4 : Executing query
		
		
		// Step-5 : Closing the Connection
		}catch (Exception e) 
		{
			e.printStackTrace();
		}

	}

}
