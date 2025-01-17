package com.practice.jan_09;

import java.sql.*;
import java.util.*;

public class RegistrationAndLogin 
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
			PreparedStatement pst = con.prepareStatement("insert into reglog09 values (?,?,?,?,?,?,?)");
			PreparedStatement upPst = con.prepareStatement("update table reglog09 values (?,?)");
			
			while(true)
			{
				System.out.println
				("\n******Registration and Login System*********\n"
						+ "\n\t1.Rgister a New User"
						+ "\n\t2.Login to system"
						+ "\n\t3.Exit");
				
				int sysChoice = Integer.parseInt(sc.nextLine());
				
				switch(sysChoice)
				{
				case 1:
					System.out.println("\n*******Register a new user********\n");
					
					System.out.println("Enter user-id :");
					int id = Integer.parseInt(sc.nextLine());
					
					System.out.println("Enter user-name :");
					String name = sc.nextLine();
					
					System.out.println("Enter user-password :");
					String pass = sc.nextLine();
					
					System.out.println("Enter user-first name :");
					String fname = sc.nextLine();
					
					System.out.println("Enter user-last name :");
					String lname = sc.nextLine();
					
					System.out.println("Enter user-mail-id :");
					String mail = sc.nextLine();
					
					System.out.println("Enter user-phone number :");
					String phone = sc.nextLine();
					
					pst.setInt(1, id);
					pst.setString(2, name);
					pst.setString(3, pass);
					pst.setString(4, fname);
					pst.setString(5, lname);
					pst.setString(6, mail);
					pst.setString(7, phone);
					
					int update = pst.executeUpdate();
					if(update>0)
					{
						System.out.println("Registration succesfully completed !!!");
					}
					else
						System.err.println("Registration failed!");
					break;
					
				case 2:
					System.out.println("\n******Enter login details*******\n");
					
					System.out.println("Enter user-id");
					int lId = Integer.parseInt(sc.nextLine());
					
					System.out.println("Enter user-password");
					String lPass = sc.nextLine();
					
					ResultSet rs = st.executeQuery("select * from reglog09 where id="+lId+"");
					rs.next();
					String uPass = rs.getString(3);
					if(lPass.equals(uPass))
					{
						while(true)
						{
						System.out.println("\n*****Login Succesfull!!!*****\n");
						System.out.println
						("\n\t1.Show all Custemers"
								+ "\n\t2.Update Custemer [ mail and phone number ]"
								+ "\n\t3.Delet Custemer by id start name with 's' "
								+ "\n\t4.Show custemer with prime id"
								+ "\n\t5.Delete Custemer start name with 's' "
								+ "\n\t6.Exit");
						System.out.println("\nEnter your choice :");
						int logChoice = Integer.parseInt(sc.nextLine());
						
						switch (logChoice) {
						case 1: 
							ResultSet rs1 = st.executeQuery("select * from reglog09");
							System.out.println("\n**********All Custemes*********\n");
							while(rs1.next())
							{
								int allId = rs1.getInt(1); 
								String allName = rs1.getString(2); 
								String allPass = rs1.getString(3); 
								String allFname = rs1.getString(4); 
								String allLname = rs1.getString(5); 
								String allMail = rs1.getString(6); 
								String allPhone = rs1.getString(7); 
								
								System.out.println
								(allId+" \t "+allName+" \t "+allPass+" \t "+allFname+" \t "+allLname+" \t"
										+allMail+" \t "+allPhone+"");
							}
							break;
						case 2:
							System.out.println("Enter id of custemer you want to update :");
							int uId = Integer.parseInt(sc.nextLine());
							
							int logUpdate = upPst.executeUpdate();
							
							if(logUpdate>0)
								System.out.println("Record updated succesfully!");
							else
								System.out.println("Record not updated");
							
							
						case 3:
								System.out.println("Enter id of custemer you want to delete :");
								int dId = Integer.parseInt(sc.nextLine());
								
								int del = st.executeUpdate("delete from reglog09 where id="+dId+""); 
								if(del>0)
									System.out.println("Custemer deleted succesfully!!!");
								else
									System.out.println("Custemer not exist");
							break;
						case 6:
							System.out.println("Thanks, Bye bye!!!");
							System.exit(0);	
							break;
						
						default:
							System.err.println("Invalid input, Try again!");
						}
					}
					}else
						System.err.println("Incorrect Password!!!");
					break;
					
				case 3:
					System.out.println("Thanks, Bye bye!!!");
					System.exit(0);
					
				default:
					System.err.println("Invalid input, Try again!");
				}
			}
		}
		catch (Exception e) 
		{
			
		}
		

	}

}
