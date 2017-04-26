package ru.rsreu.carservice.controller.actions.workers;


import javax.servlet.http.HttpServletRequest;

import resources.Resourcer;
import ru.rsreu.carservice.controller.Action;
import ru.rsreu.carservice.controller.RedirectType;
import ru.rsreu.carservice.controller.Url;
import ru.rsreu.carservice.controller.actions.utils.BaseUtils;
import ru.rsreu.carservice.controller.actions.utils.WorkerUtils;
import ru.rsreu.carservice.model.dal.exceptions.DataBaseException;
import ru.rsreu.carservice.model.entities.Worker;
public class GetEditWorkerPageAction implements Action {
	
	@Override
	public Url execute(HttpServletRequest request) throws DataBaseException, Exception {
		BaseUtils.setErrorMessage(request);
		Worker worker = WorkerUtils.parseWorker(request);
		WorkerUtils.setWorker(request, worker);
		return new Url(Resourcer.getString("path.page.worker.edit"), RedirectType.FORWARD);
	}
}
