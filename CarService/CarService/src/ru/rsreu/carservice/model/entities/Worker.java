package ru.rsreu.carservice.model.entities;

import java.util.Set;
import java.util.UUID;

public class Worker extends User {
	
	private String surname;
	private String name;
	private String patronymic;
	private int experience;
	private Set<Order> orders;
	
	public Worker() {
	}
	
	public Worker(int workerId, UUID workerGuid, String workerLogin, String surname, String name,
			String patronymic, int expirience, Set<Order> orders) {
		setUserId(workerId);
		setUserGuid(workerGuid);
		setLogin(workerLogin);
		setSurname(surname);
		setName(name);
		setPatronymic(patronymic);
		setExperience(expirience);
		setOrders(orders);
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
	
	public int getExperience() {
		return this.experience;
	}
	
	public void setExperience(int experience) {
		this.experience = experience;
	}
	
	public Set<Order> getOrders() {
		return this.orders;
	}
	
	public void setOrders(Set<Order> orders) {
		this.orders = orders;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + experience;
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
		Worker other = (Worker) obj;
		if (experience != other.experience)
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
	
	@Override
	public String toString() {
		StringBuilder output = new StringBuilder();
		output.append(getSurname()).append(" ");
		output.append(getName()).append(" ");
		output.append(getPatronymic());
		return output.toString();
	}
}
