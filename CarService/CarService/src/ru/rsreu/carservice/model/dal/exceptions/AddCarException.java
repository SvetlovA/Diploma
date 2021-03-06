package ru.rsreu.carservice.model.dal.exceptions;

import resources.Resourcer;

public class AddCarException extends DataBaseException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String number;
	
	public AddCarException(String number) {
		setNumber(number);
	}
	
	public AddCarException(String message, String number) {
		super(message);
		setNumber(number);
	}
	
	public AddCarException(Throwable cause, String number) {
		super(cause);
		setNumber(number);
	}
	
	public AddCarException(String message, Throwable cause, String number) {
		super(message, cause);
		setNumber(number);
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}
	
	@Override
	public String getMessage() {
		StringBuilder message = new StringBuilder(super.getMessage());
		message.append(String.format(Resourcer.getString("message.add.car.exception.explanation"), getNumber()));
		return message.toString();
	}
}
