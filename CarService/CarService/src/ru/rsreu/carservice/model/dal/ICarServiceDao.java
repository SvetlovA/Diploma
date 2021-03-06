package ru.rsreu.carservice.model.dal;

import java.sql.SQLException;
import java.util.Set;
import java.util.UUID;

import ru.rsreu.carservice.model.dal.exceptions.DataBaseException;
import ru.rsreu.carservice.model.entities.Car;
import ru.rsreu.carservice.model.entities.Client;
import ru.rsreu.carservice.model.entities.Order;
import ru.rsreu.carservice.model.entities.SharePart;
import ru.rsreu.carservice.model.entities.User;
import ru.rsreu.carservice.model.entities.Work;
import ru.rsreu.carservice.model.entities.Worker;

public interface ICarServiceDao extends Disposable {
	void addAccount(User user, int passwordHash) throws DataBaseException, SQLException;
	void addCar(Car car) throws DataBaseException;
	void addSharePart(SharePart sharePart) throws DataBaseException;
	void addWork(Work work) throws DataBaseException;
	void addOrder(Order order) throws DataBaseException;
	void addOrderWorker(Order order, Worker worker) throws DataBaseException;
	void addOrderWork(Order order, Work work) throws DataBaseException;
	void addOrderSharePart(Order order, SharePart sharePart) throws DataBaseException;
	
	User readUser(String login) throws DataBaseException;
	boolean checkPassword(int passwordHash) throws DataBaseException;
	Client readClient(String login) throws DataBaseException;
	Client readClient(UUID clientGuid) throws DataBaseException;
	Car readCar(String number) throws DataBaseException;
	Car readCar(UUID carGuid) throws DataBaseException;
	Worker readWorker(String login) throws DataBaseException;
	Worker readWorker(UUID workerGuid) throws DataBaseException;
	SharePart readSharePart(String name) throws DataBaseException;
	SharePart readSharePart(UUID shareGuid) throws DataBaseException;
	Work readWork(String name) throws DataBaseException;
	Work readWork(UUID workGuid) throws DataBaseException;
	Order readOrder(UUID orderGuid) throws DataBaseException;
	Set<Client> readAllClients() throws DataBaseException;
	Set<Worker> readAllWorkers() throws DataBaseException;
	Set<Worker> readFreeWorkers() throws DataBaseException;
	Set<Worker> readOrderWorkers(Order order) throws DataBaseException;
	Set<Work> readOrderWorks(Order order) throws DataBaseException;
	Set<SharePart> readOrderShareParts(Order order) throws DataBaseException;
	Set<SharePart> readAllShareParts() throws DataBaseException;
	Set<Work> readAllWorks() throws DataBaseException;
	Set<Car> readClientCars(Client client) throws DataBaseException;
	Set<Order> readClientOrders(Client client) throws DataBaseException;
	Set<Order> readWorkerOrders(Worker worker) throws DataBaseException;
	Set<Order> readAllOrders() throws DataBaseException;
	Set<User> readAllAdmins() throws DataBaseException;
	
	void updateUser(User user) throws DataBaseException;
	void updateClient(Client client) throws DataBaseException;
	void updateWorker(Worker worker) throws DataBaseException;
	void updateSharePart(SharePart sharePart) throws DataBaseException;
	void updateWork(Work work) throws DataBaseException;
	void updateOrder(Order order) throws DataBaseException;
	
	void deleteUser(User user) throws DataBaseException;
	void deleteUser(UUID userGuid) throws DataBaseException;
	void deleteCar(Car car) throws DataBaseException;
	void deleteCar(UUID carGuid) throws DataBaseException;
	void deleteSharePart(SharePart sharePart) throws DataBaseException;
	void deleteSharePart(UUID sharePartGuid) throws DataBaseException;
	void deleteAllOrderShareParts(SharePart sharePart) throws DataBaseException;
	void deleteWork(Work work) throws DataBaseException;
	void deleteWork(UUID workGuid) throws DataBaseException;
	void deleteAllOrderWorks(Work work) throws DataBaseException;
	void deleteOrder(Order order) throws DataBaseException;
	void deleteOrder(UUID orderGuid) throws DataBaseException;
	void deleteOrderWorker(Order order, Worker worker) throws DataBaseException;
	void deleteOrderWork(Order order, Work work) throws DataBaseException;
	void deleteOrderSharePart(Order order, SharePart sharePart) throws DataBaseException;
}
