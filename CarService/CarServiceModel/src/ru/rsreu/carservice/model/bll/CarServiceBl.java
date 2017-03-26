package ru.rsreu.carservice.model.bll;

import java.sql.SQLException;

import ru.rsreu.carservice.model.dal.CarServiceDao;
import ru.rsreu.carservice.model.dal.ICarServiceDao;
import ru.rsreu.carservice.model.entities.Password;
import ru.rsreu.carservice.model.entities.User;

public class CarServiceBl {
	
	private ICarServiceDao carServiceDao;
	
	public CarServiceBl() throws SQLException {
		this.carServiceDao = new CarServiceDao();
	}
	
	public boolean Autorized(String login, String password) throws SQLException {
		User user = this.carServiceDao.readUser(login);
		if (user == null) {
			return false;
		}
		int passwordHash = password.hashCode() ^ user.getLogin().hashCode();
		Password passwordEntity = this.carServiceDao.readPassword(passwordHash);
		return passwordEntity != null;
	}
}
