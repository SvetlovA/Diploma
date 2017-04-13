package ru.rsreu.carservice.controller.actions.shareparts;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import resources.Resourcer;
import ru.rsreu.carservice.controller.Action;

public class GetAddSharePartPageAction implements Action {

	@Override
	public String execute(HttpServletRequest request) throws SQLException {
		return Resourcer.getString("path.page.sharepart.add");
	}

	@Override
	public boolean isForward() {
		return true;
	}
}
