package ru.rsreu.carservice.model.entities;

import java.sql.Timestamp;
import java.util.Set;
import java.util.UUID;

public class Order {
	
	private int orderId;
	private UUID orderGuid;
	private Car car;
	private Set<Worker> workers;
	private Set<Work> works;
	private Set<SharePart> shareParts;
	private double totalCost;
	private WorkStatus status;
	private Timestamp orderDate;
	
	public Order() {
	}
	
	public Order(int orderId, UUID orderGuid, Car car, Set<Worker> workers, Set<Work> works,
			Set<SharePart> shareParts, double totalCost, WorkStatus status) {
		setOrderId(orderId);
		setOrderGuid(orderGuid);
		setCar(car);
		setWorkers(workers);
		setWorks(works);
		setShareParts(shareParts);
		setTotalCost(totalCost);
		setStatus(status);
	}
	
	public int getOrderId() {
		return this.orderId;
	}
	
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	
	public UUID getOrderGuid() {
		return this.orderGuid;
	}
	
	public void setOrderGuid(UUID orderGuid) {
		this.orderGuid = orderGuid;
	}
	
	public Car getCar() {
		return this.car;
	}
	
	public void setCar(Car car) {
		this.car = car;
	}
	
	public Set<Worker> getWorkers() {
		return this.workers;
	}
	
	public void setWorkers(Set<Worker> workers) {
		this.workers = workers;
	}
	
	public Set<Work> getWorks() {
		return this.works;
	}
	
	public void setWorks(Set<Work> works) {
		this.works = works;
	}
	
	public Set<SharePart> getShareParts() {
		return this.shareParts;
	}
	
	public void setShareParts(Set<SharePart> shareParts) {
		this.shareParts = shareParts;
	}
	
	public double getTotalCost() {
		return this.totalCost;
	}
	
	public void setTotalCost(double totalCost) {
		this.totalCost = totalCost;
	}
	
	public WorkStatus getStatus() {
		return this.status;
	}
	
	public void setStatus(WorkStatus status) {
		this.status = status;
	}
	
	public Timestamp getOrderDate() {
		return this.orderDate;
	}
	
	public void setOrderDate(Timestamp orderDate) {
		this.orderDate = orderDate;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((car == null) ? 0 : car.hashCode());
		result = prime * result
				+ ((orderGuid == null) ? 0 : orderGuid.hashCode());
		result = prime * result
				+ ((shareParts == null) ? 0 : shareParts.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		long temp;
		temp = Double.doubleToLongBits(totalCost);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((workers == null) ? 0 : workers.hashCode());
		result = prime * result + ((works == null) ? 0 : works.hashCode());
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
		Order other = (Order) obj;
		if (car == null) {
			if (other.car != null)
				return false;
		} else if (!car.equals(other.car))
			return false;
		if (orderGuid == null) {
			if (other.orderGuid != null)
				return false;
		} else if (!orderGuid.equals(other.orderGuid))
			return false;
		if (shareParts == null) {
			if (other.shareParts != null)
				return false;
		} else if (!shareParts.equals(other.shareParts))
			return false;
		if (status != other.status)
			return false;
		if (Double.doubleToLongBits(totalCost) != Double
				.doubleToLongBits(other.totalCost))
			return false;
		if (workers == null) {
			if (other.workers != null)
				return false;
		} else if (!workers.equals(other.workers))
			return false;
		if (works == null) {
			if (other.works != null)
				return false;
		} else if (!works.equals(other.works))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return getOrderGuid().toString();
	}
}
