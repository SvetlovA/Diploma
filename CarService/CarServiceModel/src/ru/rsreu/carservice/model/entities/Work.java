package ru.rsreu.carservice.model.entities;

import java.util.Set;
import java.util.UUID;

public class Work {
	
	private int workId;
	private UUID workGuid;
	private String name;
	private double price;
	private String description;
	private Set<Order> orders;
	
	public Work() {
	}
	
	public Work(int workId, UUID workGuid, String name, double price, String description, Set<Order> orders) {
		setWorkId(workId);
		setWorkGuid(workGuid);
		setName(name);
		setPrice(price);
		setDescription(description);
		setOrders(orders);
	}
	
	public int getWorkId() {
		return this.workId;
	}

	public void setWorkId(int workId) {
		this.workId = workId;
	}
	
	public UUID getWorkGuid() {
		return this.workGuid;
	}
	
	public void setWorkGuid(UUID workGuid) {
		this.workGuid = workGuid;
	}
	
	public String getName() {
		return this.name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public double getPrice() {
		return this.price;
	}
	
	public void setPrice(double price) {
		this.price = price;
	}
	
	public String getDescription() {
		return this.description;
	}
	
	public void setDescription(String description) {
		this.description = description;
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
		result = prime * result
				+ ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		long temp;
		temp = Double.doubleToLongBits(price);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result
				+ ((workGuid == null) ? 0 : workGuid.hashCode());
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
		Work other = (Work) obj;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (Double.doubleToLongBits(price) != Double
				.doubleToLongBits(other.price))
			return false;
		if (workGuid == null) {
			if (other.workGuid != null)
				return false;
		} else if (!workGuid.equals(other.workGuid))
			return false;
		return true;
	}
}
