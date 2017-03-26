package ru.rsreu.carservice.controller.actions;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import resources.Resourcer;
import ru.rsreu.carservice.controller.Action;
import ru.rsreu.carservice.controller.actions.utils.LoginUtils;
import ru.rsreu.carservice.model.bll.CarServiceBl;
import ru.rsreu.carservice.model.bll.Permission;

public class GetLoginPageAction implements Action {

	@Override
	public String execute(HttpServletRequest request, CarServiceBl carServiceBl)
			throws SQLException, Exception {
		HttpSession session = request.getSession();
		Object login = session.getAttribute(Resourcer.getString("parameter.user.login"));
		if (login == null) {
			return Resourcer.getString("path.page.login");
		}
		Object password = session.getAttribute(Resourcer.getString("parameter.user.password"));
		if (password == null) {
			return Resourcer.getString("path.page.login");
		}
		Object permissionName = session.getAttribute(Resourcer.getString("parameter.user.permission"));
		if (permissionName ==null) {
			return Resourcer.getString("path.page.login");
		}
		if (!carServiceBl.checkAutentification(login.toString(), password.toString())) {
			return Resourcer.getString("path.page.login");
		}
		Permission permission = Permission.valueOf(permissionName.toString().toUpperCase());
		return LoginUtils.getPage(permission);
	}
}
