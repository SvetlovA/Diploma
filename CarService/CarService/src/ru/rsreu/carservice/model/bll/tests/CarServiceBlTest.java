package ru.rsreu.carservice.model.bll.tests;

import static org.junit.Assert.*;

import java.sql.SQLException;
import java.util.UUID;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import ru.rsreu.carservice.model.bll.CarServiceBl;
import ru.rsreu.carservice.model.dal.CarServiceDao;
import ru.rsreu.carservice.model.dal.ICarServiceDao;
import ru.rsreu.carservice.model.entities.Password;
import ru.rsreu.carservice.model.entities.User;

public class CarServiceBlTest {
	
	private final static String TEST_ADMIN_LOGIN = "Test login";
	private final static String TEST_ADMIN_PASSWORD = "TestAdminPassword";
	
	private static CarServiceBl carServiceBl;
	private static ICarServiceDao carServiceDao;
	private static User user;
	
	@BeforeClass
	public static void initializeBusinessLogic() throws SQLException {
		carServiceBl = new CarServiceBl();
		carServiceDao = new CarServiceDao();
		user = new User(0, UUID.randomUUID(), TEST_ADMIN_LOGIN);
	}
	
	@Test
	public void testAccount() throws SQLException {
		carServiceBl.addAdminAccount(user, TEST_ADMIN_PASSWORD);
		boolean autorizationResult = carServiceBl.checkAutentification(TEST_ADMIN_LOGIN, TEST_ADMIN_PASSWORD);
		User actualUser = carServiceBl.getUser(TEST_ADMIN_LOGIN);
		assertEquals(TEST_ADMIN_LOGIN, actualUser.getLogin());
		assertTrue(autorizationResult);
		carServiceBl.deleteAccount(actualUser);
		autorizationResult = carServiceBl.checkAutentification(TEST_ADMIN_LOGIN, TEST_ADMIN_PASSWORD);
		assertFalse(autorizationResult);
	}
	
	@After
	public void deleteData() throws SQLException {
		carServiceDao.deletePassword(new Password((TEST_ADMIN_PASSWORD.hashCode() ^ TEST_ADMIN_LOGIN.hashCode()) | TEST_ADMIN_PASSWORD.hashCode()));
	}
	
	@AfterClass
	public static void dispose() throws SQLException {
		carServiceDao.dispose();
	}
}
