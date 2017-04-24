package ru.rsreu.carservice.controller.actions.utils;

import resources.Resourcer;
import ru.rsreu.carservice.model.bll.Permission;

public class LoginUtils {
	
	private static final String PASSWORD_PARAMETER_NAME = "password";
	private static final String LOGIN_PARAMETER_NAME = "login";

	private LoginUtils() {
	}
	
	public static String getPage(Permission permission) throws Exception {
		switch (permission) {
		case ADMIN:
			return BaseUtils.getServletPath(Resourcer.getString("url.pattern.adminmenu"), Resourcer.getString("action.getadminmenu"));
		case CLIENT:
			return BaseUtils.getServletPath(Resourcer.getString("url.pattern.clientmenu"), Resourcer.getString("action.getclientmenu"));
		case WORKER:
			return BaseUtils.getServletPath(Resourcer.getString("url.pattern.workermenu"), Resourcer.getString("action.getworkermenu"));
		default:
			throw new Exception("Page doesn't exists.");
		}
	}
	
	public static String getServletPath(String urlPattern, String action, String login, String password) {
		StringBuilder servletPath = new StringBuilder(BaseUtils.getServletPath(urlPattern, action));
		servletPath.append("&");
		servletPath.append(LOGIN_PARAMETER_NAME);
		servletPath.append("=");
		servletPath.append(login);
		servletPath.append("&");
		servletPath.append(PASSWORD_PARAMETER_NAME);
		servletPath.append("=");
		servletPath.append(password);
		return servletPath.toString();
	}
}
