package com.advjava.jan_06;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class ConnectionDemo {
    public static void main(String[] args) {
        try {
            
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con = DriverManager.getConnection(
                "jdbc:oracle:thin:@localhost:1521:xe", "System", "tonystark");
            
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select * from employees");
              
            
            
            rs.next();
            int id = rs.getInt(1); 
            String name = rs.getString(2); 
            int salary = rs.getInt(3);
            System.out.println(id+" "+name+" "+salary);
            
   
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}