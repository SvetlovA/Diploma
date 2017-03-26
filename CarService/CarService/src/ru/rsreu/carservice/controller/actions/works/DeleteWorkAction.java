package ru.rsreu.carservice.controller.actions.works;

import java.sql.SQLException;
import javax.servlet.http.HttpServletRequest;
import resources.Resourcer;
import ru.rsreu.carservice.controller.Action;
import ru.rsreu.carservice.controller.actions.utils.WorkUtils;
import ru.rsreu.carservice.model.bll.CarServiceBl;
import ru.rsreu.carservice.model.entities.Work;

public class DeleteWorkAction implements Action {
	
	@Override
	public String execute(HttpServletRequest request, CarServiceBl carServiceBl) throws SQLException {
		Work work = WorkUtils.parseWork(request);
		carServiceBl.deleteWork(work);
		WorkUtils.setWorks(request, carServiceBl.getAllWorks());
		return Resourcer.getString("path.page.all.works");
	}

}
