package ru.rsreu.carservice.model.dal.tests;

import static org.junit.Assert.*;

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
	
	private static CarServiceDao carServiceDao;
	private static User user;
	private static Password password;
	private static Client client;
	private static Car car;
	private static Worker worker;
	private static SharePart sharePart;
	private static Work work;
	private static Order order;
	
	@BeforeClass
	public static void createDao() throws SQLException {
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
		carServiceDao.addUser(user);
		User actualUser = carServiceDao.readUser(TEST_CLIENT_LOGIN);
		assertEquals(user, actualUser);
		actualUser.setLogin(CHANGED_TEST_LOGIN);
		carServiceDao.updateUser(actualUser);
		actualUser = carServiceDao.readUser(CHANGED_TEST_LOGIN);
		assertNotEquals(user, actualUser);
		carServiceDao.deleteUser(actualUser);
		actualUser = carServiceDao.readUser(CHANGED_TEST_LOGIN);
		assertNull(actualUser);
	}
	
	@Test
	public void testPasswordCR() throws SQLException {
		carServiceDao.addPassword(password);
		Password actualPassword = carServiceDao.readPassword(TEST_PASSWORD_HASH);
		assertEquals(password, actualPassword);
	}
	
	@Test
	public void testClientCRUD() throws SQLException {
		carServiceDao.addClient(client);
		Client actualClient = carServiceDao.readClient(TEST_CLIENT_LOGIN);
		assertEquals(client, actualClient);
		actualClient.setName(CHANGED_TEST_NAME);
		carServiceDao.updateClient(actualClient);
		actualClient = carServiceDao.readClient(TEST_CLIENT_LOGIN);
		assertNotEquals(client, actualClient);
		carServiceDao.deleteUser(actualClient);
		actualClient = carServiceDao.readClient(TEST_CLIENT_LOGIN);
		assertNull(actualClient);
	}
	
	@Test
	public void testCarCRD() throws SQLException {
		Set<Car> expectedCars = new HashSet<Car>(client.getCars());
		expectedCars.add(car);
		carServiceDao.addClient(client);
		carServiceDao.addCar(car);
		Set<Car> actualCars = carServiceDao.readClientCars(client);
		assertEquals(expectedCars, actualCars);
		carServiceDao.deleteCar(car);
		actualCars = carServiceDao.readClientCars(client);
		assertNotEquals(expectedCars, actualCars);
		carServiceDao.deleteUser(client);
	}
	
	@Test
	public void testWorkerCRUD() throws SQLException {
		carServiceDao.addWorker(worker);
		Worker actualWorker = carServiceDao.readWorker(TEST_WORKER_LOGIN);
		assertEquals(worker, actualWorker);
		actualWorker.setName(CHANGED_TEST_NAME);
		carServiceDao.updateWorker(actualWorker);
		actualWorker = carServiceDao.readWorker(TEST_WORKER_LOGIN);
		assertNotEquals(worker, actualWorker);
		carServiceDao.deleteUser(actualWorker);
		actualWorker = carServiceDao.readWorker(TEST_WORKER_LOGIN);
		assertNull(actualWorker);
	}
	
	@Test
	public void testSharePartCRUD() throws SQLException {
		carServiceDao.addSharePart(sharePart);
		SharePart actualSharePart = carServiceDao.readSharePart(TEST_NAME);
		assertEquals(sharePart, actualSharePart);
		actualSharePart.setName(CHANGED_TEST_NAME);
		carServiceDao.updateSharePart(actualSharePart);
		actualSharePart = carServiceDao.readSharePart(CHANGED_TEST_NAME);
		assertNotEquals(sharePart, actualSharePart);
		carServiceDao.deleteSharePart(actualSharePart);
		actualSharePart = carServiceDao.readSharePart(CHANGED_TEST_NAME);
		assertNull(actualSharePart);
	}
	
	@Test
	public void testWorkCRUD() throws SQLException {
		carServiceDao.addWork(work);
		Work actualWork = carServiceDao.readWork(TEST_NAME);
		assertEquals(work, actualWork);
		actualWork.setName(CHANGED_TEST_NAME);
		carServiceDao.updateWork(actualWork);
		actualWork = carServiceDao.readWork(CHANGED_TEST_NAME);
		assertNotEquals(work, actualWork);
		carServiceDao.deleteWork(actualWork);
		actualWork = carServiceDao.readWork(CHANGED_TEST_NAME);
		assertNull(actualWork);
	}
	
	@Test
	public void testOrderCRUD() throws SQLException {
		carServiceDao.addClient(client);
		carServiceDao.addWorker(worker);
		carServiceDao.addWork(work);
		carServiceDao.addSharePart(sharePart);
		carServiceDao.addOrder(order);
		for (Worker worker : order.getWorkers()) {
			carServiceDao.addOrderWorker(order, worker);
		}
		for (SharePart sharePart : order.getShareParts()) {
			carServiceDao.addOrderSharePart(order, sharePart);
		}
		for (Work work : order.getWorks()) {
			carServiceDao.addOrderWork(order, work);
		}
		Order actualOrder = carServiceDao.readOrder(TEST_ORDER_GUID);
		assertEquals(order, actualOrder);
		actualOrder.setStatus(WorkStatus.Completed);
		carServiceDao.updateOrder(actualOrder);
		actualOrder = carServiceDao.readOrder(TEST_ORDER_GUID);
		assertNotEquals(order, actualOrder);
		carServiceDao.deleteOrder(actualOrder);
		actualOrder = carServiceDao.readOrder(TEST_ORDER_GUID);
		assertNull(actualOrder);
		carServiceDao.deleteUser(client);
		carServiceDao.deleteUser(worker);
		carServiceDao.deleteWork(work);
		carServiceDao.deleteSharePart(sharePart);
	}
	
	@Test
	public void getClientOrders() throws SQLException {
		carServiceDao.addClient(client);
		carServiceDao.addWorker(worker);
		carServiceDao.addWork(work);
		carServiceDao.addSharePart(sharePart);
		carServiceDao.addOrder(order);
		Car readedCar = carServiceDao.readCar("A000AA");
		Set<Order> carOrders = readedCar.getOrders();
		assertFalse(carOrders.isEmpty());
	}
	
	@Test
	public void getWorkerOrders() throws SQLException {
		carServiceDao.addClient(client);
		carServiceDao.addWorker(worker);
		carServiceDao.addWork(work);
		carServiceDao.addSharePart(sharePart);
		carServiceDao.addOrder(order);
		for (Worker worker : order.getWorkers()) {
			carServiceDao.addOrderWorker(order, worker);
		}
		Worker readedWorker = carServiceDao.readWorker(TEST_WORKER_LOGIN);
		Set<Order> workerOrder = readedWorker.getOrders();
		assertFalse(workerOrder.isEmpty());
	}
	
	@Test
	public void getSharePartOrders() throws SQLException {
		carServiceDao.addClient(client);
		carServiceDao.addWorker(worker);
		carServiceDao.addWork(work);
		carServiceDao.addSharePart(sharePart);
		carServiceDao.addOrder(order);
		for (SharePart sharePart : order.getShareParts()) {
			carServiceDao.addOrderSharePart(order, sharePart);
		}
		SharePart readedSharePart = carServiceDao.readSharePart(TEST_NAME);
		Set<Order> sharePartOrders = readedSharePart.getOrders();
		assertFalse(sharePartOrders.isEmpty());
	}
	
	@Test
	public void getWorkOrders() throws SQLException {
		carServiceDao.addClient(client);
		carServiceDao.addWorker(worker);
		carServiceDao.addWork(work);
		carServiceDao.addSharePart(sharePart);
		carServiceDao.addOrder(order);
		for (Work work : order.getWorks()) {
			carServiceDao.addOrderWork(order, work);
		}
		Work readedWork = carServiceDao.readWork(TEST_NAME);
		Set<Order> workOrders = readedWork.getOrders();
		assertFalse(workOrders.isEmpty());
	}
	
	@After
	public void deleteEntities() throws SQLException {
		carServiceDao.deletePassword(password);
		carServiceDao.deleteUser(user);
		carServiceDao.deleteUser(client);
		carServiceDao.deleteUser(worker);
		carServiceDao.deleteWork(work);
		carServiceDao.deleteSharePart(sharePart);
	}
	
	@AfterClass
	public static void disposeDao() throws SQLException {
		carServiceDao.dispose();
	}
}
