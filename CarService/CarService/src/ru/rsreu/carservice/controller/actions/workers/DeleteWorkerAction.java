package ru.rsreu.carservice.controller.actions.workers;


import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import resources.Resourcer;
import ru.rsreu.carservice.controller.Action;
import ru.rsreu.carservice.controller.RedirectType;
import ru.rsreu.carservice.controller.Url;
import ru.rsreu.carservice.controller.actions.utils.BaseUtils;
import ru.rsreu.carservice.controller.actions.utils.WorkerUtils;
import ru.rsreu.carservice.model.bll.CarService;
import ru.rsreu.carservice.model.dal.exceptions.DataBaseException;
import ru.rsreu.carservice.model.entities.Worker;

public class DeleteWorkerAction implements Action {

	@Override
	public Url execute(HttpServletRequest request) throws DataBaseException, Exception {
		Worker worker = WorkerUtils.parseWorker(request);
		ServletContext context = request.getServletContext();
		CarService carService = (CarService) context.getAttribute(Resourcer.getString("parameter.carservice"));
		carService.deleteUser(worker);
		return new Url(BaseUtils.createUrl(Resourcer.getString("url.pattern.adminworkers"),
				Resourcer.getString("action.getallworkers")), RedirectType.SEND_REDIRECT);
	}
}
