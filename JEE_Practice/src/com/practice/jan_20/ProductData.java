package com.practice.jan_20;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class ProductData {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		try (sc;) {

			Class.forName("oracle.jdbc.driver.OracleDriver");

			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "System", "tonystark");

			
			Statement st =
					con.createStatement
					(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			PreparedStatement insert = con.prepareStatement("insert into product20 values (?,?,?,?)");

			while (true) {
				System.out.println("\n****** Product Data Managment ******\n");
				System.out.println(" \t  1.Insert productdetails into product table.\n"
						+ "          2.Retrieve productdetails in forward direction.\n"
						+ "          3.Retrieve productdetails in reverse direction.\n"
						+ "          4.Retrieve 3rd record from top.\n"
						+ "          5.Retrieve 3rd record from bottom.\n"
						+ "          6.Retrieve last three record from product table.\n" + "\t  7.Exit");

				System.out.print("\n\t Enter your choice :");
				int choice = sc.nextInt();

				switch (choice) {
					case 1:
						System.out.println("Enter product details");
						sc.nextLine();
						System.out.println("Enter Product ID :");
						int id = Integer.parseInt(sc.nextLine());
						
	
						System.out.println("Enter Product NAME :");
						String name = sc.nextLine();
	
						System.out.println("Enter Product PRICE :");
						double price = Double.parseDouble(sc.nextLine());
	
						System.out.println("Enter Product QTY :");
						int qty = Integer.parseInt(sc.nextLine());
	
						insert.setInt(1, id);
						insert.setString(2, name);
						insert.setDouble(3, price);
						insert.setInt(4, qty);
	
						int update = insert.executeUpdate();
						if (update > 0)
							System.out.println("Data inserted!");
						else
							System.out.println("Data not inserted");
						break;
	
					case 2:
						ResultSet select = st.executeQuery("Select * from product20");
						while (select.next()) {
							System.out.println("Product Id = " + select.getInt(1) + "Product Name = " + select.getString(2)
									+ "Product Price = " + select.getDouble(3) + "Product QTY = " + select.getInt(4) + "");
						}
						break;
	
					case 3:
						System.out.println("****** Data in Revers Order *****");
						ResultSet reversSelect = st.executeQuery("Select * from product20");
						reversSelect.afterLast();
						while (reversSelect.previous()) {
							System.out.println("Product Id = " + reversSelect.getInt(1) + "Product Name = "
									+ reversSelect.getString(2) + "Product Price = " + reversSelect.getDouble(3)
									+ "Product QTY = " + reversSelect.getInt(4) + "");
						}
						break;
	
					case 4:
						System.out.println("\n********3rd from top********\n");
						ResultSet thirdProd = st.executeQuery("Select * from product20");
						thirdProd.absolute(3);
						System.out.println("Product Id = " + thirdProd.getInt(1) + "Product Name = "
								+ thirdProd.getString(2) + "Product Price = " + thirdProd.getDouble(3)
								+ "Product QTY = " + thirdProd.getInt(4) + "");
						break;
						
					case 5:
						System.out.println("\n********3rd from bottom********\n");
						ResultSet thirdLastProd = st.executeQuery("Select * from product20");
						thirdLastProd.last();
						thirdLastProd.relative(-2);
						System.out.println("Product Id = " + thirdLastProd.getInt(1) + "Product Name = "
								+ thirdLastProd.getString(2) + "Product Price = " + thirdLastProd.getDouble(3)
								+ "Product QTY = " + thirdLastProd.getInt(4) + "");
						break;
						
					case 6:
						System.out.println("\n********3rd from bottom********\n");
						ResultSet lastThree = st.executeQuery("Select * from product20");
						lastThree.last();
						lastThree.relative(-3);
						while(lastThree.next())
						{
						System.out.println("Product Id = " + lastThree.getInt(1) + "Product Name = "
								+ lastThree.getString(2) + "Product Price = " + lastThree.getDouble(3)
								+ "Product QTY = " + lastThree.getInt(4) + "");
						}
						break;
					case 7:
						System.out.println("Thank you! See you soon...");
						System.exit(0);
	
					default:
						System.err.println("Invalid input! Try again");
					}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
