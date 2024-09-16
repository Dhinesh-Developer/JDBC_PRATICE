import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.Scanner;

public class user {
	
    private int userId;
    private String username;
    private String name;
    private String password;
    private String email;
    private String phone;
    private String address;
    private String role;
    
    private Timestamp createdDate;public user() {
	}
	@Override
	public String toString() {
		return "user [userId=" + userId + ", username=" + username + ", name=" + name + ", password=" + password
				+ ", email=" + email + ", phone=" + phone + ", address=" + address + ", role=" + role + ", createdDate="
				+ createdDate + "]";
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public Timestamp getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Timestamp createdDate) {
		this.createdDate = createdDate;
	}
	public static Connection getCon() {
		return con;
	}
	public static void setCon(Connection con) {
		user.con = con;
	}
	public user(int userId, String username, String name, String password, String email, String phone, String address,
			String role, Timestamp createdDate) {
		super();
		this.userId = userId;
		this.username = username;
		this.name = name;
		this.password = password;
		this.email = email;
		this.phone = phone;
		this.address = address;
		this.role = role; 
		this.createdDate = createdDate;
	}
	private static Connection con;
	private static Statement stmt;
	private static ResultSet res;
	private static PreparedStatement pstmt;
	



	public static void main(String[] args) {
		
	    String url  = "jdbc:mysql://localhost:3306/app";
		String username = "root";
	    String password  ="root@dk";
	    Scanner in = new Scanner(System.in);
	    Scanner sc = new Scanner(System.in);
	    Scanner scanner  = new Scanner(System.in);
		

			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				con = DriverManager.getConnection(url, username, password);
				
				String SQL = "select * from user";
				stmt = con.createStatement();
				res = stmt.executeQuery(SQL);
				while(res.next())
				{
					System.out.println(res.getInt(1)+"  "+res.getString(2)+"  "+res.getString(3)+"  "+res.getString(4)
				
					+"   "+res.getString(5)+"  "+res.getString(6)+"   "+res.getString(7)+"  "+res.getString(8)+"  "+res.getDate(9));
				
				}
				System.out.println("Query Executed ....");
				
			
					
			} catch (SQLException | ClassNotFoundException e) {
				e.printStackTrace();
			}		
		
			
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				con = DriverManager.getConnection(url, username, password);
				String SQL1  ="insert into user (userid ,username,name,password,email,phone,address,role) values (?,?,?,?,?,?,?,?)";
				pstmt = con.prepareStatement(SQL1);
				System.out.println("Enter the userid: ");
				int userid  = in.nextInt();
				System.out.println("Enter the user: ");
				String usern = sc.nextLine();
				System.out.println("Enter the username: ");
				String userName = scanner.nextLine();
				System.out.println("Enter the password: ");
				String password1 = in.nextLine();
				System.out.println("Enter the email: ");
				String email = sc.nextLine();
				System.out.println("Enter the phonenumber: ");
				String phonenumber = scanner.nextLine();
				System.out.println("Enter the address: ");
				String address = in.nextLine();
				System.out.println("Enter the role: ");
				String role = sc.nextLine();
			
				

				pstmt.setInt(1, userid);
				pstmt.setString(2, usern);
				pstmt.setString(3, userName);
				pstmt.setString(4, password1);
				pstmt.setString(5, email);
				pstmt.setString(6, phonenumber);
				pstmt.setString(7, address);
				pstmt.setString(8, role);
				
				int i = pstmt.executeUpdate();
				System.out.println(i+"row/s inserted");

			
			}
			catch (Exception e) {
			}
			
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				con = DriverManager.getConnection(url, username, password);
				  String sql = "UPDATE user SET username = ?, name = ?, password = ?, email = ?, phone = ?, address = ?, role = ? WHERE userid = ?";
				  
					pstmt = con.prepareStatement(sql);
					
					System.out.println("Enter the user: ");
					String usern = sc.nextLine();
					System.out.println("Enter the username: ");
					String userName = scanner.nextLine();
					System.out.println("Enter the password: ");
					String password1 = in.nextLine();
					System.out.println("Enter the email: ");
					String email = sc.nextLine();
					System.out.println("Enter the phonenumber: ");
					String phonenumber = scanner.nextLine();
					System.out.println("Enter the address: ");
					String address = in.nextLine();
					System.out.println("Enter the role: ");
					String role = sc.nextLine();
					System.out.println("Enter the userid: ");
					int userid  = in.nextInt();
				
					

					
					pstmt.setString(1, usern);
					pstmt.setString(2, userName);
					pstmt.setString(3, password1);
					pstmt.setString(4, email);
					pstmt.setString(5, phonenumber);
					pstmt.setString(6, address);
					pstmt.setString(7, role);
					pstmt.setInt(8, userid);

		            int rowsAffected = pstmt.executeUpdate();
		            System.out.println(rowsAffected+"row/s updated..");
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				con = DriverManager.getConnection(url, username, password);
				String SQL2 = "delete from user where userid = ?";
				pstmt = con.prepareStatement(SQL2);
				
				System.out.println("Enter the userId: ");
				int id = sc.nextInt();
				pstmt.setInt(1, id);
				int x = pstmt.executeUpdate();
				System.out.println(x+"row/s Deletes....");
				
				
				
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
			
			System.out.println("All CRUD opertions are done....");
			System.out.println("Connection Terminated");
			
			
			
			try {
				in.close();
				sc.close();
				stmt.close();
				pstmt.close();
				res.close();
				con.close();
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
	
	}

	
}
