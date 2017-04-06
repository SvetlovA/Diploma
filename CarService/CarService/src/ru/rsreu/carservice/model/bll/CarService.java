package ru.rsreu.carservice.model.bll;

import java.sql.SQLException;
import java.util.Set;
import java.util.UUID;

import ru.rsreu.carservice.model.dal.CarServiceDao;
import ru.rsreu.carservice.model.dal.ICarServiceDao;
import ru.rsreu.carservice.model.entities.Car;
import ru.rsreu.carservice.model.entities.Client;
import ru.rsreu.carservice.model.entities.Order;
import ru.rsreu.carservice.model.entities.Password;
import ru.rsreu.carservice.model.entities.SharePart;
import ru.rsreu.carservice.model.entities.User;
import ru.rsreu.carservice.model.entities.Work;
import ru.rsreu.carservice.model.entities.Worker;

public class CarService {
	
	private ICarServiceDao carServiceDao;
	
	public CarService() throws SQLException {
		this.carServiceDao = new CarServiceDao();
	}
	
	public boolean checkAutentification(String login, String password) throws SQLException {
		User user = this.carServiceDao.readUser(login);
		if (user == null || password == null || password.isEmpty()) {
			return false;
		}
		int passwordHash = (password.hashCode() ^ user.getLogin().hashCode()) | password.hashCode();
		Password passwordEntity = this.carServiceDao.readPassword(passwordHash);
		return passwordEntity != null;
	}
	
	public void addAdminAccount(User user, String password) throws SQLException {
		int saultPasswordHash = (password.hashCode() ^ user.getLogin().hashCode()) | password.hashCode();
		Password passwordHash = new Password(saultPasswordHash);
		this.carServiceDao.addUser(user);
		this.carServiceDao.addPassword(passwordHash);
	}
	
	public void addClient(Client client, String password) throws SQLException {
		int saultPasswordHash = (password.hashCode() ^ client.getLogin().hashCode()) | password.hashCode();
		Password passwordHash = new Password(saultPasswordHash);
		this.carServiceDao.addClient(client);
		this.carServiceDao.addPassword(passwordHash);
	}
	
	public void addWorker(Worker worker, String password) throws SQLException {
		int saultPasswordHash = (password.hashCode() ^ worker.getLogin().hashCode()) | password.hashCode();
		Password passwordHash = new Password(saultPasswordHash);
		this.carServiceDao.addWorker(worker);
		this.carServiceDao.addPassword(passwordHash);
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
	
	public void addOrder(Order order) throws SQLException {
		this.carServiceDao.addOrder(order);
	}
	
	public void addOrder(Order order, Set<Work> works, Set<SharePart> shareParts) throws SQLException {
		addOrder(order);
		addOrderWorks(order, works);
		addOrderShareParts(order, shareParts);
	}
	
	public void addWork(Work work) throws SQLException {
		this.carServiceDao.addWork(work);
	}
	
	public void addSharePart(SharePart sharePart) throws SQLException {
		this.carServiceDao.addSharePart(sharePart);
	}
	
	public void addCar(Car car) throws SQLException {
		this.carServiceDao.addCar(car);
	}
	
	public void addOrderWorkers(Order order, Set<Worker> workers) throws SQLException {
		for (Worker worker : workers) {
			this.carServiceDao.addOrderWorker(order, worker);
		}
	}
	
	public void addOrderWorks(Order order, Set<Work> works) throws SQLException {
		for (Work work : works) {
			this.carServiceDao.addOrderWork(order, work);
		}
	}
	
	public void addOrderShareParts(Order order, Set<SharePart> shareParts) throws SQLException {
		for (SharePart sharePart : shareParts) {
			this.carServiceDao.addOrderSharePart(order, sharePart);
		}
	}
 	
	public User getUser(String login) throws SQLException {
		return this.carServiceDao.readUser(login);
	}
	
	public Set<Order> getAllOrders() throws SQLException {
		return this.carServiceDao.readAllOrders();
	}
	
	public Set<Client> getAllClients() throws SQLException {
		return this.carServiceDao.readAllClients();
	}
	
	public Set<Worker> getAllWorkers() throws SQLException {
		return this.carServiceDao.readAllWorkers();
	}
	
	public Set<SharePart> getAllShareParts() throws SQLException {
		return this.carServiceDao.readAllShareParts();
	}
	
	public Set<Work> getAllWorks() throws SQLException {
		return this.carServiceDao.readAllWorks();
	}
	
	public Set<Car> getClientCars(Client client) throws SQLException {
		return this.carServiceDao.readClientCars(client);
	}
	
	public Set<Worker> getFreeWorkers() throws SQLException {
		return this.carServiceDao.readFreeWorkers();
	}
	
	public Set<Worker> getOrderWorkers(Order order) throws SQLException {
		return this.carServiceDao.readOrderWorkers(order);
	}
	
	public Set<Work> getOrderWorks(Order order) throws SQLException {
		return this.carServiceDao.readOrderWorks(order);
	}
	
	public Set<SharePart> getOrderShareParts(Order order) throws SQLException {
		return this.carServiceDao.readOrderShareParts(order);
	}
	
	public Client getClient(String login) throws SQLException {
		return this.carServiceDao.readClient(login);
	}
	
	public Worker getWorker(String login) throws SQLException {
		return this.carServiceDao.readWorker(login);
	}
	
	public Worker getWorker(UUID workerGuid) throws SQLException {
		return this.carServiceDao.readWorker(workerGuid);
	}
	
	public Work getWork(UUID workGuid) throws SQLException {
		return this.carServiceDao.readWork(workGuid);
	}
	
	public SharePart getSharePart(UUID sharePartGuid) throws SQLException {
		return this.carServiceDao.readSharePart(sharePartGuid);
	}
	
	public Car getCar(String stateNumber) throws SQLException {
		return this.carServiceDao.readCar(stateNumber);
	}
	
	public Set<Order> getClientOrders(Client client) throws SQLException {
		return this.carServiceDao.readClientOrders(client);
	}
	
	public Set<Order> getWorkerOrders(Worker worker) throws SQLException {
		return this.carServiceDao.readWorkerOrders(worker);
	}
	
	public void updateUser(User user) throws SQLException {
		this.carServiceDao.updateUser(user);
	}
	
	public void updateWorker(Worker worker) throws SQLException {
		this.carServiceDao.updateWorker(worker);
	}
	
	public void updateWork(Work work) throws SQLException {
		this.carServiceDao.updateWork(work);
	}
	
	public void updateSharePart(SharePart sharePart) throws SQLException {
		this.carServiceDao.updateSharePart(sharePart);
	}
	
	public void updateClient(Client client) throws SQLException {
		this.carServiceDao.updateClient(client);
	}
	
	public void updateOrder(Order order) throws SQLException {
		this.carServiceDao.updateOrder(order);
	}
	
	public void deleteAccount(User user) throws SQLException {
		this.carServiceDao.deleteUser(user);
	}
	
	public void deleteUser(User user) throws SQLException {
		this.carServiceDao.deleteUser(user);
	}
	
	public void deleteOrderWorkers(Order order, Set<Worker> workers) throws SQLException {
		for (Worker worker : workers) {
			this.carServiceDao.deleteOrderWorker(order, worker);
		}
	}
	
	public void deleteOrderWorks(Order order, Set<Work> works) throws SQLException {
		for (Work work: works) {
			this.carServiceDao.deleteOrderWork(order, work);
		}
	}
	
	public void deleteOrderShareParts(Order order, Set<SharePart> shareParts) throws SQLException {
		for (SharePart sharePart : shareParts) {
			this.carServiceDao.deleteOrderSharePart(order, sharePart);
		}
	}
	
	public void deleteWork(Work work) throws SQLException {
		this.carServiceDao.deleteAllOrderWorks(work);
		this.carServiceDao.deleteWork(work);
	}
	
	public void deleteSharePart(SharePart sharePart) throws SQLException {
		this.carServiceDao.deleteAllOrderShareParts(sharePart);
		this.carServiceDao.deleteSharePart(sharePart);
	}
	
	public void deleteCar(Car car) throws SQLException {
		this.carServiceDao.deleteCar(car);
	}
	
	public void deleteAllOrderWorkers(Order order) throws SQLException {
		Set<Worker> workers = order.getWorkers();
		if (workers != null) {
			for (Worker worker : workers) {
				this.carServiceDao.deleteOrderWorker(order, worker);
			}
		}
	}
	
	public void deleteAllOrderWorks(Order order) throws SQLException {
		Set<Work> works = order.getWorks();
		if (works != null) {
			for (Work work : works) {
				this.carServiceDao.deleteOrderWork(order, work);
			}
		}
	}
	
	public void deleteAllOrderShareParts(Order order) throws SQLException {
		Set<SharePart> shareParts = order.getShareParts();
		if (shareParts != null) {
			for (SharePart sharePart : shareParts) {
				this.carServiceDao.deleteOrderSharePart(order, sharePart);
			}
		}
	}
	
	public void deleteOrder(Order order) throws SQLException {
		deleteAllOrderWorkers(order);
		deleteAllOrderWorks(order);
		deleteAllOrderShareParts(order);
		this.carServiceDao.deleteOrder(order);
	}
}
