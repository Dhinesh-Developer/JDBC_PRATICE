package com.dk.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class program6 {

	private static Connection con;
	private static Statement stmt;
	private static ResultSet resultset;
	private static ResultSetMetaData rsmd;

	public static void main(String[] args) {
		
		String url = "jdbc:mysql://localhost:3306/dk1";
		String username = "root";
		String password = "root@dk";
		String SQL = "select * from product";
		
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(url, username, password);
		    stmt = 	con.createStatement();
		    resultset = stmt.executeQuery(SQL);
			rsmd = resultset.getMetaData();
			int count = rsmd.getColumnCount();
			
			for(int i=1;i<=count;i++)
			{
				System.out.println(rsmd.getColumnName(i)+"   "+rsmd.getColumnTypeName(i));
			}
			
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

}
