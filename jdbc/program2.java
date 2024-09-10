package com.dk.jdbc;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class program2 {
	
	static Connection con;
	static Statement stmt;
	static ResultSet res;

	public static void main(String[] args)
	{
		String url = "jdbc:mysql://localhost:3306/jdbc";
		String username = "root";
		String password = "root@dk";
		String SQL = "select * from employee";
		
		
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			con =   DriverManager.getConnection(url, username, password);
			stmt = con.createStatement();
			res = stmt.executeQuery(SQL);
			while(res.next())
			{
				System.out.println(res.getInt(1)+" "+res.getString(2)+" "+res.getString(3)+" "+res.getString(4)+ " "+res.getInt(5));
			}
			
			
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}
