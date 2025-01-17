package com.practice.jan_07;

import java.sql.*;
import java.util.Scanner;


public class ProductDataHandling 
{

	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		
		try(sc;) 
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection
					("jdbc:oracle:thin:@localhost:1521:xe","system","tonystark");
			
			Statement st = con.createStatement();
			
			while(true)
			{
				System.out.println("********************Product Data Management********************");
				System.out.println(
						"\t1. Add Product\n"
						+"\t2. Display All Products\n"
						+ "\t3.Display Product by ID\n\n"
						+ "Enter Your Choice : ");
				int choice = Integer.parseInt(sc.nextLine());
				
				switch (choice) 
				{
					case 1: 
					{
						System.out.println("Enter product ID :");
						int prodId = Integer.parseInt(sc.nextLine());
						
						System.out.println("Enter product Name :");
						String prodName = sc.nextLine();
						
						System.out.println("Enter product Price :");
						double prodPrice = Double.parseDouble(sc.nextLine());
						
						int update = st.executeUpdate
								("Insert into flipProd values ("+prodId+",'"+prodName+"',"+prodPrice+")");
					
						if(update>0)
							System.out.println("Product added succesfully!!!");
						else
							System.out.println("Product already exist");
						break;
					}
					case 2:
					{
						System.out.println("**********-Product Data-***********");
						System.out.println("\t ID \t NAME \t PRICE");
						ResultSet rs = st.executeQuery("select * from flipprod");
						while(rs.next())
						{
							int id = rs.getInt(1);
							String name = rs.getString(2);
							double price = rs.getDouble(3);
							System.out.println("\t "+id+" \t "+name+" \t "+price);
							
						}
						break;
					}
					case 3:
					{
						System.out.println("Enter ID to retrive product :");
						int retriveId = Integer.parseInt(sc.nextLine());
						ResultSet rs = st.executeQuery("Select * from flipprod where id = "+retriveId+"");
						System.out.println("Record with product ID "+retriveId+" is :");
						while(rs.next())
						{
							int id = rs.getInt(1);
							String name = rs.getString(2);
							double price = rs.getDouble(3);
							System.out.println("\t "+id+" \t "+name+" \t "+price);
							
						}
						break;
					}
					case 4:
					{
						System.out.println("Thank You For visit\nBye bye!!!");
						System.exit(0);
					}
					default:
					System.err.println("Invalid input! Try again.");
				}
				
			}
			
			
			
		} catch (Exception e) 
		{
			e.printStackTrace();
		}

	}

}
