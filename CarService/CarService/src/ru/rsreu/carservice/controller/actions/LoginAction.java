package ru.rsreu.carservice.controller.actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import resources.Resourcer;
import ru.rsreu.carservice.controller.Action;
import ru.rsreu.carservice.controller.actions.utils.LoginUtils;
import ru.rsreu.carservice.model.bll.CarServiceBl;
import ru.rsreu.carservice.model.bll.Permission;

public class LoginAction implements Action {
	
	private final static String ERROR_LOGIN_PASSWORD_ATTRIBUTE_NAME = "errorLoginPassword";
	
	@Override
	public String execute(HttpServletRequest request, CarServiceBl carServiceBl) throws Exception {
		String login = request.getParameter(Resourcer.getString("parameter.user.login"));
		String password = request.getParameter(Resourcer.getString("parameter.user.password"));
		if (carServiceBl.checkAutentification(login, password)) {
			HttpSession session = request.getSession();
			session.setAttribute(Resourcer.getString("parameter.user.login"), login);
			session.setAttribute(Resourcer.getString("parameter.user.password"), password);
			Permission permission = carServiceBl.getPermission(login);
			session.setAttribute(Resourcer.getString("parameter.user.permission"), permission);
			return LoginUtils.getPage(permission);
		} else {
			request.setAttribute(ERROR_LOGIN_PASSWORD_ATTRIBUTE_NAME, Resourcer.getString("meassage.incorrect.login.password"));
			return Resourcer.getString("path.page.login");
		}
	}
}
