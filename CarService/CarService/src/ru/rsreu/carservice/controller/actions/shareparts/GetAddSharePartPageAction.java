package ru.rsreu.carservice.controller.actions.shareparts;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import resources.Resourcer;
import ru.rsreu.carservice.controller.Action;
import ru.rsreu.carservice.model.bll.CarServiceBl;

public class GetAddSharePartPageAction implements Action {

	@Override
	public String execute(HttpServletRequest request, CarServiceBl carServiceBl) throws SQLException {
		return Resourcer.getString("path.page.sharepart.add");
	}
}
