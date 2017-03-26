package ru.rsreu.carservice.controller.actions.clients;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import resources.Resourcer;
import ru.rsreu.carservice.controller.Action;
import ru.rsreu.carservice.controller.actions.utils.ClientUtils;
import ru.rsreu.carservice.model.bll.CarServiceBl;

public class GetAllClientsAction implements Action {
	
	@Override
	public String execute(HttpServletRequest request, CarServiceBl carServiceBl) throws SQLException {
		ClientUtils.setClients(request, carServiceBl.getAllClients());
		return Resourcer.getString("path.page.all.clients");
	}
}
