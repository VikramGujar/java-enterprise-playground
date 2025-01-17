package com.practice.jan_07;

import java.sql.*;
import java.util.Scanner;

public class EmployeeDataManagment 
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
				System.out.println("\n\n==================Employee management System================\n\n");
				System.out.println(
						  "1. Add Employee\n"
						+ "2. Get employee by Id\n"
						+ "3. Remove employee by Id\n"
						+ "4. Update employee by Id\n"
						+ "4. Display all employee\n"
						+ "5. Exit\n");
				
				System.out.println("Enter your choice");
				int choice = Integer.parseInt(sc.nextLine());
				
				switch (choice) 
				{
					case 1: 
					{
						System.out.println("Enter ID :");
						int id = Integer.parseInt(sc.nextLine());
						
						System.out.println("Enter NAME :");
						String name = sc.nextLine();
						
						System.out.println("Enter DESIGNATION :");
						String designation = sc.nextLine();
						
						System.out.println("Enter BASIC SALARY :");
						double sal = Double.parseDouble(sc.nextLine());
						
						double hra = 0.96 * sal;
						double da = 0.61 * sal;
						double tSal = sal + hra + da; 
						
						int update = st.executeUpdate("Insert into employee70 values "
								+ "("+id+",'"+name+"', '"+designation+"', "+sal+", "+hra+", "+da+", "+tSal+")");
			
						if(update>0)
							System.out.println("Employee added succefully!!!");
						else
							System.out.println("Employee already exist");
						break;
					}					
					case 2:
					{
						System.out.println("Enter ID to retrive Employee :");
						int retriveId = Integer.parseInt(sc.nextLine());
						ResultSet rs = st.executeQuery("Select * from employee70 where eid = "+retriveId+"");
						System.out.println("Employee with  ID "+retriveId+" is :");
						while(rs.next())
						{
							int id = rs.getInt(1);
							String name = rs.getString(2);
							String des = rs.getString(3);
							double sal = rs.getDouble(4);
							double hra = rs.getDouble(5);
							double da = rs.getDouble(6);
							double tSal = rs.getDouble(7);
							
							System.out.println
							(id+" \t "+name+" \t "+des+" \t "+sal+" \t "+hra+" \t "+da+" \t "+tSal+"");
							
						}
						break;
					}
					case 3:
					{
						System.out.println("Enter id of Employee you want to Remove :");
						int removeId = Integer.parseInt(sc.nextLine());
						
						int update = st.executeUpdate
								("delete from employee70 where eid ="+removeId+"" );
						
						if(update>0)
							System.out.println("Id "+removeId+" record deleted succesfully!");
						else
							System.out.println("Record not deleted");
						break;
					}
					case 4:
					{
						System.out.println("**********-Employee Data-***********");
						//System.out.println("ID \t NAME \t DESIGNATION \t SALARY \t HRA \t DA \t TOTAL SALARY  ");
						ResultSet rs = st.executeQuery("select * from employee70");
						while(rs.next())
						{
							int id = rs.getInt(1);
							String name = rs.getString(2);
							String des = rs.getString(3);
							double sal = rs.getDouble(4);
							double hra = rs.getDouble(5);
							double da = rs.getDouble(6);
							double tSal = rs.getDouble(7);
							
							System.out.println
							(id+" \t "+name+" \t "+des+" \t "+sal+" \t "+hra+" \t "+da+" \t "+tSal+"");
							
						}
						break;
					}
					case 5:
					{
						System.out.println("Thank You For visit\nBye bye!!!");
						System.exit(0);
					}
					default:
					System.err.println("Invalid input! Try again.");
				}
			
			}
			
						
			
			
			
		}catch (Exception e) 
		{
			e.printStackTrace();
		}
		

	}

}

