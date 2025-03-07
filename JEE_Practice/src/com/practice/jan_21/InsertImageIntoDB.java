package com.practice.jan_21;

import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class InsertImageIntoDB 
{

	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		try 
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			Connection con = DriverManager.getConnection
					("jdbc:oracle:thin:@localhost:1521:xe","System","tonystark");
			
			PreparedStatement pt = con.prepareStatement("insert into empinfo21 values (?,?,?,?,?,?)");
			
			System.out.println("Enter ID :");
			int id = Integer.parseInt(sc.nextLine());
			
			System.out.println("Enter Name :");
			String name = sc.nextLine();
			
			System.out.println("Enter Address :");
			String add = sc.nextLine();
			
			System.out.println("Enter Mail :");
			String mail = sc.nextLine();
			
			System.out.println("Enter Phone :");
			long phone = Long.parseLong(sc.nextLine());
			sc.nextLine();
			
			System.out.println("Enter Picture addres :");
			String picPath = sc.nextLine();
			
			
			
			pt.setInt(1, id);
			pt.setString(2, name);
			pt.setString(3, add);
			pt.setString(4, mail);
			pt.setLong(5, phone);
			
			
			File f = new File(picPath);
			
			if(f.exists())
			{
				FileInputStream fs = new FileInputStream(picPath);
				pt.setBinaryStream(6, fs, f.length());
				
				
			}
			
			int update = pt.executeUpdate();
			
			if(update>0)
				System.out.println("Success");
			else
				System.out.println("Failed");
			
			
			
		} catch (Exception e) 
		{
			e.printStackTrace();
		}

	}

}
