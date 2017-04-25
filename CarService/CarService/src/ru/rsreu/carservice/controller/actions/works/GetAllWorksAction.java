package ru.rsreu.carservice.controller.actions.works;


import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import resources.Resourcer;
import ru.rsreu.carservice.controller.Action;
import ru.rsreu.carservice.controller.RedirectType;
import ru.rsreu.carservice.controller.Url;
import ru.rsreu.carservice.controller.actions.utils.WorkUtils;
import ru.rsreu.carservice.model.bll.CarService;
import ru.rsreu.carservice.model.dal.exceptions.DataBaseException;

public class GetAllWorksAction implements Action {
	
	@Override
	public Url execute(HttpServletRequest request) throws DataBaseException {
		ServletContext context = request.getServletContext();
		CarService carService = (CarService) context.getAttribute(Resourcer.getString("parameter.carservice"));
		WorkUtils.setWorks(request, carService.getAllWorks());
		return new Url(Resourcer.getString("path.page.all.works"), RedirectType.FORWARD);
	}
}
