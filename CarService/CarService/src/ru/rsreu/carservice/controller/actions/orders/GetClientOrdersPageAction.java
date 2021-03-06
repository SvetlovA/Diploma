package ru.rsreu.carservice.controller.actions.orders;

import java.util.Set;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import resources.Resourcer;
import ru.rsreu.carservice.controller.Action;
import ru.rsreu.carservice.controller.RedirectType;
import ru.rsreu.carservice.controller.Url;
import ru.rsreu.carservice.controller.actions.utils.BaseUtils;
import ru.rsreu.carservice.controller.actions.utils.OrderUtils;
import ru.rsreu.carservice.model.bll.CarService;
import ru.rsreu.carservice.model.dal.exceptions.DataBaseException;
import ru.rsreu.carservice.model.entities.Client;
import ru.rsreu.carservice.model.entities.Order;

public class GetClientOrdersPageAction implements Action {

	@Override
	public Url execute(HttpServletRequest request)
			throws DataBaseException, Exception {
		BaseUtils.setErrorMessage(request);
		HttpSession session = request.getSession();
		String login = session.getAttribute(Resourcer.getString("parameter.user.login")).toString();
		ServletContext context = request.getServletContext();
		CarService carService = (CarService) context.getAttribute(Resourcer.getString("parameter.carservice"));
		Client client = carService.getClient(login);
		Set<Order> orders = carService.getClientOrders(client);
		OrderUtils.setOrders(request, orders);
		return new Url(Resourcer.getString("path.page.client.orders"), RedirectType.FORWARD);
	}
}
