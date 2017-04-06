package ru.rsreu.carservice.controller.actions.works;

import java.sql.SQLException;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import resources.Resourcer;
import ru.rsreu.carservice.controller.Action;
import ru.rsreu.carservice.controller.actions.utils.WorkUtils;
import ru.rsreu.carservice.model.bll.CarService;

public class GetAllWorksAction implements Action {
	
	@Override
	public String execute(HttpServletRequest request) throws SQLException {
		ServletContext context = request.getServletContext();
		CarService carService = (CarService) context.getAttribute(Resourcer.getString("parameter.carservice"));
		WorkUtils.setWorks(request, carService.getAllWorks());
		return Resourcer.getString("path.page.all.works");
	}

}
