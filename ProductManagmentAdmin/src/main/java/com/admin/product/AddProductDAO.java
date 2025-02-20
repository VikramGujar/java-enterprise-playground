package com.admin.product;

import java.sql.*;


public class AddProductDAO 
{
	public int k = 0;
	
	public int insertProduct(ProductBean pb)
	{
		try
		{
			Connection con = DBConnection.getCon();
			PreparedStatement pst = con.prepareStatement
					("insert into Product70 values(?,?,?,?)");
			pst.setString(1, pb.getCode());
			pst.setString(2, pb.getName());
			pst.setFloat(3, pb.getPrice());
			pst.setInt(4, pb.getQty());
			
			k = pst.executeUpdate();
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		return k;
	}
}
