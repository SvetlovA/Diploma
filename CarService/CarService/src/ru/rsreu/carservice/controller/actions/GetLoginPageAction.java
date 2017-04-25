package ru.rsreu.carservice.controller.actions;


import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import resources.Resourcer;
import ru.rsreu.carservice.controller.Action;
import ru.rsreu.carservice.controller.RedirectType;
import ru.rsreu.carservice.controller.Url;
import ru.rsreu.carservice.controller.actions.utils.BaseUtils;
import ru.rsreu.carservice.controller.actions.utils.LoginUtils;
import ru.rsreu.carservice.model.bll.CarService;
import ru.rsreu.carservice.model.bll.Permission;
import ru.rsreu.carservice.model.dal.exceptions.DataBaseException;

public class GetLoginPageAction implements Action {
	
	@Override
	public Url execute(HttpServletRequest request)
			throws Exception, DataBaseException {
		BaseUtils.setErrorMessage(request);
		HttpSession session = request.getSession();
		Object login = session.getAttribute(Resourcer.getString("parameter.user.login"));
		if (login == null) {
			return new Url(Resourcer.getString("path.page.login"), RedirectType.FORWARD);
		}
		Object password = session.getAttribute(Resourcer.getString("parameter.user.password"));
		if (password == null) {
			return new Url(Resourcer.getString("path.page.login"), RedirectType.FORWARD);
		}
		Object permissionName = session.getAttribute(Resourcer.getString("parameter.user.permission"));
		if (permissionName ==null) {
			return new Url(Resourcer.getString("path.page.login"), RedirectType.FORWARD);
		}
		ServletContext context = request.getServletContext();
		CarService carService = (CarService) context.getAttribute(Resourcer.getString("parameter.carservice"));
		if (!carService.checkAutentification(login.toString(), password.toString())) {
			return new Url(Resourcer.getString("path.page.login"), RedirectType.FORWARD);
		}
		Permission permission = Permission.valueOf(permissionName.toString().toUpperCase());
		return LoginUtils.getPage(permission);
	}
}
