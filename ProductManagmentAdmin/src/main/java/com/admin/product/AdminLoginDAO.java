package com.admin.product;
import java.sql.*;


public class AdminLoginDAO 
{
	public AdminBean ab = null;
	
	public AdminBean login(String username, String password)
	{
		try
		{
			Connection con = DBConnection.getCon();
			
			PreparedStatement pst = con.prepareStatement
					("select * from Admin70 where uname=? and pword=?");
			
			pst.setString(1, username);
			pst.setString(2, password);
			
			ResultSet rs = pst.executeQuery();
			if(rs.next())
			{
				ab = new AdminBean();
				ab.setUserName(rs.getString(1));
				ab.setPassword(rs.getString(2));
				ab.setFirstName(rs.getString(3));
				ab.setLastName(rs.getString(4));
				ab.setCity(rs.getString(5));
				ab.setMailId(rs.getString(6));
				ab.setPhoneNumber(rs.getLong(7));
				
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return ab;
	}
}
