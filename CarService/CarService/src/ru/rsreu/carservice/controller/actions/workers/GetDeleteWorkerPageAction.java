package ru.rsreu.carservice.controller.actions.workers;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import resources.Resourcer;
import ru.rsreu.carservice.controller.Action;
import ru.rsreu.carservice.controller.actions.utils.WorkerUtils;
import ru.rsreu.carservice.model.entities.Worker;

public class GetDeleteWorkerPageAction implements Action {

	@Override
	public String execute(HttpServletRequest request) throws SQLException {
		Worker worker = WorkerUtils.parseWorker(request);
		WorkerUtils.setWorker(request, worker);
		return Resourcer.getString("path.page.worker.delete");
	}

	@Override
	public boolean isForward() {
		return true;
	}

}
