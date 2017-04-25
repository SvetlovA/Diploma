package ru.rsreu.carservice.controller.actions.utils;

import javax.servlet.http.HttpServletRequest;

public class BaseUtils {
	private static final String ACTION_PARAMETER_NAME = "action";
	private static final String ERROR_MESSAGE_PARAMETER_NAME = "errorMessage";
	
	private BaseUtils() {
	}
	
	public static String createUrl(String urlPattern, String action) {
		StringBuilder baseUrl = new StringBuilder();
		baseUrl.append(urlPattern);
		baseUrl.append("?");
		baseUrl.append(ACTION_PARAMETER_NAME);
		baseUrl.append("=");
		baseUrl.append(action);
		return baseUrl.toString();
	}
	
	public static String createErrorUrl(String urlPattern, String action, String errorMessage) {
		String baseUrl = createUrl(urlPattern, action);
		return createErrorUrl(baseUrl, errorMessage);
	}
	
	public static String createErrorUrl(String url, String errorMessage) {
		StringBuilder baseUrl = new StringBuilder(url);
		baseUrl.append("&");
		baseUrl.append(ERROR_MESSAGE_PARAMETER_NAME);
		baseUrl.append("=");
		baseUrl.append(errorMessage);
		return baseUrl.toString();
	}
	
	public static void setErrorMessage(HttpServletRequest request) {
		request.setAttribute(ERROR_MESSAGE_PARAMETER_NAME, request.getParameter(ERROR_MESSAGE_PARAMETER_NAME));
	}
}
