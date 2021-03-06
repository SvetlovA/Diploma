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

public class LoginAction implements Action {
	
	@Override
	public Url execute(HttpServletRequest request) throws DataBaseException, Exception {
		BaseUtils.setErrorMessage(request);
		String login = request.getParameter(Resourcer.getString("parameter.user.login"));
		String password = request.getParameter(Resourcer.getString("parameter.user.password"));
		ServletContext context = request.getServletContext();
		CarService carService = (CarService) context.getAttribute(Resourcer.getString("parameter.carservice"));
		if (carService.checkAutentification(login, password)) {
			HttpSession session = request.getSession();
			session.setAttribute(Resourcer.getString("parameter.user.login"), login);
			session.setAttribute(Resourcer.getString("parameter.user.password"), password);
			Permission permission = carService.getPermission(login);
			session.setAttribute(Resourcer.getString("parameter.user.permission"), permission);
			return LoginUtils.getPage(permission);
		} else {
			return new Url(BaseUtils.createErrorUrl(Resourcer.getString("url.pattern.login"),
					Resourcer.getString("action.getloginpage"),
					Resourcer.getString("meassage.incorrect.login.password")), RedirectType.SEND_REDIRECT);
		}
	}
}
