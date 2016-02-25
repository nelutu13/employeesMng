package eu.isdc.employeesMng.service;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.jmock.Expectations;
import org.jmock.Mockery;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import eu.isdc.employeesMng.exception.UserException;
import eu.isdc.employeesMng.model.User;

public class UsersServiceTests {

	private UsersService us;

	@Before
	public void setUp() {
		System.out.println("Before");
	}
	
	@Test
	public void testUsersPaginationCount() throws UserException {

		UsersService us = new UsersService();
		int expectedRowCount = 10;
		int actualRowCount = us.usersPaginationCount();

		assertEquals("Error when reading number of users", expectedRowCount, actualRowCount);
		
	}
	
	@Rule
	public ExpectedException thrown = ExpectedException.none();

	@Test
	public void WhenGoalIsSetToLessThanZero_exceptionIsThrown() throws UserException {

		UsersService us = new UsersService();
		thrown.expect(UserException.class);
		thrown.expectMessage("This user is not in database !!");
		us.readUser(-1);
		
	}

}
