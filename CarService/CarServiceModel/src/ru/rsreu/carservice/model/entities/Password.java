package ru.rsreu.carservice.model.entities;

public class Password {
	
	private int passwordHash;
	
	public Password() {
	}
	
	public Password(int passwordHash) {
		setPasswordHash(passwordHash);
	}
	
	public int getPasswordHash() {
		return this.passwordHash;
	}
	
	public void setPasswordHash(int passwordHash) {
		this.passwordHash = passwordHash;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + passwordHash;
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
		Password other = (Password) obj;
		if (passwordHash != other.passwordHash)
			return false;
		return true;
	}
}
