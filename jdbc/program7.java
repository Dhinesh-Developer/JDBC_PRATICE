package com.dk.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import com.mysql.cj.protocol.ValueDecoder;

public class program7 {
	
	// Batch processing. collecting multiples details after some time inserting the records in database.

	private static final String res = null;
	private static Connection con;
	private static PreparedStatement pstmt;

	public static void main(String[] args) {
		
		String url = "jdbc:mysql://localhost:3306/jdbc";
		String username = "root";
		String password = "root@dk";
		String SQL  ="insert into employee (e_id,e_name,email,dept,salary) values (?,?,?,?,?)";
		Scanner in = new Scanner(System.in);
		Scanner sc = new Scanner(System.in);
		
	
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(url, username, password);
			pstmt =con.prepareStatement(SQL);
			
			System.out.println("How many records do you want to insert: ");
			int count = in.nextInt();
			
			for(int i=0;i<count;i++) {
				System.out.println("Enter the employee id: ");
				int id = in.nextInt();
				System.out.println("Enter the employee name: ");
				String name = sc.nextLine();
				System.out.println("Enter the email: ");
				String email = sc.nextLine();
				System.out.println("Enter the department: ");
				String dept = sc.nextLine();
				System.out.println("Enter the salary: ");
				int salary = in.nextInt();
				
				pstmt.setInt(1, id);
				pstmt.setString(2, name);
				pstmt.setString(3,email);
				pstmt.setString(4, dept);
				pstmt.setInt(5, salary);

				pstmt.addBatch();

			}
			
			int[] updateCount = pstmt.executeBatch();
			System.out.println("row/s inserted successfully...");
			
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

}
