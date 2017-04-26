package ru.rsreu.carservice.model.entities;

import java.util.UUID;

public class User {
	
	private static final String OFFLINE_MESSAGE = "Offline";
	private static final String ONLINE_MESSAGE = "Online";
	private int userId;
	private UUID userGuid;
	private String login;
	private String password;
	private boolean isOnline;
	
	public User() {
	}
	
	public User(int userId, UUID userGuid, String login, boolean isOnline) {
		setUserId(userId);
		setUserGuid(userGuid);
		setLogin(login);
		setIsOnline(isOnline);
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
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public boolean getIsOnline() {
		return this.isOnline;
	}
	
	public String getStatus() {
		return this.isOnline ? ONLINE_MESSAGE : OFFLINE_MESSAGE;
	}
	
	public void setIsOnline(boolean isOnline) {
		this.isOnline = isOnline;
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
