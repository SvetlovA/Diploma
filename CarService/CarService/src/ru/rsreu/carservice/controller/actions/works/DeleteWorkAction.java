package ru.rsreu.carservice.controller.actions.works;

import java.sql.SQLException;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import resources.Resourcer;
import ru.rsreu.carservice.controller.Action;
import ru.rsreu.carservice.controller.actions.utils.BaseUtils;
import ru.rsreu.carservice.controller.actions.utils.WorkUtils;
import ru.rsreu.carservice.model.bll.CarService;
import ru.rsreu.carservice.model.entities.Work;

public class DeleteWorkAction implements Action {
	
	@Override
	public String execute(HttpServletRequest request) throws SQLException {
		Work work = WorkUtils.parseWork(request);
		ServletContext context = request.getServletContext();
		CarService carService = (CarService) context.getAttribute(Resourcer.getString("parameter.carservice"));
		carService.deleteWork(work);
		return BaseUtils.getServletPath(Resourcer.getString("url.pattern.adminworks"), Resourcer.getString("action.getallworks"));
	}

	@Override
	public boolean isForward() {
		return false;
	}

}
