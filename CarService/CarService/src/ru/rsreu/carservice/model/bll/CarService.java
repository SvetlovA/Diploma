package ru.rsreu.carservice.model.bll;

import java.sql.SQLException;
import java.util.Set;
import java.util.UUID;

import ru.rsreu.carservice.model.dal.CarServiceDao;
import ru.rsreu.carservice.model.dal.ICarServiceDao;
import ru.rsreu.carservice.model.dal.exceptions.DataBaseException;
import ru.rsreu.carservice.model.entities.Car;
import ru.rsreu.carservice.model.entities.Client;
import ru.rsreu.carservice.model.entities.Order;
import ru.rsreu.carservice.model.entities.SharePart;
import ru.rsreu.carservice.model.entities.User;
import ru.rsreu.carservice.model.entities.Work;
import ru.rsreu.carservice.model.entities.Worker;

public class CarService {
	
	private ICarServiceDao carServiceDao;
	
	public CarService() throws SQLException {
		this.carServiceDao = new CarServiceDao();
	}
	
	public boolean checkAutentification(String login, String password) throws DataBaseException {
		User user = this.carServiceDao.readUser(login);
		if (user == null || password == null || password.isEmpty()) {
			return false;
		}
		int passwordHash = generateSaultPasswordHash(user.getLogin(), password);
		return this.carServiceDao.checkPassword(passwordHash);
	}
	
	public void addAccount(User user, String password) throws DataBaseException, SQLException {
		int saultPasswordHash = generateSaultPasswordHash(user.getLogin(), password);
		this.carServiceDao.addAccount(user, saultPasswordHash);
	}
	
	private int generateSaultPasswordHash(String login, String password) {
		return (password.hashCode() ^ login.hashCode()) | password.hashCode();
	}
	
	public Permission getPermission(String login) throws Exception {
		User user = this.carServiceDao.readUser(login);
		if (user == null) {
			throw new Exception("No access rights.");
		}
		Client client = this.carServiceDao.readClient(login);
		if (client != null) {
			return Permission.CLIENT;
		}
		Worker worker = this.carServiceDao.readWorker(login);
		if (worker != null) {
			return Permission.WORKER;
		}
		return Permission.ADMIN;
	}
	
	public void addOrder(Order order) throws DataBaseException {
		this.carServiceDao.addOrder(order);
	}
	
	public void addOrder(Order order, Set<Work> works, Set<SharePart> shareParts) throws DataBaseException {
		addOrder(order);
		addOrderWorks(order, works);
		addOrderShareParts(order, shareParts);
	}
	
	public void addWork(Work work) throws DataBaseException {
		this.carServiceDao.addWork(work);
	}
	
	public void addSharePart(SharePart sharePart) throws DataBaseException {
		this.carServiceDao.addSharePart(sharePart);
	}
	
	public void addCar(Car car) throws DataBaseException {
		this.carServiceDao.addCar(car);
	}
	
	public void addOrderWorkers(Order order, Set<Worker> workers) throws DataBaseException {
		for (Worker worker : workers) {
			this.carServiceDao.addOrderWorker(order, worker);
		}
	}
	
	public void addOrderWorks(Order order, Set<Work> works) throws DataBaseException {
		for (Work work : works) {
			this.carServiceDao.addOrderWork(order, work);
		}
	}
	
	public void addOrderShareParts(Order order, Set<SharePart> shareParts) throws DataBaseException {
		for (SharePart sharePart : shareParts) {
			this.carServiceDao.addOrderSharePart(order, sharePart);
		}
	}
 	
	public User getUser(String login) throws DataBaseException {
		return this.carServiceDao.readUser(login);
	}
	
	public Set<User> getAllAdmins() throws DataBaseException {
		return this.carServiceDao.readAllAdmins();
	}
	
	public Set<Order> getAllOrders() throws DataBaseException {
		return this.carServiceDao.readAllOrders();
	}
	
	public Set<Client> getAllClients() throws DataBaseException {
		return this.carServiceDao.readAllClients();
	}
	
	public Set<Worker> getAllWorkers() throws DataBaseException {
		return this.carServiceDao.readAllWorkers();
	}
	
	public Set<SharePart> getAllShareParts() throws DataBaseException {
		return this.carServiceDao.readAllShareParts();
	}
	
	public Set<Work> getAllWorks() throws DataBaseException {
		return this.carServiceDao.readAllWorks();
	}
	
	public Set<Car> getClientCars(Client client) throws DataBaseException {
		return this.carServiceDao.readClientCars(client);
	}
	
	public Set<Worker> getFreeWorkers() throws DataBaseException {
		return this.carServiceDao.readFreeWorkers();
	}
	
	public Set<Worker> getOrderWorkers(Order order) throws DataBaseException {
		return this.carServiceDao.readOrderWorkers(order);
	}
	
	public Set<Work> getOrderWorks(Order order) throws DataBaseException {
		return this.carServiceDao.readOrderWorks(order);
	}
	
	public Set<SharePart> getOrderShareParts(Order order) throws DataBaseException {
		return this.carServiceDao.readOrderShareParts(order);
	}
	
	public Client getClient(String login) throws DataBaseException {
		return this.carServiceDao.readClient(login);
	}
	
	public Worker getWorker(String login) throws DataBaseException {
		return this.carServiceDao.readWorker(login);
	}
	
	public Worker getWorker(UUID workerGuid) throws DataBaseException {
		return this.carServiceDao.readWorker(workerGuid);
	}
	
	public Work getWork(UUID workGuid) throws DataBaseException {
		return this.carServiceDao.readWork(workGuid);
	}
	
	public SharePart getSharePart(UUID sharePartGuid) throws DataBaseException {
		return this.carServiceDao.readSharePart(sharePartGuid);
	}
	
	public Car getCar(String stateNumber) throws DataBaseException {
		return this.carServiceDao.readCar(stateNumber);
	}
	
	public Set<Order> getClientOrders(Client client) throws DataBaseException {
		return this.carServiceDao.readClientOrders(client);
	}
	
	public Set<Order> getWorkerOrders(Worker worker) throws DataBaseException {
		return this.carServiceDao.readWorkerOrders(worker);
	}
	
	public void updateUser(User user) throws DataBaseException {
		this.carServiceDao.updateUser(user);
	}
	
	public void updateWorker(Worker worker) throws DataBaseException {
		this.carServiceDao.updateWorker(worker);
	}
	
	public void updateWork(Work work) throws DataBaseException {
		this.carServiceDao.updateWork(work);
	}
	
	public void updateSharePart(SharePart sharePart) throws DataBaseException {
		this.carServiceDao.updateSharePart(sharePart);
	}
	
	public void updateClient(Client client) throws DataBaseException {
		this.carServiceDao.updateClient(client);
	}
	
	public void updateOrder(Order order) throws DataBaseException {
		this.carServiceDao.updateOrder(order);
	}
	
	public void deleteUser(User user) throws DataBaseException {
		this.carServiceDao.deleteUser(user);
	}
	
	public void deleteOrderWorkers(Order order, Set<Worker> workers) throws DataBaseException {
		for (Worker worker : workers) {
			this.carServiceDao.deleteOrderWorker(order, worker);
		}
	}
	
	public void deleteOrderWorks(Order order, Set<Work> works) throws DataBaseException {
		for (Work work: works) {
			this.carServiceDao.deleteOrderWork(order, work);
		}
	}
	
	public void deleteOrderShareParts(Order order, Set<SharePart> shareParts) throws DataBaseException {
		for (SharePart sharePart : shareParts) {
			this.carServiceDao.deleteOrderSharePart(order, sharePart);
		}
	}
	
	public void deleteWork(Work work) throws DataBaseException {
		this.carServiceDao.deleteAllOrderWorks(work);
		this.carServiceDao.deleteWork(work);
	}
	
	public void deleteSharePart(SharePart sharePart) throws DataBaseException {
		this.carServiceDao.deleteAllOrderShareParts(sharePart);
		this.carServiceDao.deleteSharePart(sharePart);
	}
	
	public void deleteCar(Car car) throws DataBaseException {
		this.carServiceDao.deleteCar(car);
	}
	
	public void deleteAllOrderWorkers(Order order) throws DataBaseException {
		Set<Worker> workers = order.getWorkers();
		if (workers != null) {
			for (Worker worker : workers) {
				this.carServiceDao.deleteOrderWorker(order, worker);
			}
		}
	}
	
	public void deleteAllOrderWorks(Order order) throws DataBaseException {
		Set<Work> works = order.getWorks();
		if (works != null) {
			for (Work work : works) {
				this.carServiceDao.deleteOrderWork(order, work);
			}
		}
	}
	
	public void deleteAllOrderShareParts(Order order) throws DataBaseException {
		Set<SharePart> shareParts = order.getShareParts();
		if (shareParts != null) {
			for (SharePart sharePart : shareParts) {
				this.carServiceDao.deleteOrderSharePart(order, sharePart);
			}
		}
	}
	
	public void deleteOrder(Order order) throws DataBaseException {
		deleteAllOrderWorkers(order);
		deleteAllOrderWorks(order);
		deleteAllOrderShareParts(order);
		this.carServiceDao.deleteOrder(order);
	}
}
