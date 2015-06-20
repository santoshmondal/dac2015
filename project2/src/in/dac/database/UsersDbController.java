package in.dac.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import in.dac.User;

public class UsersDbController {
	private static String DATABASE_DRIVER = "com.mysql.jdbc.Driver";
	private static String DATABASE_URL= "jdbc:mysql://localhost:3306/dac2015";
	private static String DATABASE_USERNAME = "root";
	private static String DATABASE_PASSWORD = "mysql";
	
	
	public static boolean createUser(User user) {
		boolean success = false;
		Connection connection = null;
		try {
			// STEP 1
			Class.forName(DATABASE_DRIVER);
			
			
			// STEP 2 
			connection = DriverManager.getConnection(DATABASE_URL, DATABASE_USERNAME, DATABASE_PASSWORD);
			
			// STEP 3
			String sql = "INSERT INTO users (username, password, email, contactno) VALUES (?, ?, ?, ?)";
					
			
			// step 4
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setString(1, user.getUsername());
			ps.setString(2, user.getPassword());
			ps.setString(3, user.getEmail());
			ps.setString(4, user.getContactno());
			
			ps.executeUpdate();
			
			success = true;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		
		return success;
	}


	public static List<User> readAllUser() {
		List<User> userList = new ArrayList<User>();
		Connection connection = null;
		try {
			// STEP 1
			Class.forName(DATABASE_DRIVER);
			
			
			// STEP 2 
			connection = DriverManager.getConnection(DATABASE_URL, DATABASE_USERNAME, DATABASE_PASSWORD);
			
			// STEP 3
			String sql = "SELECT * FROM users";
					
			
			// step 4
			PreparedStatement ps = connection.prepareStatement(sql);
			
			
			ResultSet rs = ps.executeQuery();
			if(rs != null) {
				while(rs.next()) {
					String username = rs.getString("username");
					String password=  rs.getString("password");
					String email=rs.getString("email");
					String contactno=rs.getString("contactno");
					
					User user = new User();
					user.setUsername(username);
					user.setPassword(password);
					user.setEmail(email);
					user.setContactno(contactno);
					
					userList.add(user);
					
				}
			}
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		
		return userList;
		
	} 

	
	
}
