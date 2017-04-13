package ru.rsreu.carservice.controller.actions.workers;

import java.sql.SQLException;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import resources.Resourcer;
import ru.rsreu.carservice.controller.Action;
import ru.rsreu.carservice.controller.actions.utils.BaseUtils;
import ru.rsreu.carservice.controller.actions.utils.WorkerUtils;
import ru.rsreu.carservice.model.bll.CarService;
import ru.rsreu.carservice.model.entities.Worker;

public class DeleteWorkerAction implements Action {

	@Override
	public String execute(HttpServletRequest request) throws SQLException {
		Worker worker = WorkerUtils.parseWorker(request);
		ServletContext context = request.getServletContext();
		CarService carService = (CarService) context.getAttribute(Resourcer.getString("parameter.carservice"));
		carService.deleteUser(worker);
		return BaseUtils.getServletPath(Resourcer.getString("url.pattern.adminworkers"), Resourcer.getString("action.getallworkers"));
	}

	@Override
	public boolean isForward() {
		return false;
	}
}
