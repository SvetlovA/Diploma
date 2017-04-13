package ru.rsreu.carservice.controller.actions.clients;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import resources.Resourcer;
import ru.rsreu.carservice.controller.Action;
import ru.rsreu.carservice.controller.actions.utils.ClientUtils;
import ru.rsreu.carservice.model.entities.Client;

public class GetDeleteClientPageAction implements Action {

	@Override
	public String execute(HttpServletRequest request) throws SQLException {
		Client client = ClientUtils.parseClient(request);
		ClientUtils.setClient(request, client);
		return Resourcer.getString("path.page.client.delete");
	}

	@Override
	public boolean isForward() {
		return true;
	}

}
