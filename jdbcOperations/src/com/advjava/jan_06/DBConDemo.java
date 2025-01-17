package com.advjava.jan_06;

import java.sql.*;
public class DBConDemo
{

	public static void main(String[] args)
	{
		try {
			
			// Step-1 : Loading driver
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			//Step-2 : Creating Connection
			Connection con = DriverManager.getConnection
					("jdbc:oracle:thin:@localhost:1521:xe","system","tonystark");
			
			// Step-3 : Creating JDBC-statement
			Statement stm = con.createStatement();
			
			//Step-4 : Executing query
			ResultSet rs = stm.executeQuery("select * from students");
			
			System.out.println("-------Student Details------");
			
			while(rs.next())
			{
				System.out.println(rs.getInt(1)+"\t"+rs.getString(2));
			
			}//end of loop
			
			// Step-5 : Closing the Connection
			con.close();
		}catch(Exception e) 
		{
			e.printStackTrace();
		}
	}
}
