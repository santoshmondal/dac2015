package in.dac.database;

import in.dac.Employee;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

/**
 * MYSQL
	DRIVER :: 	com.mysql.jdbc.Driver
	URL :: 		jdbc:mysql://localhost:3306/database

	ORACLE
	DRIVER :: 	oracle.jdbc.driver.OracleDriver
	URL ::		jdbc:oracle:thin:@localhost:1521:database

 *
 */
public class DacDatabaseController {
	private static String DATABASE_DRIVER = "com.mysql.jdbc.Driver";
	private static String DATABASE_URL= "jdbc:mysql://localhost:3306/dac2015";
	private static String DATABASE_USERNAME = "root";
	private static String DATABASE_PASSWORD = "mysql";
	

	public static void jdbcConnectionCheck() {
		Connection connection = null;
		try {
			// STEP 1
			Class.forName(DATABASE_DRIVER);
			
			
			// STEP 2 
			connection = DriverManager.getConnection(DATABASE_URL, DATABASE_USERNAME, DATABASE_PASSWORD);
			
			if(connection != null) {
				System.out.println("CONNECTION ESTABLISHED!!!");
			} else {
				System.out.println("CONNECTION FAILURE!!!");
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
	}
	
	public static List<Employee> readAllEmployee() {
		List<Employee> list = new ArrayList<Employee>();
		Connection connection = null;
		try {
			// STEP 1
			Class.forName(DATABASE_DRIVER);
			
			
			// STEP 2 
			connection = DriverManager.getConnection(DATABASE_URL, DATABASE_USERNAME, DATABASE_PASSWORD);
			
			// STEP 3
			String sql = "SELECT * FROM EMPLOYEE";
			
			// step 4
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			
			if(rs != null) {
				while(rs.next()) {
					int id = rs.getInt("ID");
					String username = rs.getString("USERNAME");
					String password = rs.getString("PASSWORD");
					String email = rs.getString("EMAIL");
					Timestamp ctime  = rs.getTimestamp("CTIME");
					
					Employee emp = new Employee();
					emp.setUsername(username);
					emp.setEmail(email);
					emp.setPassword(password);
					emp.setId(id);
					
					list.add(emp);
					
					System.out.println(id + "::" + username + "::" + password + "::" + email + "::" + ctime);
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
		
		
		return list;
	} 
	
	
	
	
	public static Employee readEmployeeByUsername(String username, String password) {
		Employee emp = null;
		Connection connection = null;
		try {
			// STEP 1
			Class.forName(DATABASE_DRIVER);
			
			
			// STEP 2 
			connection = DriverManager.getConnection(DATABASE_URL, DATABASE_USERNAME, DATABASE_PASSWORD);
			
			// STEP 3
			String sql = "SELECT * FROM EMPLOYEE "
					+ "WHERE USERNAME='" + username + "' AND PASSWORD='" + password + "'";
			
			// step 4
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			
			if(rs != null) {
				while(rs.next()) {
					int id = rs.getInt("ID");
					String username1 = rs.getString("USERNAME");
					String password1 = rs.getString("PASSWORD");
					String email = rs.getString("EMAIL");
					Timestamp ctime  = rs.getTimestamp("CTIME");
					
					emp = new Employee();
					emp.setFname(username1);
					emp.setEmail(email);
					
					System.out.println(id + "::" + username + "::" + password + "::" + email + "::" + ctime);
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
		
		
		return emp;
	} 
	
	
	
	public static boolean insertEmployee(Employee emp) {
		boolean success = false;
		Connection connection = null;
		try {
			// STEP 1
			Class.forName(DATABASE_DRIVER);
			
			
			// STEP 2 
			connection = DriverManager.getConnection(DATABASE_URL, DATABASE_USERNAME, DATABASE_PASSWORD);
			
			// STEP 3
			String sql = "INSERT INTO EMPLOYEE (USERNAME, PASSWORD, EMAIL) VALUES "
					+ "('" + emp.getUsername() + "', '" + emp.getPassword() + "','"+emp.getEmail()+"')";
					
			
			// step 4
			Statement statement = connection.createStatement();
			statement.executeUpdate(sql);
			
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

	
	public static boolean updateEmployee(Employee emp) {
		boolean success = false;
		Connection connection = null;
		try {
			// STEP 1
			Class.forName(DATABASE_DRIVER);
			
			
			// STEP 2 
			connection = DriverManager.getConnection(DATABASE_URL, DATABASE_USERNAME, DATABASE_PASSWORD);
			
			// STEP 3
			String sql = "UPDATE EMPLOYEE SET PASSWORD='"+ emp.getPassword() + "'"
					+ ", EMAIL='" + emp.getEmail() + "' WHERE USERNAME='" + emp.getUsername() + "'";
					
			
			// step 4
			Statement statement = connection.createStatement();
			statement.executeUpdate(sql);
			
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
	
	
	public static boolean updateEmployeePS(Employee emp) {
		boolean success = false;
		Connection connection = null;
		try {
			// STEP 1
			Class.forName(DATABASE_DRIVER);
			
			
			// STEP 2 
			connection = DriverManager.getConnection(DATABASE_URL, DATABASE_USERNAME, DATABASE_PASSWORD);
			
			// STEP 3
			String sql = "UPDATE EMPLOYEE SET PASSWORD=?, EMAIL=?  WHERE USERNAME=?";
					
			
			// step 4
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setString(1, emp.getPassword());
			ps.setString(2, emp.getEmail());
			ps.setString(3, emp.getUsername());
			
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
	
	
	public static void main(String[] args) {
		Employee emp = new Employee();
		emp.setFname("MUMBAI");
		emp.setEmail("cdac@mumbai.in");
		DacDatabaseController.updateEmployee(emp);
	}
	
}
