package ru.rsreu.carservice.controller.actions.workers;

import java.sql.SQLException;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import resources.Resourcer;
import ru.rsreu.carservice.controller.Action;
import ru.rsreu.carservice.controller.actions.utils.WorkerUtils;
import ru.rsreu.carservice.model.bll.CarService;

public class GetAllWorkersAction implements Action {
	
	@Override
	public String execute(HttpServletRequest request) throws SQLException {
		ServletContext context = request.getServletContext();
		CarService carService = (CarService) context.getAttribute(Resourcer.getString("parameter.carservice"));
		WorkerUtils.setWorkers(request, carService.getAllWorkers());
		return Resourcer.getString("path.page.all.workers");
	}

	@Override
	public boolean isForward() {
		return true;
	}

}
