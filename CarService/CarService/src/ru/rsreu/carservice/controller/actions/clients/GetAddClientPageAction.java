package ru.rsreu.carservice.controller.actions.clients;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import resources.Resourcer;
import ru.rsreu.carservice.controller.Action;

public class GetAddClientPageAction implements Action {

	@Override
	public String execute(HttpServletRequest request) throws SQLException {
		return Resourcer.getString("path.page.client.add");
	}

	@Override
	public boolean isForward() {
		return true;
	}

}
