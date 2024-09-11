package com.dk.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class program4 {
	
	static Connection con;
	static PreparedStatement pstmt;

	public static void main(String[] args) {
		
		// Inserting the data in the employee database.

		Scanner in = new Scanner(System.in);
		String url = "jdbc:mysql://localhost:3306/jdbc";
		String username = "root";
		String password  ="root@dk";
		String SQL = "insert into employee (e_id,e_name,email,dept,salary) values(?,?,?,?,?)";
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			con = DriverManager.getConnection(url, username, password);
			
			pstmt = con.prepareStatement(SQL);
		
			System.out.println("Enter the employee id: ");
			int employeeId = in.nextInt();
			System.out.println("Enter the employee name: ");
			String employeeName = in.next();
			System.out.println("Enter the employee email: ");
			String employeeEmail = in.next();
			System.out.println("Enter the employee dept: ");
			String employeeDept = in.next();
			System.out.println("Enter the employee salary: ");
			int employeeSalary = in.nextInt();
			
			pstmt.setInt(1,employeeId);
			pstmt.setString(2, employeeName);
			pstmt.setString(3, employeeEmail);
			pstmt.setString(4, employeeDept);
			pstmt.setInt(5, employeeSalary);
			
			int x = pstmt.executeUpdate();
			System.out.println("Query rows/s affected");

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
				
	}

}
