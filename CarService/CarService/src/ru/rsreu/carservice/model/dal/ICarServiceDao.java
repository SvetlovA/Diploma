package ru.rsreu.carservice.model.dal;

import java.sql.SQLException;
import java.util.Set;
import java.util.UUID;

import ru.rsreu.carservice.model.entities.Car;
import ru.rsreu.carservice.model.entities.Client;
import ru.rsreu.carservice.model.entities.Order;
import ru.rsreu.carservice.model.entities.Password;
import ru.rsreu.carservice.model.entities.SharePart;
import ru.rsreu.carservice.model.entities.User;
import ru.rsreu.carservice.model.entities.Work;
import ru.rsreu.carservice.model.entities.Worker;

public interface ICarServiceDao extends Disposable {
	void addUser(User user) throws SQLException;
	void addPassword(Password password) throws SQLException;
	void addClient(Client client) throws SQLException;
	void addCar(Car car) throws SQLException;
	void addWorker(Worker worker) throws SQLException;
	void addSharePart(SharePart sharePart) throws SQLException;
	void addWork(Work work) throws SQLException;
	void addOrder(Order order) throws SQLException;
	void addOrderWorker(Order order, Worker worker) throws SQLException;
	void addOrderWork(Order order, Work work) throws SQLException;
	void addOrderSharePart(Order order, SharePart sharePart) throws SQLException;
	
	User readUser(String login) throws SQLException;
	Password readPassword(int passwordHash) throws SQLException;
	Client readClient(String login) throws SQLException;
	Client readClient(UUID clientGuid) throws SQLException;
	Car readCar(String number) throws SQLException;
	Car readCar(UUID carGuid) throws SQLException;
	Worker readWorker(String login) throws SQLException;
	Worker readWorker(UUID workerGuid) throws SQLException;
	SharePart readSharePart(String name) throws SQLException;
	SharePart readSharePart(UUID shareGuid) throws SQLException;
	Work readWork(String name) throws SQLException;
	Work readWork(UUID workGuid) throws SQLException;
	Order readOrder(UUID orderGuid) throws SQLException;
	Set<Client> readAllClients() throws SQLException;
	Set<Worker> readAllWorkers() throws SQLException;
	Set<Worker> readFreeWorkers() throws SQLException;
	Set<Worker> readOrderWorkers(Order order) throws SQLException;
	Set<Work> readOrderWorks(Order order) throws SQLException;
	Set<SharePart> readOrderShareParts(Order order) throws SQLException;
	Set<SharePart> readAllShareParts() throws SQLException;
	Set<Work> readAllWorks() throws SQLException;
	Set<Car> readClientCars(Client client) throws SQLException;
	Set<Order> readClientOrders(Client client) throws SQLException;
	Set<Order> readWorkerOrders(Worker worker) throws SQLException;
	Set<Order> readAllOrders() throws SQLException;
	
	void updateUser(User user) throws SQLException;
	void updateClient(Client client) throws SQLException;
	void updateWorker(Worker worker) throws SQLException;
	void updateSharePart(SharePart sharePart) throws SQLException;
	void updateWork(Work work) throws SQLException;
	void updateOrder(Order order) throws SQLException;
	
	void deleteUser(User user) throws SQLException;
	void deleteUser(UUID userGuid) throws SQLException;
	void deletePassword(Password password) throws SQLException;
	void deleteCar(Car car) throws SQLException;
	void deleteCar(UUID carGuid) throws SQLException;
	void deleteSharePart(SharePart sharePart) throws SQLException;
	void deleteSharePart(UUID sharePartGuid) throws SQLException;
	void deleteWork(Work work) throws SQLException;
	void deleteWork(UUID workGuid) throws SQLException;
	void deleteOrder(Order order) throws SQLException;
	void deleteOrder(UUID orderGuid) throws SQLException;
	void deleteOrderWorker(Order order, Worker worker) throws SQLException;
	void deleteOrderWork(Order order, Work work) throws SQLException;
	void deleteOrderSharePart(Order order, SharePart sharePart) throws SQLException;
}
