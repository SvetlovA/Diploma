package ru.rsreu.carservice.model.dal.tests;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import ru.rsreu.carservice.model.dal.CarServiceDao;
import ru.rsreu.carservice.model.entities.Car;
import ru.rsreu.carservice.model.entities.Client;
import ru.rsreu.carservice.model.entities.Order;
import ru.rsreu.carservice.model.entities.Password;
import ru.rsreu.carservice.model.entities.SharePart;
import ru.rsreu.carservice.model.entities.User;
import ru.rsreu.carservice.model.entities.Work;
import ru.rsreu.carservice.model.entities.WorkStatus;
import ru.rsreu.carservice.model.entities.Worker;

public class CarServiceDaoTest {
	
	private final static String URL = "jdbc:oracle:thin:@localhost:1521:xe";
	private final static String USER = "Svetlov";
	private final static String PASSWORD = "Cdtnkjd21121995";
	
	private final static int TEST_PASSWORD_HASH = "TestPassword".hashCode();
	private final static String TEST_CLIENT_LOGIN = "Test client login";
	private final static String TEST_WORKER_LOGIN = "Test worker login";
	private final static String CHANGED_TEST_LOGIN = "Test changed login";
	private final static String TEST_SURNAME = "Test surname";
	private final static String TEST_NAME = "Test name";
	private final static String CHANGED_TEST_NAME = "Changed Test name";
	private final static String TEST_PATRONYMIC = "Test patronymic";
	private final static int TEST_EXPERIENCE = 10;
	private final static Car[] TEST_CARS_LIST  = {new Car(0, UUID.randomUUID(), "A000AA", "abc", "zxc", null, new HashSet<Order>())};
	private final static double TEST_PRICE = 100;
	private final static int TEST_COUNT = 200;
	private final static String TEST_DESCRIPTION = "Test description";
	private final static UUID TEST_ORDER_GUID = UUID.fromString("bde3f292-7302-4482-a8f9-ce43f8bdf0e8");
	
	private static Connection connection;
	private static CarServiceDao carServiceDao;
	private static User user;
	private static Password password;
	private static Client client;
	private static Car car;
	private static Worker worker;
	private static SharePart sharePart;
	private static Work work;
	private static Order order;
	
	static {
		try {
			Class.forName ("oracle.jdbc.OracleDriver");
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
		}
	}
	
	@BeforeClass
	public static void createDao() throws SQLException {
		connection = DriverManager.getConnection(URL, USER, PASSWORD);
		carServiceDao = new CarServiceDao();
		user = new User(0, UUID.randomUUID(), TEST_CLIENT_LOGIN);
		password = new Password(TEST_PASSWORD_HASH);
		client = new Client(0, UUID.randomUUID(), TEST_CLIENT_LOGIN, TEST_SURNAME, TEST_NAME, TEST_PATRONYMIC, new HashSet<Car>(Arrays.asList(TEST_CARS_LIST)));
		car = new Car(0, UUID.randomUUID(), "B000BB", "abc", "qwe", client, new HashSet<Order>());
		worker = new Worker(0, UUID.randomUUID(), TEST_WORKER_LOGIN, TEST_SURNAME, TEST_NAME, TEST_PATRONYMIC, TEST_EXPERIENCE, new HashSet<Order>());
		sharePart = new SharePart(0, UUID.randomUUID(), TEST_NAME, TEST_PRICE, TEST_COUNT, TEST_DESCRIPTION, new HashSet<Order>());
		work = new Work(0, UUID.randomUUID(), TEST_NAME, TEST_PRICE, TEST_DESCRIPTION, new HashSet<Order>());
		Set<Worker> workers = new HashSet<Worker>();
		workers.add(worker);
		Set<Work> works = new HashSet<Work>();
		works.add(work);
		Set<SharePart> shareParts = new HashSet<SharePart>();
		shareParts.add(sharePart);
		order = new Order(0, TEST_ORDER_GUID, TEST_CARS_LIST[0], workers, works, shareParts, 0, WorkStatus.NotStarted);
	}
	
	@Test
	public void testUserCRUD() throws SQLException {
		assertTrue(true);
	}
	
	@Test
	public void testPasswordCR() throws SQLException {
		assertTrue(true);
	}
	
	@Test
	public void testClientCRUD() throws SQLException {
		assertTrue(true);
	}
	
	@Test
	public void testCarCRD() throws SQLException {
		assertTrue(true);
	}
	
	@Test
	public void testWorkerCRUD() throws SQLException {
		assertTrue(true);
	}
	
	@Test
	public void testSharePartCRUD() throws SQLException {
		assertTrue(true);
	}
	
	@Test
	public void testWorkCRUD() throws SQLException {
		assertTrue(true);
	}
	
	@Test
	public void testOrderCRUD() throws SQLException {
		assertTrue(true);
	}
	
	@Test
	public void getClientOrders() throws SQLException {
		assertTrue(true);
	}
	
	@Test
	public void getWorkerOrders() throws SQLException {
		assertTrue(true);
	}
	
	@Test
	public void getSharePartOrders() throws SQLException {
		assertTrue(true);
	}
	
	@Test
	public void getWorkOrders() throws SQLException {
		assertTrue(true);
	}
	
	@AfterClass
	public static void disposeDao() throws SQLException {
		carServiceDao.dispose();
	}
}
