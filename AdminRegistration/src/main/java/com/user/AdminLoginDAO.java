package com.user;

import java.sql.*;


public class AdminLoginDAO 
{
	public AdminBean ab = null;
	
	public AdminBean login(String userName, String password)
	{
		try
		{
			Connection con = DbConnection.getCon();
			PreparedStatement pst = con.prepareStatement
					("select * from Admin70 where uname=? and pword=?");
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		return ab;
	}
}
