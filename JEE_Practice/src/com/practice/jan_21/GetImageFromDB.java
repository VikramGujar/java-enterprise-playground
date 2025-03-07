package com.practice.jan_21;

import java.io.FileOutputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class GetImageFromDB 
{

	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		try(sc;) 
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			Connection con = DriverManager.getConnection
					("jdbc:oracle:thin:@localhost:1521:xe","System","tonystark");
			
			Statement st = con.createStatement();
			
			ResultSet rs = st.executeQuery("select * from empinfo21");
			
			while(rs.next())
			{
				Blob b = rs.getBlob(6);
				byte by[] = b.getBytes(1, (int)b.length());
				
				System.out.println("Enter the path :");
				String path = sc.nextLine();
				
				FileOutputStream fos = new FileOutputStream(path);
				
				fos.write(by);
				
				System.out.println("Image REtrive succses");
			}
			
			
		} catch (Exception e) 
		{
			e.printStackTrace();
		}

	}

}
