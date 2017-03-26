package ru.rsreu.carservice.model.entities;

import java.util.UUID;

public class User {
	
	private int userId;
	private UUID userGuid;
	private String login;
	
	public User() {
	}
	
	public User(int userId, UUID userGuid, String login) {
		setUserId(userId);
		setUserGuid(userGuid);
		setLogin(login);
	}
	
	public int getUserId() {
		return this.userId;
	}
	
	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	public UUID getUserGuid() {
		return this.userGuid;
	}
	
	public void setUserGuid(UUID userGuid) {
		this.userGuid = userGuid;
	}
	
	public String getLogin() {
		return this.login;
	}
	
	public void setLogin(String login) {
		this.login = login;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((login == null) ? 0 : login.hashCode());
		result = prime * result
				+ ((userGuid == null) ? 0 : userGuid.hashCode());
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
		User other = (User) obj;
		if (login == null) {
			if (other.login != null)
				return false;
		} else if (!login.equals(other.login))
			return false;
		if (userGuid == null) {
			if (other.userGuid != null)
				return false;
		} else if (!userGuid.equals(other.userGuid))
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuilder output = new StringBuilder();
		output.append("UserId:");
		output.append(getUserId());
		output.append(", UserGuid:");
		output.append(getUserGuid());
		output.append(", Login:");
		output.append(getLogin());
		return output.toString();
	}
}
