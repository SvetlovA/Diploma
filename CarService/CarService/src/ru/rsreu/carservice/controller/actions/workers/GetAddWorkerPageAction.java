package ru.rsreu.carservice.controller.actions.workers;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import resources.Resourcer;
import ru.rsreu.carservice.controller.Action;

public class GetAddWorkerPageAction implements Action {

	@Override
	public String execute(HttpServletRequest request) throws SQLException {
		return Resourcer.getString("path.page.worker.add");
	}

}
