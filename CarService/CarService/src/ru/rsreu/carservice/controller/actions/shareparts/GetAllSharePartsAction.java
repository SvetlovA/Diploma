package ru.rsreu.carservice.controller.actions.shareparts;

import java.sql.SQLException;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import resources.Resourcer;
import ru.rsreu.carservice.controller.Action;
import ru.rsreu.carservice.controller.actions.utils.SharePartUtils;
import ru.rsreu.carservice.model.bll.CarService;

public class GetAllSharePartsAction implements Action {
	
	@Override
	public String execute(HttpServletRequest request) throws SQLException {
		ServletContext context = request.getServletContext();
		CarService carService = (CarService) context.getAttribute(Resourcer.getString("parameter.carservice"));
		SharePartUtils.setShareParts(request, carService.getAllShareParts());
		return Resourcer.getString("path.page.all.shareparts");
	}

	@Override
	public boolean isForward() {
		return true;
	}

}
