package com.dk.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class program8 {

	private static Connection con;
	private static Scanner in = new Scanner(System.in);
	private static Scanner sc = new Scanner(System.in);
	private static PreparedStatement pstmt;

	public static void main(String[] args) {
		// ACID property.
		// transfer the money from one row to another table or one account from another account.
		
		String url = "jdbc:mysql://localhost:3306/jdbc";
		String username = "root";
		String password = "root@dk";
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(url,username,password);
			con.setAutoCommit(false);
			boolean transaction = transaction();
			
			if(transaction)
			{
				System.out.println("Transaction Success....!");
				con.commit();
			}
			else
			{
				System.out.println("Transaction Failure.....");
				con.rollback();
			}
			
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private static boolean transaction() {
		System.out.println("Enter the amount: ");
		int amount = in.nextInt();
		System.out.println("Enter the Sender Name: ");
		String Sname = sc.nextLine();
		System.out.println("Enter the Receiver Name: ");
		String Rname = sc.nextLine();
		
		int i = updateAmount(Sname, amount);
		int j = updateAmount(Rname, -amount);
		
		return isconfirm(i,j);
		
	}


	private static boolean isconfirm(int i, int j) {
		
		System.out.println("Do you want to commit the transaction (yes/no) : ");
		String choice = in.next();
		if(choice.equalsIgnoreCase("yes") && i ==1 && j==1)
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	private static int updateAmount(String Sname,int amount) {
		
		String SQL = "update bank set balance  = balance - ? where name = ?";
		
		try {
			pstmt = con.prepareStatement(SQL);
			pstmt.setInt(1, amount);
			pstmt.setString(2, Sname);
			
			int i = pstmt.executeUpdate();
			return i;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

}
