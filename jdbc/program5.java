package com.dk.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class program5 {

     static Connection con;
     static PreparedStatement pstmt;

	public static void main(String[] args) {
		
		String url = "jdbc:mysql://localhost:3306/jdbc";
		String username = "root";
		String password = "root@dk";
		String SQL = "delete from employee where e_id = ?";
		Scanner in = new Scanner(System.in);
		
		
	    try {
	    	Class.forName("com.mysql.cj.jdbc.Driver");
			
			con = DriverManager.getConnection(url, username, password);
			
			pstmt = con.prepareStatement(SQL);
			System.out.println("Enter the employee id to delete the information: ");
			int employeeId = in.nextInt();
			
			
			pstmt.setInt(1, employeeId);
			int x = pstmt.executeUpdate();
			System.out.println(x + " row/s deleted");

			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

	}

}
