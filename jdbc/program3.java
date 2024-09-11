package com.dk.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class program3 {
	static  Connection con;
	static PreparedStatement pstmt ; 
	static ResultSet res;

	public static void main(String[] args) {
		
		String url = "jdbc:mysql://localhost:3306/jdbc";
		String username = "root";
		String password = "root@dk";
		String SQL = "select * from employee where e_id = ?";
		Scanner in = new Scanner(System.in);
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			con = DriverManager.getConnection(url, username, password);
			
			System.out.println("Enter the employeeId: ");
			int e_id = in.nextInt();
			
			pstmt = con.prepareStatement(SQL);
			
			pstmt.setInt(1,e_id);
			 res = pstmt.executeQuery();
		     if(res.next())
		     {
		    	 System.out.println(res.getInt(1)+" "+res.getString(2)+" "+res.getString(3)+" "+res.getString(4)+ " "+res.getInt(5));
		     }
		     else
		     {
		    	 System.out.println("No Element is Found..");
		     }

	
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
