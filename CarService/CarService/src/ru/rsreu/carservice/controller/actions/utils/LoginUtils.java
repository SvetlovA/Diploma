package ru.rsreu.carservice.controller.actions.utils;

import resources.Resourcer;
import ru.rsreu.carservice.controller.RedirectType;
import ru.rsreu.carservice.controller.Url;
import ru.rsreu.carservice.model.bll.Permission;

public class LoginUtils {
	
	private static final String PASSWORD_PARAMETER_NAME = "password";
	private static final String LOGIN_PARAMETER_NAME = "login";

	private LoginUtils() {
	}
	
	public static Url getPage(Permission permission) throws Exception {
		switch (permission) {
		case ADMIN:
			return new Url(BaseUtils.createUrl(Resourcer.getString("url.pattern.adminmenu"), Resourcer.getString("action.getadminmenu")), RedirectType.SEND_REDIRECT);
		case CLIENT:
			return new Url(BaseUtils.createUrl(Resourcer.getString("url.pattern.clientmenu"), Resourcer.getString("action.getclientmenu")), RedirectType.SEND_REDIRECT);
		case WORKER:
			return new Url(BaseUtils.createUrl(Resourcer.getString("url.pattern.workermenu"), Resourcer.getString("action.getworkermenu")), RedirectType.SEND_REDIRECT);
		default:
			throw new Exception("Page doesn't exists.");
		}
	}
	
	public static String getUrl(String urlPattern, String action, String login, String password) {
		StringBuilder servletPath = new StringBuilder(BaseUtils.createUrl(urlPattern, action));
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
