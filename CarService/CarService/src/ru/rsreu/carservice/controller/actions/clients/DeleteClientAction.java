package ru.rsreu.carservice.controller.actions.clients;

import java.sql.SQLException;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import resources.Resourcer;
import ru.rsreu.carservice.controller.Action;
import ru.rsreu.carservice.controller.actions.utils.ClientUtils;
import ru.rsreu.carservice.model.bll.CarService;
import ru.rsreu.carservice.model.entities.Client;

public class DeleteClientAction implements Action {

	@Override
	public String execute(HttpServletRequest request) throws SQLException {
		Client client = ClientUtils.parseClient(request);
		ServletContext context = request.getServletContext();
		CarService carService = (CarService) context.getAttribute(Resourcer.getString("parameter.carservice"));
		carService.deleteUser(client);
		ClientUtils.setClients(request, carService.getAllClients());
		return Resourcer.getString("path.page.all.clients");
	}

}
