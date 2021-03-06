package ru.rsreu.carservice.model.dal.exceptions;

import resources.Resourcer;

public class AddUserException extends DataBaseException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String login;
	
	public AddUserException(String login) {
		setLogin(login);
	}
	
	public AddUserException(String message, String login) {
		super(message);
		setLogin(login);
	}
	
	public AddUserException(Throwable cause, String login) {
		super(cause);
		setLogin(login);
	}
	
	public AddUserException(String message, Throwable cause, String login) {
		super(message, cause);
		setLogin(login);
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}
	
	@Override
	public String getMessage() {
		StringBuilder message = new StringBuilder(super.getMessage());
		message.append(String.format(Resourcer.getString("message.add.user.exception.explanation"), getLogin()));
		return message.toString();
	}
}
