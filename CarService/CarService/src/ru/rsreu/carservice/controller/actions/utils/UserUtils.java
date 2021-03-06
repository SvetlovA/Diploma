package ru.rsreu.carservice.controller.actions.utils;

import java.util.Set;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import ru.rsreu.carservice.model.entities.Client;
import ru.rsreu.carservice.model.entities.User;

public class UserUtils {
	
	private static final String USERS_PARAMETER_NAME = "users";
	private static final String USERLOGIN_PARAMETER_NAME = "userlogin";
	private static final String USERGUID_PARAMETER_NAME = "userguid";
	private static final String USERID_PARAMETER_NAME = "userid";

	private UserUtils() {
	}
	
	public static User parseUser(HttpServletRequest request) {
		User user = new User();
		int userId = Integer.parseInt(request.getParameter(USERID_PARAMETER_NAME));
		user.setUserId(userId);
		UUID userGuid = UUID.fromString(request.getParameter(USERGUID_PARAMETER_NAME));
		user.setUserGuid(userGuid);
		String userLogin = request.getParameter(USERLOGIN_PARAMETER_NAME);
		user.setLogin(userLogin);
		return user;
	}
	
	public static void setUser(HttpServletRequest request, User user) {
		request.setAttribute(USERID_PARAMETER_NAME, user.getUserId());
		request.setAttribute(USERGUID_PARAMETER_NAME, user.getUserGuid());
		request.setAttribute(USERLOGIN_PARAMETER_NAME, user.getLogin());
	}
	
	public static void setUsers(HttpServletRequest reques, Set<User> users) {
		reques.setAttribute(USERS_PARAMETER_NAME, users);
	}
	
	public static String getUrl(String urlPattern, String action, Client client) {
		StringBuilder servletPath = new StringBuilder(BaseUtils.createUrl(urlPattern, action));
		servletPath.append("&");
		servletPath.append(USERID_PARAMETER_NAME);
		servletPath.append("=");
		servletPath.append(client.getUserId());
		servletPath.append("&");
		servletPath.append(USERGUID_PARAMETER_NAME);
		servletPath.append("=");
		servletPath.append(client.getUserGuid());
		servletPath.append("&");
		servletPath.append(USERLOGIN_PARAMETER_NAME);
		servletPath.append("=");
		servletPath.append(client.getLogin());
		return servletPath.toString();
	}
}
