package ru.rsreu.carservice.controller.actions.admins;

import java.util.Set;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import resources.Resourcer;
import ru.rsreu.carservice.controller.Action;
import ru.rsreu.carservice.controller.RedirectType;
import ru.rsreu.carservice.controller.Url;
import ru.rsreu.carservice.controller.actions.utils.BaseUtils;
import ru.rsreu.carservice.controller.actions.utils.UserUtils;
import ru.rsreu.carservice.model.bll.CarService;
import ru.rsreu.carservice.model.dal.exceptions.DataBaseException;
import ru.rsreu.carservice.model.entities.User;

public class GetAllAdminsAction implements Action {

	@Override
	public Url execute(HttpServletRequest request) throws DataBaseException,
			Exception {
		BaseUtils.setErrorMessage(request);
		ServletContext context = request.getServletContext();
		CarService carService = (CarService) context.getAttribute(Resourcer.getString("parameter.carservice"));
		Set<User> admins = carService.getAllAdmins();
		UserUtils.setUsers(request, admins);
		return new Url(Resourcer.getString("path.page.all.admins"), RedirectType.FORWARD);
	}
}
