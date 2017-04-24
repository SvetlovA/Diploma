package ru.rsreu.carservice.controller.actions;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import resources.Resourcer;
import ru.rsreu.carservice.controller.Action;

public class GetRegistrationPageAction implements Action {

	@Override
	public String execute(HttpServletRequest request) throws SQLException,
			Exception {
		return Resourcer.getString("path.page.registration");
	}

	@Override
	public boolean isForward() {
		return true;
	}

}