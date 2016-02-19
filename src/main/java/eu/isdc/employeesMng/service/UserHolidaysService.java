package eu.isdc.employeesMng.service;

import java.sql.*;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import eu.isdc.employeesMng.exception.UserException;
import eu.isdc.employeesMng.model.Holidays;

@Service
public class UserHolidaysService {

	final static String DB_URL = "jdbc:mysql://localhost:3306/bsp";
	final static String USER = "root";
	final static String PASS = "root";

	
	
	public List<Holidays> read(int userId) throws UserException {

		final List<Holidays> holidays = new ArrayList<Holidays>();		

		Connection conn = null;
		PreparedStatement ps = null;
		
		try {
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			String query = "SELECT * FROM holidays WHERE user_id = ?";

			ps = conn.prepareStatement(query);
			ps.setInt(1, userId);
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				holidays.add(new Holidays(
											rs.getInt("id"),
											rs.getInt("user_id"),
											rs.getDate("from_date"),
											rs.getDate("to_date"),
											rs.getInt("days_taken"),
											rs.getString("notes")
										)
				);
			}
	
			rs.close();
			ps.close();
			conn.close();

			return holidays;

		} catch (SQLException se) {
			se.printStackTrace();
			throw new UserException("SQL exception !!", se);
		} catch (Exception e) {
			e.printStackTrace();
			throw new UserException("Some exception !!" + e.getMessage(), e);
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


	
	public void createUserHolidays(Holidays proposedUserHolidays) throws UserException {
		
		Connection conn = null;
		PreparedStatement ps = null;
		
		try {
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			
			String query = "insert into holidays (id, user_id, from_date, to_date, days_taken, notes)"
					+"values ("
					+ "NULL, "
					+ "?, "
					+ "?, "
					+ "?, "
					+ "?, "
					+ "?)";

			ps = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
			ps.setInt(1, proposedUserHolidays.getUserId());
			ps.setDate(2, proposedUserHolidays.getFromDate());
			ps.setDate(3, proposedUserHolidays.getToDate());
			ps.setInt(4, proposedUserHolidays.getDaysTaken());
			ps.setString(5, proposedUserHolidays.getNotes());

			int rsCount = ps.executeUpdate();
			
			if (rsCount == 1) {

				ResultSet rs = ps.getGeneratedKeys();

				if (rs.next()) {
					
					//success - do nothing, angular will know

				} else {
		            throw new UserException("Something went wrong. Please try again !!");
				}

				rs.close();
				
			} else {
	            throw new UserException("The user holidays could not be saved !!");
			}

			ps.close();
			conn.close();
			
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
	
	
	
	
	
}
