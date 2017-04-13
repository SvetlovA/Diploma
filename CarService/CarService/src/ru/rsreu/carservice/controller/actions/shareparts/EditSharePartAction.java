package ru.rsreu.carservice.controller.actions.shareparts;

import java.sql.SQLException;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import resources.Resourcer;
import ru.rsreu.carservice.controller.Action;
import ru.rsreu.carservice.controller.actions.utils.BaseUtils;
import ru.rsreu.carservice.controller.actions.utils.SharePartUtils;
import ru.rsreu.carservice.model.bll.CarService;
import ru.rsreu.carservice.model.entities.SharePart;

public class EditSharePartAction implements Action {
	
	@Override
	public String execute(HttpServletRequest request) throws SQLException {
		SharePart sharePart = SharePartUtils.parseSharePart(request);
		ServletContext context = request.getServletContext();
		CarService carService = (CarService) context.getAttribute(Resourcer.getString("parameter.carservice"));
		carService.updateSharePart(sharePart);
		return BaseUtils.getServletPath(Resourcer.getString("url.pattern.adminshareparts"), Resourcer.getString("action.getallshareparts"));
	}

	@Override
	public boolean isForward() {
		return false;
	}
}
