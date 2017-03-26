package ru.rsreu.carservice.controller.actions.clients.cars;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import resources.Resourcer;
import ru.rsreu.carservice.controller.Action;
import ru.rsreu.carservice.controller.actions.utils.ClientUtils;
import ru.rsreu.carservice.model.bll.CarServiceBl;
import ru.rsreu.carservice.model.entities.Client;

public class GetAddCarPageAction implements Action {
	
	@Override
	public String execute(HttpServletRequest request, CarServiceBl carServiceBl) throws SQLException {
		Client client = ClientUtils.parseClient(request);
		ClientUtils.setClient(request, client);
		return Resourcer.getString("path.page.car.add");
	}

}
