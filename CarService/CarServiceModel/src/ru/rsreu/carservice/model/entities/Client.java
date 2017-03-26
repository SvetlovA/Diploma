package ru.rsreu.carservice.model.entities;

import java.util.Set;
import java.util.UUID;

public class Client extends User {
	
	private String surname;
	private String name;
	private String patronymic;
	private Set<Car> cars;
	
	public Client() {
	}
	
	public Client(int clientId, UUID clientGuid, String clientLogin, String surname, String name, String patronymic, Set<Car> cars) {
		setUserId(clientId);
		setUserGuid(clientGuid);
		setLogin(clientLogin);
		setSurname(surname);
		setName(name);
		setPatronymic(patronymic);
		setCars(cars);
	}
	
	public String getSurname() {
		return this.surname;
	}
	
	public void setSurname(String surname) {
		this.surname = surname;
	}
	
	public String getName() {
		return this.name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getPatronymic() {
		return this.patronymic;
	}
	
	public void setPatronymic(String patronymic) {
		this.patronymic = patronymic;
	}
	
	public Set<Car> getCars() {
		return this.cars;
	}
	
	public void setCars(Set<Car> cars) {
		this.cars = cars;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((cars == null) ? 0 : cars.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result
				+ ((patronymic == null) ? 0 : patronymic.hashCode());
		result = prime * result + ((surname == null) ? 0 : surname.hashCode());
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Client other = (Client) obj;
		if (cars == null) {
			if (other.cars != null)
				return false;
		} else if (!cars.equals(other.cars))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (patronymic == null) {
			if (other.patronymic != null)
				return false;
		} else if (!patronymic.equals(other.patronymic))
			return false;
		if (surname == null) {
			if (other.surname != null)
				return false;
		} else if (!surname.equals(other.surname))
			return false;
		return true;
	}
	
}
