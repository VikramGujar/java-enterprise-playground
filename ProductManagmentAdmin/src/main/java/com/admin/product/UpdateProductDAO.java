package com.admin.product;

import java.sql.*;

public class UpdateProductDAO 
{

	public int k = 0;
	public int update(ProductBean pb)
	{
		try 
		{
			Connection con = DBConnection.getCon();
			PreparedStatement pst = con.prepareStatement
					("update Product70 set price=?,qty=? where code=?");
			
			pst.setFloat(1, pb.getPrice());
			pst.setInt(2, pb.getQty());
			pst.setString(3, pb.getCode());
			
			k = pst.executeUpdate();
			
		}catch (Exception e) 
		{
			
		}
		return k;
	}
}
