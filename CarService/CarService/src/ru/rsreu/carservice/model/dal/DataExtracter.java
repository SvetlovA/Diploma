package ru.rsreu.carservice.model.dal;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

import ru.rsreu.carservice.model.entities.Car;
import ru.rsreu.carservice.model.entities.Client;
import ru.rsreu.carservice.model.entities.Order;
import ru.rsreu.carservice.model.entities.SharePart;
import ru.rsreu.carservice.model.entities.User;
import ru.rsreu.carservice.model.entities.Work;
import ru.rsreu.carservice.model.entities.WorkStatus;
import ru.rsreu.carservice.model.entities.Worker;

public class DataExtracter {
	
	private DataExtracter() {
	}
	
	public static User extractUserFromResultSet(ResultSet resultSet) throws SQLException {
		User user = new User();
		user.setUserId(resultSet.getInt("UserId"));
		user.setUserGuid(UUID.fromString(resultSet.getString("UserGuid")));
		user.setLogin(resultSet.getString("Login"));
		user.setIsOnline(resultSet.getBoolean("IsOnline"));
		return user;
	}
	
	public static Client extractClientFromResultSet(ResultSet resultSet) throws SQLException {
		Client client = new Client();
		client.setUserId(resultSet.getInt("ClientId"));
		client.setUserGuid(UUID.fromString(resultSet.getString("UserGuid")));
		client.setLogin(resultSet.getString("Login"));
		client.setSurname(resultSet.getString("Surname"));
		client.setName(resultSet.getString("Name"));
		client.setPatronymic(resultSet.getString("Patronymic"));
		client.setIsOnline(resultSet.getBoolean("IsOnline"));
		return client;
	}
	
	public static Car extractCarFromResultSet(ResultSet resultSet) throws SQLException {
		Car car = new Car();
		car.setCarId(resultSet.getInt("CarId"));
		car.setCarGuid(UUID.fromString(resultSet.getString("CarGuid")));
		car.setNumber(resultSet.getString("StateNumber"));
		car.setMark(resultSet.getString("Mark"));
		car.setModel(resultSet.getString("Model"));
		return car;
	}
	
	public static Worker extractWorkerFromResultSet(ResultSet resultSet) throws SQLException {
		Worker worker = new Worker();
		worker.setUserId(resultSet.getInt("WorkerId"));
		worker.setUserGuid(UUID.fromString(resultSet.getString("UserGuid")));
		worker.setLogin(resultSet.getString("Login"));
		worker.setSurname(resultSet.getString("Surname"));
		worker.setName(resultSet.getString("Name"));
		worker.setPatronymic(resultSet.getString("Patronymic"));
		worker.setExperience(resultSet.getInt("Experience"));
		worker.setIsOnline(resultSet.getBoolean("IsOnline"));
		return worker;
	}
	
	public static SharePart extractSharePartFromResultSet(ResultSet resultSet) throws SQLException {
		SharePart sharePart = new SharePart();
		sharePart.setSharePartId(resultSet.getInt("SharePartId"));
		sharePart.setSharePartGuid(UUID.fromString(resultSet.getString("SharePartGuid")));
		sharePart.setName(resultSet.getString("Name"));
		sharePart.setPrice(resultSet.getDouble("Price"));
		sharePart.setCount(resultSet.getInt("Count"));
		sharePart.setDescription(resultSet.getString("Description"));
		return sharePart;
	}
	
	public static Work extractWorkFromResultSet(ResultSet resultSet) throws SQLException {
		Work work = new Work();
		work.setWorkId(resultSet.getInt("WorkId"));
		work.setWorkGuid(UUID.fromString(resultSet.getString("WorkGuid")));
		work.setName(resultSet.getString("Name"));
		work.setPrice(resultSet.getDouble("Price"));
		work.setDescription(resultSet.getString("Description"));
		return work;
	}
	
	public static Order extractOrderFromResultSet(ResultSet resultSet) throws SQLException {
		Order order = new Order();
		order.setOrderId(resultSet.getInt("OrderId"));
		order.setOrderGuid(UUID.fromString(resultSet.getString("OrderGuid")));
		order.setOrderDate(resultSet.getTimestamp("OrderDate"));
		order.setTotalCost(resultSet.getDouble("TotalCost"));
		order.setStatus(WorkStatus.valueOf(resultSet.getString("Status")));
		return order;
	}
}