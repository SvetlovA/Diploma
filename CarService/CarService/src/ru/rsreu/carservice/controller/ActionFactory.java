package ru.rsreu.carservice.controller;

import javax.servlet.http.HttpServletRequest;

public class ActionFactory {
	
	private final static String PARMETER_NAME = "action";
	
	public ActionFactory() {
	}
	
	public Action getAction(HttpServletRequest request) {
		String action = request.getParameter(PARMETER_NAME);
		ActionType actionType = ActionType.valueOf(action.toUpperCase());
		return actionType.getAction();
	}
}
