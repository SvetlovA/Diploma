package ru.rsreu.carservice.controller.actions;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import resources.Resourcer;
import ru.rsreu.carservice.controller.Action;

public class GetAdminMenuPageAction implements Action {

	@Override
	public String execute(HttpServletRequest request) throws SQLException {
		return Resourcer.getString("path.page.menu.admin");
	}

}
