package ru.rsreu.carservice.model.entities;

import java.util.Set;
import java.util.UUID;

public class Car {
	
	private int carId;
	private UUID carGuid;
	private String number;
	private String mark;
	private String model;
	private Client client;
	private Set<Order> orders;
	
	public Car() {
	}
	
	public Car(int carId, UUID carGuid, String number, String mark, String model, Client client, Set<Order> orders) {
		setCarId(carId);
		setCarGuid(carGuid);
		setNumber(number);
		setMark(mark);
		setModel(model);
		setClient(client);
		setOrders(orders);
	}
	
	public int getCarId() {
		return this.carId;
	}
	
	public void setCarId(int carId) {
		this.carId = carId;
	}
	
	public UUID getCarGuid() {
		return this.carGuid;
	}
	
	public void setCarGuid(UUID carGuid) {
		this.carGuid = carGuid;
	}
	
	public String getNumber() {
		return this.number;
	}
	
	public void setNumber(String number) {
		this.number = number;
	}
	
	public String getMark() {
		return this.mark;
	}
	
	public void setMark(String mark) {
		this.mark = mark;
	}
	
	public String getModel() {
		return this.model;
	}
	
	public void setModel(String model) {
		this.model = model;
	}
	
	public Client getClient() {
		return this.client;
	}
	
	public void setClient(Client client) {
		this.client = client;
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
		int result = 1;
		result = prime * result + ((carGuid == null) ? 0 : carGuid.hashCode());
		result = prime * result + ((mark == null) ? 0 : mark.hashCode());
		result = prime * result + ((model == null) ? 0 : model.hashCode());
		result = prime * result + ((number == null) ? 0 : number.hashCode());
		result = prime * result + ((orders == null) ? 0 : orders.hashCode());
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Car other = (Car) obj;
		if (carGuid == null) {
			if (other.carGuid != null)
				return false;
		} else if (!carGuid.equals(other.carGuid))
			return false;
		if (mark == null) {
			if (other.mark != null)
				return false;
		} else if (!mark.equals(other.mark))
			return false;
		if (model == null) {
			if (other.model != null)
				return false;
		} else if (!model.equals(other.model))
			return false;
		if (number == null) {
			if (other.number != null)
				return false;
		} else if (!number.equals(other.number))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return getMark() + " " + getModel();
	}
}
