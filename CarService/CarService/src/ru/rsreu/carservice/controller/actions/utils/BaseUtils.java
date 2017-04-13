package ru.rsreu.carservice.controller.actions.utils;

public class BaseUtils {
	private static final String ACTION_PARAMETER_NAME = "action";
	
	private BaseUtils() {
	}
	
	public static String getServletPath(String urlPattern, String action) {
		StringBuilder servletPath = new StringBuilder();
		servletPath.append(urlPattern);
		servletPath.append("?");
		servletPath.append(ACTION_PARAMETER_NAME);
		servletPath.append("=");
		servletPath.append(action);
		return servletPath.toString();
	}
}
