package ru.rsreu.carservice.model.dal.exceptions;

public class DataBaseException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public DataBaseException() {
	}
	
	public DataBaseException(String message) {
		super(message);
	}
	
	public DataBaseException(Throwable cause) {
		super(cause);
	}
	
	public DataBaseException(String message, Throwable cause) {
		super(message, cause);
	}
}
