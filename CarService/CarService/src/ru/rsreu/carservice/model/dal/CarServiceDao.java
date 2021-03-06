package ru.rsreu.carservice.model.dal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import resources.Resourcer;
import ru.rsreu.carservice.model.dal.exceptions.AddCarException;
import ru.rsreu.carservice.model.dal.exceptions.AddPasswordException;
import ru.rsreu.carservice.model.dal.exceptions.AddUserException;
import ru.rsreu.carservice.model.dal.exceptions.DataBaseException;
import ru.rsreu.carservice.model.entities.Car;
import ru.rsreu.carservice.model.entities.Client;
import ru.rsreu.carservice.model.entities.Order;
import ru.rsreu.carservice.model.entities.SharePart;
import ru.rsreu.carservice.model.entities.User;
import ru.rsreu.carservice.model.entities.Work;
import ru.rsreu.carservice.model.entities.Worker;

public class CarServiceDao implements ICarServiceDao {
	
	private final static String URL = "jdbc:oracle:thin:@localhost:1521:xe";
	private final static String USER = "Svetlov";
	private final static String PASSWORD = "Cdtnkjd21121995";
	
	private Connection connection;
	
	static {
		try {
			Class.forName ("oracle.jdbc.OracleDriver");
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
		}
	}
	
	public CarServiceDao() throws SQLException {
		this.connection = DriverManager.getConnection(URL, USER, PASSWORD);
	}
	
	@Override
	public void addAccount(User user, int passwordHash) throws DataBaseException, SQLException {
		try {
			this.connection.setAutoCommit(false);
			if (user instanceof Client) {
				addClient((Client)user);
			} else if (user instanceof Worker) {
				addWorker((Worker)user);
			} else {
				addUser(user);
			}
			addPassword(passwordHash);
			this.connection.commit();
		} catch (DataBaseException ex) {
			this.connection.rollback();
			throw ex;
		} catch (SQLException ex) {
			this.connection.rollback();
			throw new DataBaseException(Resourcer.getString("message.add.user.exception"), ex);
		} finally {
			this.connection.setAutoCommit(true);
		}
	}
	
	private void addUser(User user)throws DataBaseException, SQLException {
		if (user == null) {
			throw new NullPointerException(Resourcer.getString("message.user.null"));
		}
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = this.connection.prepareStatement(Resourcer.getString("query.add.user"));
			preparedStatement.setString(1, user.getUserGuid().toString());
			preparedStatement.setString(2, user.getLogin());
			preparedStatement.executeUpdate();
		} catch (SQLIntegrityConstraintViolationException ex) {
			throw new AddUserException(Resourcer.getString("message.add.user.exception"), ex, user.getLogin());
		} finally {
			preparedStatement.close();
		}
	}

	private void addPassword(int passwordHash) throws DataBaseException, SQLException {
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = this.connection.prepareStatement(Resourcer.getString("query.add.password"));
			preparedStatement.setInt(1, passwordHash);
			preparedStatement.executeUpdate();
		} catch(SQLIntegrityConstraintViolationException ex) {
			throw new AddPasswordException(Resourcer.getString("message.add.password.exception"), ex);
		} finally {
			preparedStatement.close();
		}
	}

	private void addClient(Client client) throws DataBaseException, SQLException {
		if (client == null) {
			throw new NullPointerException(Resourcer.getString("message.client.null"));
		}
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = this.connection.prepareStatement(Resourcer.getString("query.add.client"));
			addUser(new User(client.getUserId(), client.getUserGuid(), client.getLogin(), client.getIsOnline()));
			User user = readUser(client.getLogin());
			if (user == null) {
				throw new NullPointerException(Resourcer.getString("message.user.null"));
			}
			preparedStatement.setInt(1, user.getUserId());
			preparedStatement.setString(2, client.getSurname());
			preparedStatement.setString(3, client.getName());
			preparedStatement.setString(4, client.getPatronymic());
			preparedStatement.executeUpdate();
			Set<Car> clientCars = client.getCars();
			if (clientCars != null) {
				for (Car car : client.getCars()) {
					car.setClient(client);
					addCar(car);
				}
			}
		} catch (SQLIntegrityConstraintViolationException ex) {
			throw new AddUserException(Resourcer.getString("message.add.client.exception"), ex, client.getLogin());
		} finally {
			preparedStatement.close();
		}
	}
	
	@Override
	public void addCar(Car car) throws DataBaseException {
		if (car == null) {
			throw new NullPointerException(Resourcer.getString("message.car.null"));
		}
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = this.connection.prepareStatement(Resourcer.getString("query.add.car"));
			preparedStatement.setString(1, car.getCarGuid().toString());
			Client client = car.getClient();
			User user = readUser(client.getLogin());
			if (user == null) {
				throw new NullPointerException(Resourcer.getString("message.user.null"));
			}
			preparedStatement.setInt(2, user.getUserId());
			preparedStatement.setString(3, car.getNumber());
			preparedStatement.setString(4, car.getMark());
			preparedStatement.setString(5, car.getModel());
			preparedStatement.executeUpdate();
		} catch (SQLIntegrityConstraintViolationException ex) {
			throw new AddCarException(Resourcer.getString("message.add.car.exception"), ex, car.getNumber());
		} catch (SQLException ex) {
			throw new DataBaseException(Resourcer.getString("message.add.car.exception"), ex);
		} finally {
			try {
				preparedStatement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	private void addWorker(Worker worker) throws DataBaseException, SQLException {
		if (worker == null) {
			throw new NullPointerException(Resourcer.getString("message.worker.null"));
		}
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = this.connection.prepareStatement(Resourcer.getString("query.add.worker"));
			addUser(new User(worker.getUserId(), worker.getUserGuid(), worker.getLogin(), worker.getIsOnline()));
			User user = readUser(worker.getLogin());
			if (user == null) {
				throw new NullPointerException(Resourcer.getString("message.user.null"));
			}
			preparedStatement.setInt(1, user.getUserId());
			preparedStatement.setString(2, worker.getSurname());
			preparedStatement.setString(3, worker.getName());
			preparedStatement.setString(4, worker.getPatronymic());
			preparedStatement.setInt(5, worker.getExperience());
			preparedStatement.executeUpdate();
		} catch (SQLIntegrityConstraintViolationException ex){
			throw new AddUserException(Resourcer.getString("message.add.worker.exception"), ex, worker.getLogin());
		} finally {
			preparedStatement.close();
		}
	}
	
	@Override
	public void addSharePart(SharePart sharePart) throws DataBaseException {
		if (sharePart == null) {
			throw new NullPointerException(Resourcer.getString("message.sharepart.null"));
		}
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = this.connection.prepareStatement(Resourcer.getString("query.add.sharepart"));
			preparedStatement.setString(1, sharePart.getSharePartGuid().toString());
			preparedStatement.setString(2, sharePart.getName());
			preparedStatement.setDouble(3, sharePart.getPrice());
			preparedStatement.setInt(4, sharePart.getCount());
			preparedStatement.setString(5, sharePart.getDescription());
			preparedStatement.executeUpdate();
		} catch (SQLException ex) {
			throw new DataBaseException(Resourcer.getString("message.add.sharepart.exception"), ex);
		} finally {
			try {
				preparedStatement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	@Override
	public void addWork(Work work) throws DataBaseException {
		if (work == null) {
			throw new NullPointerException(Resourcer.getString("message.work.null"));
		}
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = this.connection.prepareStatement(Resourcer.getString("query.add.work"));
			preparedStatement.setString(1, work.getWorkGuid().toString());
			preparedStatement.setString(2, work.getName());
			preparedStatement.setDouble(3, work.getPrice());
			preparedStatement.setString(4, work.getDescription());
			preparedStatement.executeUpdate();
		} catch (SQLException ex) {
			throw new DataBaseException(Resourcer.getString("message.add.work.exception"), ex);
		} finally {
			try {
				preparedStatement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	@Override
	public void addOrder(Order order) throws DataBaseException {
		if (order == null) {
			throw new NullPointerException(Resourcer.getString("message.order.null"));
		}
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = this.connection.prepareStatement(Resourcer.getString("query.add.order"));
			preparedStatement.setString(1, order.getOrderGuid().toString());
			Car car = readCar(order.getCar().getNumber());
			if (car == null) {
				throw new NullPointerException(Resourcer.getString("message.car.null"));
			}
			preparedStatement.setInt(2, car.getCarId());
			preparedStatement.executeUpdate();
		} catch (SQLException ex) {
			throw new DataBaseException(Resourcer.getString("message.add.order.exception"), ex);
		} finally {
			try {
				preparedStatement.close();
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		}
	}
	
	@Override
	public void addOrderWork(Order order, Work work) throws DataBaseException {
		if (order == null) {
			throw new NullPointerException(Resourcer.getString("message.order.null"));
		}
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = this.connection.prepareStatement(Resourcer.getString("query.add.order.works"));
			Order readOrder = readOrder(order.getOrderGuid());
			if (readOrder == null) {
				throw new NullPointerException(Resourcer.getString("message.order.null"));
			}
			preparedStatement.setInt(1, readOrder.getOrderId());
			Work readWork = readWork(work.getName());
			if (readWork == null) {
				throw new NullPointerException(Resourcer.getString("message.work.null"));
			}
			preparedStatement.setInt(2, readWork.getWorkId());
			preparedStatement.executeUpdate();
		} catch (SQLException ex) {
			throw new DataBaseException(Resourcer.getString("message.add.order.work.exception"), ex);
		} finally {
			try {
				preparedStatement.close();
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		}
	}
	
	@Override
	public void addOrderWorker(Order order, Worker worker) throws DataBaseException {
		if (order == null) {
			throw new NullPointerException(Resourcer.getString("message.order.null"));
		}
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = this.connection.prepareStatement(Resourcer.getString("query.add.order.workers"));
			Order readOrder = readOrder(order.getOrderGuid());
			if (readOrder == null) {
				throw new NullPointerException(Resourcer.getString("message.order.null"));
			}
			preparedStatement.setInt(1, readOrder.getOrderId());
			User user = readWorker(worker.getLogin());
			if (user == null) {
				throw new NullPointerException(Resourcer.getString("message.user.null"));
			}
			preparedStatement.setInt(2, user.getUserId());
			preparedStatement.executeUpdate();
		} catch (SQLException ex) {
			throw new DataBaseException(Resourcer.getString("message.add.order.worker.exception"), ex);
		} finally {
			try {
				preparedStatement.close();
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		}
	}
	
	@Override
	public void addOrderSharePart(Order order, SharePart sharePart) throws DataBaseException {
		if (order == null) {
			throw new NullPointerException(Resourcer.getString("message.order.null"));
		}
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = this.connection.prepareStatement(Resourcer.getString("query.add.order.shareparts"));
			Order readOrder = readOrder(order.getOrderGuid());
			if (readOrder == null) {
				throw new NullPointerException(Resourcer.getString("message.order.null"));
			}
			preparedStatement.setInt(1, readOrder.getOrderId());
			SharePart readSharePart = readSharePart(sharePart.getName());
			if (readSharePart == null) {
				throw new NullPointerException(Resourcer.getString("meaage.sharepart.null"));
			}
			preparedStatement.setInt(2, readSharePart.getSharePartId());
			preparedStatement.executeUpdate();
		} catch (SQLException ex) {
			throw new DataBaseException(Resourcer.getString("message.add.order.sharepart.exception"), ex);
		} finally {
			try {
				preparedStatement.close();
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		}
	}
	
	@Override
	public User readUser(String login) throws DataBaseException {
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = this.connection.prepareStatement(Resourcer.getString("query.read.user"));
			preparedStatement.setString(1, login);
			ResultSet resultSet = null;
			try {
				resultSet = preparedStatement.executeQuery();
				if (!resultSet.next()) {
					return null;
				}
				return DataExtracter.extractUserFromResultSet(resultSet);
			} finally {
				resultSet.close();
			}
		} catch (SQLException ex) {
			throw new DataBaseException(Resourcer.getString("message.read.user.exception"), ex);
		} finally {
			try {
				preparedStatement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	@Override
	public Client readClient(String login) throws DataBaseException {
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = this.connection.prepareStatement(Resourcer.getString("query.read.client"));
			preparedStatement.setString(1, login);
			ResultSet resultSet = null;
			try {
				resultSet = preparedStatement.executeQuery();
				if (!resultSet.next()) {
					return null;
				}
				Client client = DataExtracter.extractClientFromResultSet(resultSet);
				client.setCars(readClientCars(client));
				return client;
			} finally {
				resultSet.close();
			}
		} catch (SQLException ex) {
			throw new DataBaseException(Resourcer.getString("message.read.client.exception"), ex);
		} finally {
			try {
				preparedStatement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	@Override
	public Client readClient(UUID clientGuid) throws DataBaseException {
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = this.connection.prepareStatement(Resourcer.getString("query.read.client.guid"));
			preparedStatement.setString(1, clientGuid.toString());
			ResultSet resultSet = null;
			try {
				resultSet = preparedStatement.executeQuery();
				if (!resultSet.next()) {
					return null;
				}
				Client client = DataExtracter.extractClientFromResultSet(resultSet);
				client.setCars(readClientCars(client));
				return client;
			} finally {
				resultSet.close();
			}
		} catch (SQLException ex) {
			throw new DataBaseException(Resourcer.getString("message.read.client.exception"), ex);
		} finally {
			try {
				preparedStatement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	@Override
	public Car readCar(String number) throws DataBaseException {
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = this.connection.prepareStatement(Resourcer.getString("query.read.car"));
			preparedStatement.setString(1, number);
			ResultSet resultSet = null;
			try {
				resultSet = preparedStatement.executeQuery();
				if (!resultSet.next()) {
					return null;
				}
				Car car = DataExtracter.extractCarFromResultSet(resultSet);
				Client client = findClient(resultSet.getInt("ClientId"));
				if (client == null) {
					throw new NullPointerException(Resourcer.getString("message.client.null"));
				}
				car.setClient(client);
				car.setOrders(readClientOrders(client));
				return car;
			} finally {
				resultSet.close();
			}
		} catch (SQLException ex) {
			throw new DataBaseException(Resourcer.getString("message.read.car.exception"), ex);
		} finally {
			try {
				preparedStatement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	@Override
	public Car readCar(UUID carGuid) throws DataBaseException {
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = this.connection.prepareStatement(Resourcer.getString("query.read.car.guid"));
			preparedStatement.setString(1, carGuid.toString());
			ResultSet resultSet = null;
			try {
				resultSet = preparedStatement.executeQuery();
				Client client = findClient(resultSet.getInt("ClientId"));
				if (!resultSet.next()) {
					return null;
				}
				Car car = DataExtracter.extractCarFromResultSet(resultSet);
				car.setClient(client);
				Set<Order> clientOrders = readClientOrders(client);
				car.setOrders(clientOrders);
				return car;
			} finally {
				resultSet.close();
			}
		} catch (SQLException ex) {
			throw new DataBaseException(Resourcer.getString("message.read.car.exception"), ex);
		} finally {
			try {
				preparedStatement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}
	
	private Client findClient(int clientId) throws SQLException, DataBaseException {
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = this.connection.prepareStatement(Resourcer.getString("query.find.client"));
			preparedStatement.setInt(1, clientId);
			ResultSet resultSet = null;
			try {
				resultSet = preparedStatement.executeQuery();
				if (!resultSet.next()) {
					return null;
				}
				Client client = DataExtracter.extractClientFromResultSet(resultSet);
				client.setCars(readClientCars(client));
				return client;
			} finally {
				resultSet.close();
			}
		} finally {
			preparedStatement.close();
		}
	}
	
	@Override
	public Worker readWorker(String login) throws DataBaseException {
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = this.connection.prepareStatement(Resourcer.getString("query.read.worker"));
			preparedStatement.setString(1, login);
			ResultSet resultSet = null;
			try {
				resultSet = preparedStatement.executeQuery();
				if (!resultSet.next()) {
					return null;
				}
				Worker worker = DataExtracter.extractWorkerFromResultSet(resultSet);
				worker.setOrders(readWorkerOrders(worker));
				return worker;
			} finally {
				resultSet.close();
			}
		} catch (SQLException ex) {
			throw new DataBaseException(Resourcer.getString("message.read.worker.exception"), ex);
		} finally {
			try {
				preparedStatement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	@Override
	public Worker readWorker(UUID workerGuid) throws DataBaseException {
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = this.connection.prepareStatement(Resourcer.getString("query.read.worker.guid"));
			preparedStatement.setString(1, workerGuid.toString());
			ResultSet resultSet = null;
			try {
				resultSet = preparedStatement.executeQuery();
				if (!resultSet.next()) {
					return null;
				}
				Worker worker = DataExtracter.extractWorkerFromResultSet(resultSet);
				Set<Order> workerOrders = readWorkerOrders(worker);
				worker.setOrders(workerOrders);
				return worker;
			} finally {
				resultSet.close();
			}
		} catch (SQLException ex) {
			throw new DataBaseException(Resourcer.getString("message.read.worker.exception"), ex);
		} finally {
			try {
				preparedStatement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	@Override
	public SharePart readSharePart(String name) throws DataBaseException {
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = this.connection.prepareStatement(Resourcer.getString("query.read.sharepart"));
			preparedStatement.setString(1, name);
			ResultSet resultSet = null;
			try {
				resultSet = preparedStatement.executeQuery();
				if (!resultSet.next()) {
					
					return null;
				}
				SharePart sharePart = DataExtracter.extractSharePartFromResultSet(resultSet);
				sharePart.setOrders(readSharePartOrders(sharePart));
				return sharePart;
			} finally {
				resultSet.close();
			}
		} catch (SQLException ex) {
			throw new DataBaseException(Resourcer.getString("message.read.sharepart.exception"), ex);
		} finally {
			try {
				preparedStatement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	@Override
	public SharePart readSharePart(UUID shareGuid) throws DataBaseException {
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = this.connection.prepareStatement(Resourcer.getString("query.read.sharepart.guid"));
			preparedStatement.setString(1, shareGuid.toString());
			ResultSet resultSet = null;
			try {
				resultSet = preparedStatement.executeQuery();
				if (!resultSet.next()) {
					return null;
				}
				SharePart sharePart = DataExtracter.extractSharePartFromResultSet(resultSet);
				Set<Order> sharePartOrders = readSharePartOrders(sharePart);
				sharePart.setOrders(sharePartOrders);
				return sharePart;
			} finally {
				resultSet.close();
			}
		} catch (SQLException ex) {
			throw new DataBaseException(Resourcer.getString("message.read.sharepart.exception"), ex);
		} finally {
			try {
				preparedStatement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	@Override
	public Work readWork(String name) throws DataBaseException {
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = this.connection.prepareStatement(Resourcer.getString("query.read.work"));
			preparedStatement.setString(1, name);
			ResultSet resultSet = null;
			try {
				resultSet = preparedStatement.executeQuery();
				if (!resultSet.next()) {
					return null;
				}
				Work work = DataExtracter.extractWorkFromResultSet(resultSet);
				work.setOrders(readWorkOrders(work));
				return work;
			} finally {
				resultSet.close();
			}
		} catch (SQLException ex) {
			throw new DataBaseException(Resourcer.getString("message.read.work.exception"), ex);
		} finally {
			try {
				preparedStatement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	@Override
	public Work readWork(UUID workGuid) throws DataBaseException {
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = this.connection.prepareStatement(Resourcer.getString("query.read.work.guid"));
			preparedStatement.setString(1, workGuid.toString());
			ResultSet resultSet = null;
			try {
				resultSet = preparedStatement.executeQuery();
				if (!resultSet.next()) {
					return null;
				}
				Work work = DataExtracter.extractWorkFromResultSet(resultSet);
				Set<Order> workOrders = readWorkOrders(work);
				work.setOrders(workOrders);
				return work;
			} finally {
				resultSet.close();
			}
		} catch (SQLException ex) {
			throw new DataBaseException(Resourcer.getString("message.read.work.exception"), ex);
		} finally {
			try {
				preparedStatement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	@Override
	public Order readOrder(UUID orderGuid) throws DataBaseException {
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = this.connection.prepareStatement(Resourcer.getString("query.read.order"));
			preparedStatement.setString(1, orderGuid.toString());
			ResultSet resultSet = null;
			try {
				resultSet = preparedStatement.executeQuery();
				if (!resultSet.next()) {
					return null;
				}
				Order order = DataExtracter.extractOrderFromResultSet(resultSet);
				order.setCar(findCar(resultSet.getInt("CarId")));
				order.setWorkers(findOrderWorkers(order.getOrderId()));
				order.setShareParts(findOrderShareParts(order.getOrderId()));
				order.setWorks(findOrderWorks(order.getOrderId()));
				return order;
			} finally {
				resultSet.close();
			}
		} catch (SQLException ex) {
			throw new DataBaseException(Resourcer.getString("message.read.order.exception"), ex);
		} finally {
			try {
				preparedStatement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	private Car findCar(int carId) throws SQLException {
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = this.connection.prepareStatement(Resourcer.getString("query.find.car"));
			preparedStatement.setInt(1, carId);
			ResultSet resultSet = null;
			try {
				resultSet = preparedStatement.executeQuery();
				if (!resultSet.next()) {
					return null;
				}
				return DataExtracter.extractCarFromResultSet(resultSet);
			} finally {
				resultSet.close();
			}
		} finally {
			preparedStatement.close();
		}
	}
	
	private Set<Work> findOrderWorks(int orderId) throws SQLException {
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = this.connection.prepareStatement(Resourcer.getString("query.find.order.works"));
			preparedStatement.setInt(1, orderId);
			ResultSet resultSet = null;
			try {
				resultSet = preparedStatement.executeQuery();
				Set<Work> works = new HashSet<Work>();
				while (resultSet.next()) {
					Work work = findWork(resultSet.getInt("WorkId"));
					if (work != null) {
						works.add(work);
					}
				}
				return works;
			} finally {
				resultSet.close();
			}
		} finally {
			preparedStatement.close();
		}
	}
	
	private Work findWork(int workId) throws SQLException {
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = this.connection.prepareStatement(Resourcer.getString("query.find.work"));
			preparedStatement.setInt(1, workId);
			ResultSet resultSet = null;
			try {
				resultSet = preparedStatement.executeQuery();
				if (!resultSet.next()) {
					return null;
				}
				return DataExtracter.extractWorkFromResultSet(resultSet);
			} finally {
				resultSet.close();
			}
		} finally {
			preparedStatement.close();
		}
	}
	
	private Set<SharePart> findOrderShareParts(int orderId) throws SQLException {
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = this.connection.prepareStatement(Resourcer.getString("query.find.order.shareparts"));
			preparedStatement.setInt(1, orderId);
			ResultSet resultSet = null;
			try {
				resultSet = preparedStatement.executeQuery();
				Set<SharePart> shareParts = new HashSet<SharePart>();
				while (resultSet.next()) {
					SharePart sharePart = findSharePart(resultSet.getInt("SharePartId"));
					if (sharePart != null) {
						shareParts.add(sharePart);
					}
				}
				return shareParts;
			} finally {
				resultSet.close();
			}
		} finally {
			preparedStatement.close();
		}
	}
	
	private SharePart findSharePart(int sharePartId) throws SQLException {
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = this.connection.prepareStatement(Resourcer.getString("query.find.sharepart"));
			preparedStatement.setInt(1, sharePartId);
			ResultSet resultSet = null;
			try {
				resultSet = preparedStatement.executeQuery();
				if (!resultSet.next()) {
					return null;
				}
				return DataExtracter.extractSharePartFromResultSet(resultSet);
			} finally {
				resultSet.close();
			}
		} finally {
			preparedStatement.close();
		}
	}
	
	private Set<Worker> findOrderWorkers(int orderId) throws SQLException {
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = this.connection.prepareStatement(Resourcer.getString("query.find.order.workers"));
			preparedStatement.setInt(1, orderId);
			ResultSet resultSet = null;
			try {
				resultSet = preparedStatement.executeQuery();
				Set<Worker> workers = new HashSet<Worker>();
				while (resultSet.next()) {
					Worker worker = findWorker(resultSet.getInt("WorkerId"));
					if (worker != null) {
						workers.add(worker);
					}
				}
				return workers;
			} finally {
				resultSet.close();
			}
		} finally {
			preparedStatement.close();
		}
	}
	
	private Worker findWorker(int workerId) throws SQLException {
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = this.connection.prepareStatement(Resourcer.getString("query.find.worker"));
			preparedStatement.setInt(1, workerId);
			ResultSet resultSet = null;
			try {
				resultSet = preparedStatement.executeQuery();
				if (!resultSet.next()) {
					return null;
				}
				return DataExtracter.extractWorkerFromResultSet(resultSet);
			} finally {
				resultSet.close();
			}
		} finally {
			preparedStatement.close();
		}
	}
	
	@Override
	public Set<Client> readAllClients() throws DataBaseException {
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = this.connection.prepareStatement(Resourcer.getString("query.read.all.clients"));
			ResultSet resultSet = null;
			try {
				resultSet = preparedStatement.executeQuery();
				Set<Client> clients = new HashSet<Client>();
				while (resultSet.next()) {
					Client client = DataExtracter.extractClientFromResultSet(resultSet);
					client.setCars(readClientCars(client));
					clients.add(client);
				}
				return clients;
			} finally {
				resultSet.close();
			}
		} catch (SQLException ex) {
			throw new DataBaseException(Resourcer.getString("message.read.clients.exception"), ex);
		} finally {
			try {
				preparedStatement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	@Override
	public Set<Worker> readAllWorkers() throws DataBaseException {
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = this.connection.prepareStatement(Resourcer.getString("query.read.all.workers"));
			ResultSet resultSet = null;
			try {
				resultSet = preparedStatement.executeQuery();
				Set<Worker> workers = new HashSet<Worker>();
				while (resultSet.next()) {
					Worker worker = DataExtracter.extractWorkerFromResultSet(resultSet);
					worker.setOrders(readWorkerOrders(worker));
					workers.add(worker);
				}
				return workers;
			} finally {
				resultSet.close();
			}
		} catch (SQLException ex) {
			throw new DataBaseException(Resourcer.getString("message.read.workers.exception"), ex);
		} finally {
			try {
				preparedStatement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	@Override
	public Set<Worker> readFreeWorkers() throws DataBaseException {
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = this.connection.prepareStatement(Resourcer.getString("query.read.free.workers"));
			ResultSet resultSet = null;
			try {
				resultSet = preparedStatement.executeQuery();
				Set<Worker> workers = new HashSet<Worker>();
				while (resultSet.next()) {
					Worker worker = DataExtracter.extractWorkerFromResultSet(resultSet);
					worker.setOrders(readWorkerOrders(worker));
					workers.add(worker);
				}
				return workers;
			} finally {
				resultSet.close();
			}
		} catch (SQLException ex) {
			throw new DataBaseException(Resourcer.getString("message.read.workers.exception"), ex);
		} finally {
			try {
				preparedStatement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	@Override
	public Set<Worker> readOrderWorkers(Order order) throws DataBaseException {
		if (order == null) {
			throw new NullPointerException(Resourcer.getString("message.order.null"));
		}
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = this.connection.prepareStatement(Resourcer.getString("query.read.order.workers"));
			preparedStatement.setString(1, order.getOrderGuid().toString());
			ResultSet resultSet = null;
			try {
				resultSet = preparedStatement.executeQuery();
				Set<Worker> workers = new HashSet<Worker>();
				while (resultSet.next()) {
					Worker worker = DataExtracter.extractWorkerFromResultSet(resultSet);
					worker.setOrders(readWorkerOrders(worker));
					workers.add(worker);
				}
				return workers;
			} finally {
				resultSet.close();
			}
		} catch (SQLException ex) {
			throw new DataBaseException(Resourcer.getString("message.read.workers.exception"), ex);
		} finally {
			try {
				preparedStatement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	@Override
	public Set<Work> readOrderWorks(Order order) throws DataBaseException {
		if (order == null) {
			throw new NullPointerException(Resourcer.getString("message.order.null"));
		}
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = this.connection.prepareStatement(Resourcer.getString("query.read.order.works"));
			preparedStatement.setString(1, order.getOrderGuid().toString());
			ResultSet resultSet = null;
			try {
				resultSet = preparedStatement.executeQuery();
				Set<Work> works = new HashSet<Work>();
				while (resultSet.next()) {
					Work work = DataExtracter.extractWorkFromResultSet(resultSet);
					work.setOrders(readWorkOrders(work));
					works.add(work);
				}
				return works;
			} finally {
				resultSet.close();
			}
		} catch (SQLException ex) {
			throw new DataBaseException(Resourcer.getString("message.read.works.exception"), ex);
		} finally {
			try {
				preparedStatement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	@Override
	public Set<SharePart> readOrderShareParts(Order order) throws DataBaseException {
		if (order == null) {
			throw new NullPointerException(Resourcer.getString("message.null.order"));
		}
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = this.connection.prepareStatement(Resourcer.getString("query.read.order.shareparts"));
			preparedStatement.setString(1, order.getOrderGuid().toString());
			ResultSet resultSet = null;
			try {
				resultSet = preparedStatement.executeQuery();
				Set<SharePart> shareParts = new HashSet<SharePart>();
				while (resultSet.next()) {
					SharePart sharePart = DataExtracter.extractSharePartFromResultSet(resultSet);
					sharePart.setOrders(readSharePartOrders(sharePart));
					shareParts.add(sharePart);
				}
				return shareParts;
			} finally {
				resultSet.close();
			}
		} catch (SQLException ex) {
			throw new DataBaseException(Resourcer.getString("message.read.shareparts.exception"), ex);
		} finally {
			try {
				preparedStatement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	@Override
	public Set<Car> readClientCars(Client client) throws DataBaseException {
		if (client == null) {
			throw new NullPointerException(Resourcer.getString("message.client.null"));
		}
		User user = readUser(client.getLogin());
		if (user == null) {
			throw new NullPointerException(Resourcer.getString("message.user.null"));
		}
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = this.connection.prepareStatement(Resourcer.getString("query.read.client.cars"));
			preparedStatement.setInt(1, user.getUserId());
			ResultSet resultSet = null;
			try {
				resultSet = preparedStatement.executeQuery();
				Set<Car> cars = new HashSet<Car>();
				while (resultSet.next()) {
					Car car = DataExtracter.extractCarFromResultSet(resultSet);
					car.setClient(client);
					//car.setOrders(readClientOrders(client));
					cars.add(car);
				}
				return cars;
			} finally {
				resultSet.close();
			}
		} catch (SQLException ex) {
			throw new DataBaseException(Resourcer.getString("message.read.cars.exception"), ex);
		} finally {
			try {
				preparedStatement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	@Override
	public Set<SharePart> readAllShareParts() throws DataBaseException {
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = this.connection.prepareStatement(Resourcer.getString("query.read.all.shareparts"));
			ResultSet resultSet = null;
			try {
				resultSet = preparedStatement.executeQuery();
				Set<SharePart> shareParts = new HashSet<SharePart>();
				while (resultSet.next()) {
					SharePart sharePart = DataExtracter.extractSharePartFromResultSet(resultSet);
					sharePart.setOrders(readSharePartOrders(sharePart));
					shareParts.add(sharePart);
				}
				return shareParts;
			} finally {
				resultSet.close();
			}
		} catch (SQLException ex) {
			throw new DataBaseException(Resourcer.getString("message.read.shareparts.exception"), ex);
		} finally {
			try {
				preparedStatement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	@Override
	public Set<Work> readAllWorks() throws DataBaseException {
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = this.connection.prepareStatement(Resourcer.getString("query.read.all.works"));
			ResultSet resultSet = null;
			try {
				resultSet = preparedStatement.executeQuery();
				Set<Work> works = new HashSet<Work>();
				while (resultSet.next()) {
					Work work = DataExtracter.extractWorkFromResultSet(resultSet);
					work.setOrders(readWorkOrders(work));
					works.add(work);
				}
				return works;
			} finally {
				resultSet.close();
			}
		} catch (SQLException ex) {
			throw new DataBaseException(Resourcer.getString("message.read.works.exception"), ex);
		} finally {
			try {
				preparedStatement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	@Override
	public boolean checkPassword(int passwordHash) throws DataBaseException {
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = this.connection.prepareStatement(Resourcer.getString("query.read.password"));
			preparedStatement.setInt(1, passwordHash);
			ResultSet resultSet = null;
			try {
				resultSet = preparedStatement.executeQuery();
				return resultSet.next();
			} finally {
				resultSet.close();
			}
		} catch (SQLException ex) {
			throw new DataBaseException(Resourcer.getString("message.read.password.exception"), ex);
		} finally {
			try {
				preparedStatement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	@Override
	public Set<Order> readClientOrders(Client client) throws DataBaseException {
		if (client == null) {
			throw new NullPointerException(Resourcer.getString("message.client.null"));
		}
		Set<Car> clientCars = client.getCars();
		for (Car car : clientCars) {
			PreparedStatement preparedStatement = null;
			try {
				preparedStatement = this.connection.prepareStatement(Resourcer.getString("query.read.client.orders"));
				preparedStatement.setString(1, car.getNumber());
				ResultSet resultSet = null;
				try {
					resultSet = preparedStatement.executeQuery();
					Set<Order> orders = new HashSet<Order>();
					while (resultSet.next()) {
						UUID orderGuid = UUID.fromString(resultSet.getString("OrderGuid"));
						Order order = readOrder(orderGuid);
						orders.add(order);
					}
					return orders;
				} finally {
					resultSet.close();
				}
			} catch (SQLException ex) {
				throw new DataBaseException(Resourcer.getString("message.read.orders.exception"), ex);
			} finally {
				try {
					preparedStatement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return new HashSet<Order>();
	}

	@Override
	public Set<Order> readWorkerOrders(Worker worker) throws DataBaseException {
		if (worker == null) {
			throw new NullPointerException(Resourcer.getString("message.worker.null"));
		}
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = this.connection.prepareStatement(Resourcer.getString("query.read.worker.orders"));
			preparedStatement.setString(1, worker.getLogin());
			ResultSet resultSet = null;
			try {
				resultSet = preparedStatement.executeQuery();
				Set<Order> orders = new HashSet<Order>();
				while (resultSet.next()) {
					UUID orderGuid = UUID.fromString(resultSet.getString("OrderGuid"));
					Order order = readOrder(orderGuid);
					orders.add(order);
				}
				return orders;
			} finally {
				resultSet.close();
			}
		} catch (SQLException ex) {
			throw new DataBaseException(Resourcer.getString("message.read.orders.exception"), ex);
		} finally {
			try {
				preparedStatement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	private Set<Order> readSharePartOrders(SharePart sharePart) throws SQLException, DataBaseException {
		if (sharePart == null) {
			throw new NullPointerException(Resourcer.getString("message.sharepart.null"));
		}
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = this.connection.prepareStatement(Resourcer.getString("query.read.sharepart.orders"));
			preparedStatement.setString(1, sharePart.getSharePartGuid().toString());
			ResultSet resultSet = null;
			try {
				resultSet = preparedStatement.executeQuery();
				Set<Order> orders = new HashSet<Order>();
				while (resultSet.next()) {
					UUID orderGuid = UUID.fromString(resultSet.getString("OrderGuid"));
					Order order = readOrder(orderGuid);
					orders.add(order);
				}
				return orders;
			} finally {
				resultSet.close();
			}
		} finally {
			preparedStatement.close();
		}
	}
	
	private Set<Order> readWorkOrders(Work work) throws SQLException, DataBaseException {
		if (work == null) {
			throw new NullPointerException(Resourcer.getString("message.work.null"));
		}
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = this.connection.prepareStatement(Resourcer.getString("query.read.work.orders"));
			preparedStatement.setString(1, work.getWorkGuid().toString());
			ResultSet resultSet = null;
			try {
				resultSet = preparedStatement.executeQuery();
				Set<Order> orders = new HashSet<Order>();
				while (resultSet.next()) {
					UUID orderGuid = UUID.fromString(resultSet.getString("OrderGuid"));
					Order order = readOrder(orderGuid);
					orders.add(order);
				}
				return orders;
			} finally {
				resultSet.close();
			}
		} finally {
			preparedStatement.close();
		}
	}
	
	@Override
	public Set<Order> readAllOrders() throws DataBaseException {
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = this.connection.prepareStatement(Resourcer.getString("query.read.all.orders"));
			ResultSet resultSet = null;
			try {
				resultSet = preparedStatement.executeQuery();
				Set<Order> orders = new  HashSet<Order>();
				while (resultSet.next()) {
					Order order = DataExtracter.extractOrderFromResultSet(resultSet);
					order.setCar(findCar(resultSet.getInt("CarId")));
					order.setWorkers(findOrderWorkers(order.getOrderId()));
					order.setShareParts(findOrderShareParts(order.getOrderId()));
					order.setWorks(findOrderWorks(order.getOrderId()));
					orders.add(order);
				}
				return orders;
			} finally {
				resultSet.close();
			}
		} catch (SQLException ex) {
			throw new DataBaseException(Resourcer.getString("message.read.orders.exception"), ex);
		} finally {
			try {
				preparedStatement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	@Override
	public Set<User> readAllAdmins() throws DataBaseException {
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = this.connection.prepareStatement(Resourcer.getString("query.read.all.admins"));
			ResultSet resultSet = null;
			try {
				resultSet = preparedStatement.executeQuery();
				Set<User> admins = new HashSet<User>();
				while (resultSet.next()) {
					User admin = DataExtracter.extractUserFromResultSet(resultSet);
					admins.add(admin);
				}
				return admins;
			} finally {
				resultSet.close();
			}
		} catch (SQLException ex) {
			throw new DataBaseException(Resourcer.getString("message.read.admin.exception"), ex);
		} finally {
			try {
				preparedStatement.close();
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		}
	}

	@Override
	public void updateUser(User user) throws DataBaseException {
		if (user == null) {
			throw new NullPointerException(Resourcer.getString("message.user.null"));
		}
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = this.connection.prepareStatement(Resourcer.getString("query.update.user"));
			preparedStatement.setString(1, user.getLogin());
			preparedStatement.setBoolean(2, user.getIsOnline());
			preparedStatement.setString(3, user.getUserGuid().toString());
			preparedStatement.executeUpdate();
		} catch (SQLException ex) {
			throw new DataBaseException(Resourcer.getString("message.update.user.exception"), ex);
		} finally {
			try {
				preparedStatement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void updateClient(Client client) throws DataBaseException {
		if (client == null) {
			throw new NullPointerException(Resourcer.getString("message.client.null"));
		}
		updateUser(new User(client.getUserId(), client.getUserGuid(), client.getLogin(), client.getIsOnline()));
		User user = readUser(client.getLogin());
		if (user == null) {
			throw new NullPointerException(Resourcer.getString("message.user.null"));
		}
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = this.connection.prepareStatement(Resourcer.getString("query.update.client"));
			preparedStatement.setString(1, client.getSurname());
			preparedStatement.setString(2, client.getName());
			preparedStatement.setString(3, client.getPatronymic());
			preparedStatement.setInt(4, user.getUserId());
			preparedStatement.executeUpdate();
		} catch (SQLException ex) {
			throw new DataBaseException(Resourcer.getString("message.update.client.exception"), ex);
		} finally {
			try {
				preparedStatement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void updateWorker(Worker worker) throws DataBaseException {
		if (worker == null) {
			throw new NullPointerException(Resourcer.getString("message.worker.null"));
		}
		updateUser(new User(worker.getUserId(), worker.getUserGuid(), worker.getLogin(), worker.getIsOnline()));
		User user = readUser(worker.getLogin());
		if (user == null) {
			throw new NullPointerException(Resourcer.getString("message.user.null"));
		}
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = this.connection.prepareStatement(Resourcer.getString("query.update.worker"));
			preparedStatement.setString(1, worker.getSurname());
			preparedStatement.setString(2, worker.getName());
			preparedStatement.setString(3, worker.getPatronymic());
			preparedStatement.setInt(4, worker.getExperience());
			preparedStatement.setInt(5, user.getUserId());
			preparedStatement.executeUpdate();
		} catch (SQLException ex) {
			throw new DataBaseException(Resourcer.getString("message.update.worker.exception"), ex);
		} finally {
			try {
				preparedStatement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void updateSharePart(SharePart sharePart) throws DataBaseException {
		if (sharePart == null) {
			throw new NullPointerException(Resourcer.getString("message.sahrepart.null"));
		}
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = this.connection.prepareStatement(Resourcer.getString("query.update.sharepart"));
			preparedStatement.setString(1, sharePart.getName());
			preparedStatement.setDouble(2, sharePart.getPrice());
			preparedStatement.setInt(3, sharePart.getCount());
			preparedStatement.setString(4, sharePart.getDescription());
			preparedStatement.setString(5, sharePart.getSharePartGuid().toString());
			preparedStatement.executeUpdate();
		} catch (SQLException ex) {
			throw new DataBaseException(Resourcer.getString("message.update.sharepart.exception"), ex);
		} finally {
			try {
				preparedStatement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void updateWork(Work work) throws DataBaseException {
		if (work == null) {
			throw new NullPointerException(Resourcer.getString("message.work.null"));
		}
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = this.connection.prepareStatement(Resourcer.getString("query.update.work"));
			preparedStatement.setString(1, work.getName());
			preparedStatement.setDouble(2, work.getPrice());
			preparedStatement.setString(3, work.getDescription());
			preparedStatement.setString(4, work.getWorkGuid().toString());
			preparedStatement.executeUpdate();
		} catch (SQLException ex) {
			throw new DataBaseException(Resourcer.getString("message.update.work.exception"), ex);
		} finally {
			try {
				preparedStatement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void updateOrder(Order order) throws DataBaseException {
		if (order == null) {
			throw new NullPointerException(Resourcer.getString("message.order.null"));
		}
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = this.connection.prepareStatement(Resourcer.getString("query.update.order"));
			preparedStatement.setString(1, order.getStatus().toString());
			preparedStatement.setString(2, order.getOrderGuid().toString());
			preparedStatement.executeUpdate();
		} catch (SQLException ex) {
			throw new DataBaseException(Resourcer.getString("message.update.order.exception"), ex);
		} finally {
			try {
				preparedStatement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	@Override
	public void deleteUser(UUID userGuid) throws DataBaseException {
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = this.connection.prepareStatement(Resourcer.getString("query.delete.user"));
			preparedStatement.setString(1, userGuid.toString());
			preparedStatement.executeUpdate();
		} catch (SQLException ex) {
			throw new DataBaseException(Resourcer.getString("message.delete.user.exception"), ex);
		} finally {
			try {
				preparedStatement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	@Override
	public void deleteUser(User user) throws DataBaseException {
		if (user == null) {
			throw new NullPointerException(Resourcer.getString("message.user.null"));
		}
		deleteUser(user.getUserGuid());
	}
	
	@Override
	public void deleteCar(UUID carGuid) throws DataBaseException {
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = this.connection.prepareStatement(Resourcer.getString("query.delete.car"));
			preparedStatement.setString(1, carGuid.toString());
			preparedStatement.executeUpdate();
		} catch (SQLException ex) {
			throw new DataBaseException(Resourcer.getString("message.delete.car.exception"), ex);
		} finally {
			try {
				preparedStatement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	@Override
	public void deleteCar(Car car) throws DataBaseException {
		if (car == null) {
			throw new NullPointerException(Resourcer.getString("message.car.null"));
		}
		deleteCar(car.getCarGuid());
	}
	
	@Override
	public void deleteSharePart(UUID sharePartGuid) throws DataBaseException {
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = this.connection.prepareStatement(Resourcer.getString("query.delete.sharepart"));
			preparedStatement.setString(1, sharePartGuid.toString());
			preparedStatement.executeUpdate();
		} catch (SQLException ex) {
			throw new DataBaseException(Resourcer.getString("message.delete.sharepart.exception"), ex);
		} finally {
			try {
				preparedStatement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	@Override
	public void deleteSharePart(SharePart sharePart) throws DataBaseException {
		if (sharePart == null) {
			throw new NullPointerException(Resourcer.getString("message.sharepart.null"));
		}
		deleteSharePart(sharePart.getSharePartGuid());
	}
	
	@Override
	public void deleteAllOrderShareParts(SharePart sharePart)
			throws DataBaseException {
		if (sharePart == null) {
			throw new NullPointerException(Resourcer.getString("message.sharepart.null"));
		}
		SharePart readedSharePart = readSharePart(sharePart.getName());
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = this.connection.prepareStatement(Resourcer.getString("query.delete.all.shareparts"));
			preparedStatement.setInt(1, readedSharePart.getSharePartId());
			preparedStatement.executeUpdate();
		} catch (SQLException ex) {
			throw new DataBaseException(Resourcer.getString("message.delete.shareparts.exception"), ex);
		} finally {
			try {
				preparedStatement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	@Override
	public void deleteWork(UUID workGuid) throws DataBaseException {
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = this.connection.prepareStatement(Resourcer.getString("query.delete.work"));
			preparedStatement.setString(1, workGuid.toString());
			preparedStatement.executeUpdate();
		} catch (SQLException ex) {
			throw new DataBaseException(Resourcer.getString("message.delete.work.exception"), ex);
		} finally {
			try {
				preparedStatement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	@Override
	public void deleteWork(Work work) throws DataBaseException {
		if (work == null) {
			throw new NullPointerException(Resourcer.getString("message.work.null"));
		}
		deleteWork(work.getWorkGuid());
	}
	
	@Override
	public void deleteAllOrderWorks(Work work) throws DataBaseException {
		if (work == null) {
			throw new NullPointerException(Resourcer.getString("message.work.null"));
		}
		Work readedWork = readWork(work.getName());
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = this.connection.prepareStatement(Resourcer.getString("query.delete.all.order.works"));
			preparedStatement.setInt(1, readedWork.getWorkId());
			preparedStatement.executeUpdate();
		} catch (SQLException ex) {
			throw new DataBaseException(Resourcer.getString("message.delete.works.exception"), ex);
		} finally {
			try {
				preparedStatement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	@Override
	public void deleteOrder(UUID orderGuid) throws DataBaseException {
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = this.connection.prepareStatement(Resourcer.getString("query.delete.order"));
			preparedStatement.setString(1, orderGuid.toString());
			preparedStatement.executeUpdate();
		} catch (SQLException ex) {
			throw new DataBaseException(Resourcer.getString("message.delete.order.exception"), ex);
		} finally {
			try {
				preparedStatement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	@Override
	public void deleteOrder(Order order) throws DataBaseException {
		if (order == null) {
			throw new NullPointerException(Resourcer.getString("message.order.null"));
		}
		deleteOrder(order.getOrderGuid());
	}
	
	@Override
	public void deleteOrderWorker(Order order, Worker worker) throws DataBaseException {
		if (order == null) {
			throw new NullPointerException(Resourcer.getString("message.order.null"));
		}
		Order readOrder = readOrder(order.getOrderGuid());
		if (readOrder == null) {
			throw new NullPointerException(Resourcer.getString("message.order.null"));
		}
		if (worker == null) {
			throw new NullPointerException(Resourcer.getString("message.worker.null"));
		}
		Worker readWorker = readWorker(worker.getLogin());
		if (readWorker == null) {
			throw new NullPointerException(Resourcer.getString("message.worker.null"));
		}
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = this.connection.prepareStatement(Resourcer.getString("query.delete.order.workers"));
			preparedStatement.setInt(1, readOrder.getOrderId());
			preparedStatement.setInt(2, readWorker.getUserId());
			preparedStatement.executeUpdate();
		} catch (SQLException ex) {
			throw new DataBaseException(Resourcer.getString("message.delete.worker.exception"), ex);
		} finally {
			try {
				preparedStatement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void deleteOrderWork(Order order, Work work) throws DataBaseException {
		if (order == null) {
			throw new NullPointerException(Resourcer.getString("message.order.null"));
		}
		Order readOrder = readOrder(order.getOrderGuid());
		if (readOrder == null) {
			throw new NullPointerException(Resourcer.getString("message.order.null"));
		}
		if (work == null) {
			throw new NullPointerException(Resourcer.getString("message.work.null"));
		}
		Work readWork = readWork(work.getName());
		if (readWork == null) {
			throw new NullPointerException(Resourcer.getString("message.work.null"));
		}
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = this.connection.prepareStatement(Resourcer.getString("query.delete.order.work"));
			preparedStatement.setInt(1, readOrder.getOrderId());
			preparedStatement.setInt(2, readWork.getWorkId());
			preparedStatement.executeUpdate();
		} catch (SQLException ex) {
			throw new DataBaseException(Resourcer.getString("message.delete.work.exception"), ex);
		} finally {
			try {
				preparedStatement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void deleteOrderSharePart(Order order, SharePart sharePart) throws DataBaseException {
		if (order == null) {
			throw new NullPointerException(Resourcer.getString("message.order.null"));
		}
		Order readOrder = readOrder(order.getOrderGuid());
		if (readOrder == null) {
			throw new NullPointerException(Resourcer.getString("message.order.null"));
		}
		if (sharePart == null) {
			throw new NullPointerException(Resourcer.getString("message.sharepart.null"));
		}
		SharePart readSharePart = readSharePart(sharePart.getName());
		if (readSharePart == null) {
			throw new NullPointerException(Resourcer.getString("message.sharepart.null"));
		}
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = this.connection.prepareStatement(Resourcer.getString("query.delete.order.sharepart"));
			preparedStatement.setInt(1, readOrder.getOrderId());
			preparedStatement.setInt(2, readSharePart.getSharePartId());
			preparedStatement.executeUpdate();
		} catch (SQLException ex) {
			throw new DataBaseException(Resourcer.getString("message.delete.sharepart.exception"), ex);
		} finally {
			try {
				preparedStatement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	@Override
	public void dispose() throws SQLException {
		if (this.connection != null) {
			this.connection.close();
		}
	}
}
