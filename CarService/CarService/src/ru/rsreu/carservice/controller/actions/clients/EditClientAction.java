package ru.rsreu.carservice.controller.actions.clients;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import resources.Resourcer;
import ru.rsreu.carservice.controller.Action;
import ru.rsreu.carservice.controller.actions.utils.ClientUtils;
import ru.rsreu.carservice.model.bll.CarServiceBl;
import ru.rsreu.carservice.model.entities.Client;

public class EditClientAction implements Action {

	@Override
	public String execute(HttpServletRequest request, CarServiceBl carServiceBl) throws SQLException {
		Client client = ClientUtils.parseClient(request);
		carServiceBl.updateClient(client);
		ClientUtils.setClients(request, carServiceBl.getAllClients());
		return Resourcer.getString("path.page.all.clients");
	}

}
