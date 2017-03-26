package ru.rsreu.carservice.controller.actions;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import resources.Resourcer;
import ru.rsreu.carservice.controller.Action;
import ru.rsreu.carservice.model.bll.CarServiceBl;

public class LogOutAction implements Action {

	@Override
	public String execute(HttpServletRequest request, CarServiceBl carServiceBl) throws SQLException {
		request.getSession().invalidate();
		return Resourcer.getString("path.page.index");
	}

}
