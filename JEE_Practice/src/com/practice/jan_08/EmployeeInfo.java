package com.practice.jan_08;

import java.sql.*;
import java.util.Scanner;

public class EmployeeInfo 
{

	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		
		try(sc)
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			Connection con = DriverManager.getConnection
					("jdbc:oracle:thin:@localhost:1521:xe","System","tonystark");
			
			Statement st = con.createStatement();
			
			while(true)
			{
				System.out.println
				  ("\n\n**************Employee Management*****************\n\n"
				  +"1.Insert data into Employee Table.\n"
			      +"2.Update employee salary,empMailId and empPhNo with the help of eid.\n"
			      +"3.Find those employee whose name starts with 'A'.\n"
			      +"4.Count how many employee record present in table.  \n"      
			      +"5.delete employee who is getting maximum salary.\n"
			      +"6.Show all employee.\n"
			      +"7.Exit");
				
				System.out.println("\nEnter your choice");
				int choice = Integer.parseInt(sc.nextLine());
				
				switch (choice) 
				{
				case 1: 
				{
					System.out.println("Enter ID :");
					int id = Integer.parseInt(sc.nextLine());
					
					System.out.println("Enter NAME :");
					String name = sc.nextLine();
					
					System.out.println("Enter BASIC SALARY :");
					double sal = Double.parseDouble(sc.nextLine());
					
					System.out.println("Enter your Main Id :");
					String mailId = sc.nextLine();
					
					System.out.println("Enter your Phone Number :");
					long phone = Long.parseLong(sc.nextLine());
					
					int update = st.executeUpdate("Insert into employee_info values "
							+ "("+id+",'"+name+"', '"+sal+"', '"+mailId+"', "+phone+")");
		
					if(update>0)
						System.out.println("Employee added succefully!!!");
					else
						System.out.println("Employee already exist");
					break;
				}
				case 2: 
				{
					System.out.println("Enter id of employee you want to update :");
					int updateId = Integer.parseInt(sc.nextLine());
					
					ResultSet rs = st.executeQuery("Select * from employee_info where empid ="+updateId+"");
					
					if(!rs.next())
						System.out.println("No record avalable with Id "+updateId);
					else
					{
						System.out.println("Enter NAME to update :");
						String name = sc.nextLine();
						
						System.out.println("Enter BASIC SALARY to update :");
						double sal = Double.parseDouble(sc.nextLine());
						
						System.out.println("Enter your Main Id to update :");
						String mailId = sc.nextLine();
						
						System.out.println("Enter your Phone Number to update :");
						long phone = Long.parseLong(sc.nextLine());
						
						int update = st.executeUpdate("Update employee_info set EMPNAME ='"+name+"', empsal = "+sal+", EMPMAILID = '"+mailId+"', EMPPHONE = "+phone+" where empid = "+updateId+"  ");
						
						if(update>0)
							System.out.println("Record updated succesfully!");
						else
							System.out.println("Record not updated");
					}
					                                                                                        
					  
					
					
					break;
				}
				case 3: 
				{
					char alpha = 'A';
					ResultSet rs = st.executeQuery("SELECT * FROM employee_info WHERE empname LIKE '"+alpha+"%'");
					while(rs.next())
					{
						int id = rs.getInt(1);
						String name = rs.getString(2);
						double sal = rs.getDouble(3);
						String mailId = rs.getString(4);
						long phone = rs.getLong(5);
						
						
						System.out.println
						(id+" \t "+name+" \t "+sal+" \t "+mailId+" \t "+phone+"");
						
					}
					break;
				}
				case 4: 
				{
					int count = 0;
					ResultSet rs = st.executeQuery("select * from employee_info");
					while(rs.next())
					count++;
					
					System.out.println("There are "+count+" records present in table");
					
					break;
				}
				case 5: 
				{
					int update = st.executeUpdate("DELETE FROM employee_info WHERE EMPSAL = (SELECT MAX(EMPSAL) FROM employee_info)");
					if(update>0)
						System.out.println("Maximul salary employee deleted succesfully!");
					else
						System.out.println("Not deleted");
					break;
				}
				case 6: 
				{
					System.out.println("*****Available Employees******");
					ResultSet rs = st.executeQuery("select * from employee_info");
					while(rs.next())
					{
						int id = rs.getInt(1);
						String name = rs.getString(2);
						double sal = rs.getDouble(3);
						String mailId = rs.getString(4);
						long phone = rs.getLong(5);
						
						
						System.out.println
						(id+" \t "+name+" \t "+sal+" \t "+mailId+" \t "+phone+"");
						
					}
					break;
				}
				case 7: 
				{
					System.out.println("Thank You For visit\nBye bye!!!");
					System.exit(0);
					break;
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
/*
Assignment1::	Write a jdbc program as follows:

Table Name:Employee_Info.

Table Columns:-empId,empName,empSalary,empAddress,empMailId,empPhNo.
Note:  
update tn set eid 
	   create table from oracle command prompt.
      
Note:Use switch statement to complete this task.
*/