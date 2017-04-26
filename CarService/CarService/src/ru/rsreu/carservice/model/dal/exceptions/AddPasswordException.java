package ru.rsreu.carservice.model.dal.exceptions;

import resources.Resourcer;

public class AddPasswordException extends DataBaseException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public AddPasswordException() {
	}
	
	public AddPasswordException(String message) {
		super(message);
	}
	
	public AddPasswordException(Throwable cause) {
		super(cause);
	}
	
	public AddPasswordException(String message, Throwable cause) {
		super(message, cause);
	}
	
	@Override
	public String getMessage() {
		StringBuilder message = new StringBuilder(super.getMessage());
		message.append(Resourcer.getString("message.add.password.exception.explanation"));
		return message.toString();
	}
}
