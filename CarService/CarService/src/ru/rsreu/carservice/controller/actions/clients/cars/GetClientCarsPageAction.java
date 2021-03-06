package ru.rsreu.carservice.controller.actions.clients.cars;


import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import resources.Resourcer;
import ru.rsreu.carservice.controller.Action;
import ru.rsreu.carservice.controller.RedirectType;
import ru.rsreu.carservice.controller.Url;
import ru.rsreu.carservice.controller.actions.utils.BaseUtils;
import ru.rsreu.carservice.controller.actions.utils.CarUtils;
import ru.rsreu.carservice.controller.actions.utils.ClientUtils;
import ru.rsreu.carservice.model.bll.CarService;
import ru.rsreu.carservice.model.dal.exceptions.DataBaseException;
import ru.rsreu.carservice.model.entities.Client;

public class GetClientCarsPageAction implements Action {
	
	private static final String CLIENTNAME_PARAMETER_NAME = "clientname";

	@Override
	public Url execute(HttpServletRequest request) throws DataBaseException, Exception {
		BaseUtils.setErrorMessage(request);
		ServletContext context = request.getServletContext();
		CarService carService = (CarService) context.getAttribute(Resourcer.getString("parameter.carservice"));
		Client client = null;
		if (request.getParameterMap().size() > 1) {
			client = ClientUtils.parseClient(request);
		} else {
			HttpSession session = request.getSession();
			String login = session.getAttribute(Resourcer.getString("parameter.user.login")).toString();
			client = carService.getClient(login);
		}
		request.setAttribute(CLIENTNAME_PARAMETER_NAME, client.getName());
		CarUtils.setCars(request, carService.getClientCars(client));
		ClientUtils.setClient(request, client);
		return new Url(Resourcer.getString("path.page.client.cars"), RedirectType.FORWARD);
	}
}
