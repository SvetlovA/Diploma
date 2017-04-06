package ru.rsreu.carservice.controller.actions.works;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import resources.Resourcer;
import ru.rsreu.carservice.controller.Action;
import ru.rsreu.carservice.controller.actions.utils.WorkUtils;
import ru.rsreu.carservice.model.entities.Work;

public class GetDeleteWorkPageAction implements Action {

	@Override
	public String execute(HttpServletRequest request) throws SQLException {
		Work work = WorkUtils.parseWork(request);
		WorkUtils.setWork(request, work);
		return Resourcer.getString("path.page.work.delete");
	}
}
