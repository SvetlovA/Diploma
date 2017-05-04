package ru.rsreu.carservice.controller.actions.admins;

import java.util.UUID;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import resources.Resourcer;
import ru.rsreu.carservice.controller.Action;
import ru.rsreu.carservice.controller.RedirectType;
import ru.rsreu.carservice.controller.Url;
import ru.rsreu.carservice.controller.actions.utils.BaseUtils;
import ru.rsreu.carservice.model.bll.CarService;
import ru.rsreu.carservice.model.dal.exceptions.DataBaseException;
import ru.rsreu.carservice.model.entities.User;

public class AddAdminAction implements Action {

	private static final String ADMINLOGIN_PARAMETER_NAME = "adminlogin";
	private static final String ADMINPASSWORD_PARAMETER_NAME = "adminpassword";

	@Override
	public Url execute(HttpServletRequest request) throws DataBaseException,
			Exception {
		BaseUtils.setErrorMessage(request);
		User admin = new User();
		String adminLogin = request.getParameter(ADMINLOGIN_PARAMETER_NAME);
		admin.setLogin(adminLogin);
		UUID adminGuid = UUID.randomUUID();
		admin.setUserGuid(adminGuid);
		String password = request.getParameter(ADMINPASSWORD_PARAMETER_NAME);
		ServletContext context = request.getServletContext();
		CarService carService = (CarService) context.getAttribute(Resourcer.getString("parameter.carservice"));
		carService.addAccount(admin, password);
		return new Url(BaseUtils.createUrl(Resourcer.getString("url.pattern.adminadmins"), Resourcer.getString("action.getalladmins")),
				RedirectType.SEND_REDIRECT);
	}
}
