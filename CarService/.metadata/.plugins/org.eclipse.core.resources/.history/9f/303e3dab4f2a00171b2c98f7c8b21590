package ru.rsreu.carservice.model.dal.exceptions;

public class AddUserException extends DataBaseException {

	private static final String LOGIN_EXISTS_MESSAGE = " Login %s also exists.";

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
		message.append(String.format(LOGIN_EXISTS_MESSAGE, getLogin()));
		return message.toString();
	}
}
