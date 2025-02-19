package com.admin.product;

import java.sql.*;

public class DBConnection 
{

	private static Connection con = null;
	private DBConnection() {}
	
	static
	{
		try 
		{
			Class.forName(DBinfo.driver);
			con = DriverManager.getConnection
					(DBinfo.dbURL,DBinfo.dbUName,DBinfo.dbPassword);
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
	
	public static Connection getCon()
	{
		return con;
	}

}
