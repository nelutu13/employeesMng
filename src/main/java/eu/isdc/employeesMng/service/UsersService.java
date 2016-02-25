package eu.isdc.employeesMng.service;

import java.sql.*;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import eu.isdc.employeesMng.exception.UserException;
import eu.isdc.employeesMng.model.User;

@Service
public class UsersService {

	final static String DB_URL = "jdbc:mysql://localhost:3306/bsp";
	final static String USER = "root";
	final static String PASS = "root";



	public List<User> read() throws UserException {

		final List<User> usersList = new ArrayList<User>();

		Connection conn = null;
		Statement stmt = null;
		try {
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			stmt = conn.createStatement();
			String query = "SELECT * FROM users";
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				usersList.add(new User(
										rs.getInt("id"), rs.getString("user_number"), 
										rs.getString("user_full_name"), rs.getString("email"), 
										rs.getString("city"), rs.getString("password"), 
										rs.getString("notes"), rs.getInt("age"),
										rs.getInt("holidays"), rs.getString("address"), 
										rs.getString("credit_card_number")
									)
				);
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

	

	public Integer usersPaginationCount() throws UserException {

		Connection conn = null;
		Statement stmt = null;
		Integer totalNumberOfUsers = -1;
		try {
			
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			stmt = conn.createStatement();
			String query = "SELECT COUNT(*) AS total FROM users";
			ResultSet rs = stmt.executeQuery(query);

			if(rs.next()){
				totalNumberOfUsers = rs.getInt("total");
			}
			
			rs.close();
			stmt.close();
			conn.close();

			return totalNumberOfUsers; 

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

	
	
	public List<User> read(int firstrow, int pageSize) throws UserException {

		final List<User> usersList = new ArrayList<User>();

		Connection conn = null;
		PreparedStatement ps = null;
		
		try {
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			String query = "SELECT * FROM users LIMIT ?, ?";
			ps = conn.prepareStatement(query);
			ps.setInt(1, firstrow-1);
			ps.setInt(2, pageSize);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				usersList.add(new User(
										rs.getInt("id"), rs.getString("user_number"), 
										rs.getString("user_full_name"), rs.getString("email"), 
										rs.getString("city"), rs.getString("password"), 
										rs.getString("notes"), rs.getInt("age"),
										rs.getInt("holidays"), rs.getString("address"), 
										rs.getString("credit_card_number")
										)
				);
			}
	
			rs.close();
			ps.close();
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

	
	
	public User readUser(int userId) throws UserException {

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
				user = new User(
						rs.getInt("id"), rs.getString("user_number"), 
						rs.getString("user_full_name"), rs.getString("email"), 
						rs.getString("city"), rs.getString("password"), 
						rs.getString("notes"), rs.getInt("age"),
						rs.getInt("holidays"), rs.getString("address"), 
						rs.getString("credit_card_number")
				);
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
		} catch (UserException ue) {
			ue.printStackTrace();
			throw new UserException("This user is not in database !!");
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

	
	
	public int create(User proposedUser) throws UserException {
		
		if(proposedUser.getId() != null) {
			//this is not create, is actually an update
			return update(proposedUser.getId(), proposedUser);
		}
				
		Connection conn = null;
		PreparedStatement ps = null;
		
		try {
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			
			String query = "insert into users (id, user_number, user_full_name, email, city, password, notes, age, address, credit_card_number)"
					+"values ("
					+ "NULL, "
					+ "?, "
					+ "?, "
					+ "?, "
					+ "?, "
					+ "?, "
					+ "?, "
					+ "?, "
					+ "?, "
					+ "?)";

			ps = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, randomString(9));
			ps.setString(2, proposedUser.getUserFullName());
			ps.setString(3, proposedUser.getEmail());
			ps.setString(4, proposedUser.getCity());
			ps.setString(5, proposedUser.getPassword());
			ps.setString(6, proposedUser.getNotes());
			if(null == proposedUser.getAge()) {ps.setNull(7, java.sql.Types.NULL);} else {ps.setInt(7, proposedUser.getAge());}
			ps.setString(8, proposedUser.getAddress());
			ps.setString(9, proposedUser.getCreditCardNumber());

			int rsCount = ps.executeUpdate();
			int createdUserId = 0;
			
			if (rsCount == 1) {

				ResultSet rs = ps.getGeneratedKeys();

				if (rs.next()) {
					
					createdUserId = rs.getInt(1);

				} else {
		            throw new UserException("Something went wrong. Please try again !!");
				}

				rs.close();
				
			} else {
	            throw new UserException("The user could not be created !!");
			}

			ps.close();
			conn.close();
			
			return createdUserId;
			
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

	
	
	public int update(int userId, User modifiedUser) throws UserException {

		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = DriverManager.getConnection(DB_URL, USER, PASS);

			String query = "UPDATE users SET" + " user_full_name = ?,"
					+ " email = ?," + " city = ?," + " password = ?,"
					+ " notes = ?," + " age = ?," + " address = ?,"
					+ " credit_card_number = ?" + " WHERE id = ?";

			ps = conn.prepareStatement(query);
			ps.setString(1, modifiedUser.getUserFullName());
			ps.setString(2, modifiedUser.getEmail());
			ps.setString(3, modifiedUser.getCity());
			ps.setString(4, modifiedUser.getPassword());
			ps.setString(5, modifiedUser.getNotes());
			if(null == modifiedUser.getAge()) {ps.setNull(6, java.sql.Types.NULL);} else {ps.setInt(6,modifiedUser.getAge());}
			ps.setString(7, modifiedUser.getAddress());
			ps.setString(8, modifiedUser.getCreditCardNumber());
			ps.setInt(9, userId);

			int rsCount = ps.executeUpdate();

			if (rsCount != 1) {
				throw new UserException("The user could not be updated !!");
			}

			ps.close();
			conn.close();

			return userId;

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

		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = DriverManager.getConnection(DB_URL, USER, PASS);

			//delete holidays based on foreign key constraint
			String query = "DELETE FROM holidays WHERE user_id = ?";
			ps = conn.prepareStatement(query);
			ps.setInt(1, userId);
			int rsCount = ps.executeUpdate();
			ps.close();

			//then delete the user
			query = "DELETE FROM users WHERE id = ?";
			ps = conn.prepareStatement(query);
			ps.setInt(1, userId);
			rsCount = ps.executeUpdate();
			if (rsCount == 0) {
				throw new UserException("The user is not in database !!");
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

	
	
	public void validateRequestParam(String param, String paramName) throws UserException {

		// validate mandatory field
		if (param == null) {
			throw new UserException(paramName + " is not present in request !!");
		}
		try {
			Integer.parseInt(param);
		} catch (NumberFormatException e) {
			throw new UserException(paramName + " is not a number !!");
		}
		if (Integer.parseInt(param) < 1) {
			throw new UserException(paramName + " is not valid !!");
		}

	}

	
	
	public String randomString(int len) {
		final String AB = "0123456789";
		Random rnd = new Random();

		StringBuilder sb = new StringBuilder(len);
		for (int i = 0; i < len; i++)
			sb.append(AB.charAt(rnd.nextInt(AB.length())));
		return sb.toString();
	}
	
	
	
	
	
}
