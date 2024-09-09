package com.dk.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class program1 {
	Statement stmt = null;
	
	/* output...
	 * Driver loaded
       Connection Established....
       101 alex alex@123 IT 50000
       Query Executed..

	 */


	public static void main(String[] args) {
		
		String url = "jdbc:mysql://localhost:3306/jdbc";
		String username = "root";
		String password = "root@dk";
		String SQL = "SELECT * FROM employee";
		
	
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver loaded");
		} catch (ClassNotFoundException e) {
			System.out.println("Driver not found....");
			e.printStackTrace();
		}
		
		try {
			Connection con = DriverManager.getConnection(url, username, password);
			System.out.println("Connection Established....");
		    Statement stmt = con.createStatement();
			ResultSet res =  stmt.executeQuery(SQL);
			
			while(res.next())
			{
				System.out.println(res.getInt("e_id")+" "+res.getString("e_name")+" "+res.getString("email")
				+" "+res.getString("dept")+" "+res.getInt("salary"));
			}
			System.out.println("Query Executed....");
			
		} catch (SQLException e) {
			System.out.println("Connection not Connected....");
			e.printStackTrace();
		}
		
	
	}

}
