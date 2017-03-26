package ru.rsreu.carservice.model.entities;

import java.util.Set;
import java.util.UUID;

public class SharePart {
	
	private int sharePartId;
	private UUID sharePartGuid;
	private String name;
	private double price;
	private int count;
	private String description;
	private Set<Order> orders;
	
	public SharePart() {
	}
	
	public SharePart(int shrePartId, UUID sharePartGuid, String name, double price, int count,
			String description, Set<Order> orders) {
		setSharePartId(shrePartId);
		setSharePartGuid(sharePartGuid);
		setName(name);
		setPrice(price);
		setCount(count);
		setDescription(description);
		setOrders(orders);
	}
	
	public int getSharePartId() {
		return this.sharePartId;
	}
	
	public void setSharePartId(int sharePartId) {
		this.sharePartId = sharePartId;
	}
	
	public UUID getSharePartGuid() {
		return this.sharePartGuid;
	}
	
	public void setSharePartGuid(UUID sharePartGuid) {
		this.sharePartGuid = sharePartGuid;
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
	
	public int getCount() {
		return this.count;
	}
	
	public void setCount(int count) {
		this.count = count;
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
		result = prime * result + count;
		result = prime * result
				+ ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		long temp;
		temp = Double.doubleToLongBits(price);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result
				+ ((sharePartGuid == null) ? 0 : sharePartGuid.hashCode());
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
		SharePart other = (SharePart) obj;
		if (count != other.count)
			return false;
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
		if (sharePartGuid == null) {
			if (other.sharePartGuid != null)
				return false;
		} else if (!sharePartGuid.equals(other.sharePartGuid))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return getName();
	}
}
