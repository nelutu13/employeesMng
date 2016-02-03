package eu.isdc.employeesMng.service;

import java.sql.*;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import eu.isdc.employeesMng.model.User;

@Service
public class UsersService {

	public List<User> getUsers() {

		final List<User> usersList = new ArrayList<User>();

		final String DB_URL = "jdbc:mysql://localhost:3306/bsp";
		final String USER = "root";
		final String PASS = "root";

		Connection conn = null;
		Statement stmt = null;
		try {
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			stmt = conn.createStatement();
			String query = "SELECT * FROM users";
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				usersList.add(new User(rs.getInt("id"), rs
						.getString("user_number"), rs.getString("user_full_name"),
						rs.getString("email"), rs.getString("city"), rs
								.getString("password"), rs.getString("notes"),
						rs.getInt("age"), rs.getString("address"), rs
								.getString("credit_card_number")));
			}

			rs.close();
			stmt.close();
			conn.close();

			return usersList;

		} catch (SQLException se) {
			// Handle errors for JDBC
			se.printStackTrace();
		} catch (Exception e) {
			// Handle errors for Class.forName
			e.printStackTrace();
		} finally {
			try {
				if (stmt != null) {
					stmt.close();
				}
			} catch (SQLException se2) {
				;
			}// nothing we can do

			try {
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException se) {
				se.printStackTrace();
			}// end finally try
		}// end try

		return null;
	}

	
	
	
	
	
	

	public User getUser(int userNumber) {

		final String DB_URL = "jdbc:mysql://localhost:3306/bsp";
		final String USER = "root";
		final String PASS = "root";

		User user = null;
		
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			String query = "SELECT * FROM users WHERE user_number=?";

			ps = conn.prepareStatement(query);
			ps.setInt(1, userNumber);
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				user = new User(rs.getInt("id"), rs.getString("user_number"),
						rs.getString("user_full_name"), rs.getString("email"),
						rs.getString("city"), rs.getString("password"),
						rs.getString("notes"), rs.getInt("age"),
						rs.getString("address"),
						rs.getString("credit_card_number"));
			}

			rs.close();
			ps.close();
			conn.close();
			
			return user;
			
		} catch (SQLException se) {
			//se.printStackTrace();
			return null;
		} catch (Exception e) {
			//e.printStackTrace();
			return null;
		} finally {
			try {
				if (ps != null) {
					ps.close();
				}
			} catch (SQLException se2) {
				;
			}// nothing we can do

			try {
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException se) {
				se.printStackTrace();
			}// end finally try
		}// end try

	}


	
	
	public User createUser(User newUser) {
		return null;

	}

}





// stmt = conn.createStatement();
// Statement stmt = null;
// ResultSet rs = stmt.executeQuery(query);
// stmt.close();
