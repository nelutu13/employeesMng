package eu.isdc.employeesMng.service;

import java.sql.*;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import eu.isdc.employeesMng.exception.UserException;
import eu.isdc.employeesMng.model.User;

@Service
public class UsersService {

	public List<User> get() throws UserException {

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
				usersList.add(new User(rs.getInt("id"), 
						rs.getString("user_number"), rs.getString("user_full_name"),
						rs.getString("email"), rs.getString("city"), 
						rs.getString("password"), rs.getString("notes"),
						rs.getInt("age"), rs.getString("address"), 
						rs.getString("credit_card_number")));
			}

			rs.close();
			stmt.close();
			conn.close();

			return usersList;

		} catch (SQLException se) {
			se.printStackTrace();
            throw new UserException("SQL exception !!", se);
		} catch (Exception e) {
			e.printStackTrace();
            throw new UserException("Some exception !!", e);
		} finally {
			try {
				if (stmt != null) {
					stmt.close();
				}
			} catch (SQLException se2) {
				;
			}

			try {
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException se) {
				se.printStackTrace();
			}
		}

	}
	
	

	public User getUser(int userId) throws UserException {

		final String DB_URL = "jdbc:mysql://localhost:3306/bsp";
		final String USER = "root";
		final String PASS = "root";

		User user = null;
		
		Connection conn = null;
		PreparedStatement ps = null;

		try {
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			String query = "SELECT * FROM users WHERE id=?";

			ps = conn.prepareStatement(query);
			ps.setInt(1, userId);
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				user = new User(rs.getInt("id"), rs.getString("user_number"),
						rs.getString("user_full_name"), rs.getString("email"),
						rs.getString("city"), rs.getString("password"),
						rs.getString("notes"), rs.getInt("age"),
						rs.getString("address"),
						rs.getString("credit_card_number"));
			} else {
	            throw new UserException("This user is not in database !!");
			}

			rs.close();
			ps.close();
			conn.close();
			
			return user;
			
		} catch (SQLException se) {
			se.printStackTrace();
            throw new UserException("SQL exception !!", se);
		} catch (Exception e) {
			e.printStackTrace();
            throw new UserException("Some exception !! " + userId, e);
		} finally {
			try {
				if (ps != null) {
					ps.close();
				}
			} catch (SQLException se2) {
				;
			}

			try {
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException se) {
				se.printStackTrace();
			}
		}

	}


	
	public User update(int userId, User modifiedUser) throws UserException {
		
		//check user fields
		
		//update user in database
		final String DB_URL = "jdbc:mysql://localhost:3306/bsp";
		final String USER = "root";
		final String PASS = "root";

		User updatedUser = null;
		
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			
			String query = "UPDATE users SET"
					+ " user_full_name = ?,"
					+ " email = ?,"
					+ " city = ?,"
					+ " password = ?,"
					+ " notes = ?,"
					+ " age = ?,"
					+ " address = ?,"
					+ " credit_card_number = ?"
					+ " WHERE id = ?";

			ps = conn.prepareStatement(query);
			ps.setString(1, modifiedUser.getUserFullName());
			ps.setString(2, modifiedUser.getEmail());
			ps.setString(3, modifiedUser.getCity());
			ps.setString(4, modifiedUser.getPassword());
			ps.setString(5, modifiedUser.getNotes());
			ps.setInt(6, modifiedUser.getAge());
			ps.setString(7, modifiedUser.getAddress());
			ps.setString(8, modifiedUser.getCreditCardNumber());
			ps.setInt(9, userId);

			int rsCount = ps.executeUpdate();

			if (rsCount != 0) {
				
				query = "SELECT * FROM users WHERE id=?";

				ps.close();
				ps = conn.prepareStatement(query);
				ps.setInt(1, userId);
				ResultSet rs = ps.executeQuery();

				if (rs.next()) {
					updatedUser = new User(
							rs.getInt("id"), rs.getString("user_number"),
							rs.getString("user_full_name"), rs.getString("email"),
							rs.getString("city"), rs.getString("password"),
							rs.getString("notes"), rs.getInt("age"),
							rs.getString("address"), rs.getString("credit_card_number"));
				} else {
		            throw new UserException("This user is not in database !!");
				}

				rs.close();
				
			} else {
	            throw new UserException("The user could not be updated !!");
			}

			ps.close();
			conn.close();
			
			return updatedUser;
			
		} catch (SQLException se) {
			se.printStackTrace();
            throw new UserException("SQL exception !!", se);
		} catch (Exception e) {
			e.printStackTrace();
            throw new UserException("Some exception !!", e);
		} finally {
			try {
				if (ps != null) {
					ps.close();
				}
			} catch (SQLException se2) {
				;
			}

			try {
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException se) {
				se.printStackTrace();
			}
		}
	}


	
	public boolean delete(int userId) throws UserException {
		
		final String DB_URL = "jdbc:mysql://localhost:3306/bsp";
		final String USER = "root";
		final String PASS = "root";

		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			
			String query = "DELETE FROM users WHERE id = ?";

			ps = conn.prepareStatement(query);
			ps.setInt(1, userId);

			int rsCount = ps.executeUpdate();

			if (rsCount == 0) {
	            throw new UserException("The user could not be deleted !!");
			}

			ps.close();
			conn.close();
			
			return true;
			
		} catch (SQLException se) {
			se.printStackTrace();
            throw new UserException("SQL exception !!", se);
		} catch (Exception e) {
			e.printStackTrace();
            throw new UserException("Some exception !!", e);
		} finally {
			try {
				if (ps != null) {
					ps.close();
				}
			} catch (SQLException se2) {
				;
			}

			try {
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException se) {
				se.printStackTrace();
			}
		}
	}



	public void validateUserId(String userId) throws UserException {

		//validate mandatory field
        if(userId == null){					throw new UserException("id is not present in request !!");}
        try{Integer.parseInt(userId);}
        catch(NumberFormatException e) {	throw new UserException("id is not a number !!");}
        if(Integer.parseInt(userId) < 1){	throw new UserException("id is not valid !!");}
        
	}





}
