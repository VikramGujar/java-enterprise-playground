package com.practice.jan_23;

import java.util.*;
import java.sql.*;


public class ProcedureDemo 
{

	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		
		try 
		{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		
		Connection con = DriverManager.getConnection
		("jdbc:oracle:thin:@localhost:1521:xe","system","tonystark");
		
		CallableStatement cs = con.prepareCall("{call CreateStudent70(?,?,?,?,?,?,?,?,?)}");
		
		cs.setInt(1, 1);//id
		cs.setInt(2, 1);//Roll
		cs.setString(3, "Sai");//Name
		cs.setString(4, "B-Tech");//Branch
		cs.setInt(5, 007);//H-No
		cs.setString(6, "HYD");//City
		cs.setInt(7, 43011);//P-Code
		cs.setString(8, "sai@gamil.com");//Mail
		cs.setInt(9, 96563);//Phone
		
		cs.execute();
		System.out.println("Success");
		
		
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}

	}

}
