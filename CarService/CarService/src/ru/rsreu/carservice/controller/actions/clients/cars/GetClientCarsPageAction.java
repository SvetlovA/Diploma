package ru.rsreu.carservice.controller.actions.clients.cars;

import java.sql.SQLException;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import resources.Resourcer;
import ru.rsreu.carservice.controller.Action;
import ru.rsreu.carservice.controller.actions.utils.CarUtils;
import ru.rsreu.carservice.controller.actions.utils.ClientUtils;
import ru.rsreu.carservice.model.bll.CarService;
import ru.rsreu.carservice.model.entities.Client;

public class GetClientCarsPageAction implements Action {
	
	private static final String CLIENTNAME_PARAMETER_NAME = "clientname";

	@Override
	public String execute(HttpServletRequest request) throws SQLException {
		Client client = ClientUtils.parseClient(request);
		request.setAttribute(CLIENTNAME_PARAMETER_NAME, client.getName());
		ServletContext context = request.getServletContext();
		CarService carService = (CarService) context.getAttribute(Resourcer.getString("parameter.carservice"));
		CarUtils.setCars(request, carService.getClientCars(client));
		ClientUtils.setClient(request, client);
		return Resourcer.getString("path.page.client.cars");
	}

	@Override
	public boolean isForward() {
		return true;
	}

}
