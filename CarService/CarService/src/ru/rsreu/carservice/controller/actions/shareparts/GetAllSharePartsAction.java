package ru.rsreu.carservice.controller.actions.shareparts;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import resources.Resourcer;
import ru.rsreu.carservice.controller.Action;
import ru.rsreu.carservice.controller.actions.utils.SharePartUtils;
import ru.rsreu.carservice.model.bll.CarServiceBl;

public class GetAllSharePartsAction implements Action {
	
	@Override
	public String execute(HttpServletRequest request, CarServiceBl carServiceBl) throws SQLException {
		SharePartUtils.setShareParts(request, carServiceBl.getAllShareParts());
		return Resourcer.getString("path.page.all.shareparts");
	}

}
