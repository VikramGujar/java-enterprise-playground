package com.user;

import java.sql.Connection;
import java.sql.DriverManager;

public class DbConnection 
{
	private static Connection con = null;
	
	private DbConnection() {}
	
	static 
	{
		try 
		{
			Class.forName(DbInfo.driver);
			con = DriverManager.getConnection
					(DbInfo.dbURL,DbInfo.dbUName,DbInfo.dbPass);
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
