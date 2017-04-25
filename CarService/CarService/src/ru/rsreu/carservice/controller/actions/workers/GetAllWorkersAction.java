package ru.rsreu.carservice.controller.actions.workers;


import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import resources.Resourcer;
import ru.rsreu.carservice.controller.Action;
import ru.rsreu.carservice.controller.RedirectType;
import ru.rsreu.carservice.controller.Url;
import ru.rsreu.carservice.controller.actions.utils.WorkerUtils;
import ru.rsreu.carservice.model.bll.CarService;
import ru.rsreu.carservice.model.dal.exceptions.DataBaseException;

public class GetAllWorkersAction implements Action {
	
	@Override
	public Url execute(HttpServletRequest request) throws DataBaseException {
		ServletContext context = request.getServletContext();
		CarService carService = (CarService) context.getAttribute(Resourcer.getString("parameter.carservice"));
		WorkerUtils.setWorkers(request, carService.getAllWorkers());
		return new Url(Resourcer.getString("path.page.all.workers"), RedirectType.FORWARD);
	}
}
