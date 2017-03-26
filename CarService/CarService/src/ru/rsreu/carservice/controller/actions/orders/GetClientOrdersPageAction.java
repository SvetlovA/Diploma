package ru.rsreu.carservice.controller.actions.orders;

import java.sql.SQLException;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import resources.Resourcer;
import ru.rsreu.carservice.controller.Action;
import ru.rsreu.carservice.controller.actions.utils.OrderUtils;
import ru.rsreu.carservice.model.bll.CarServiceBl;
import ru.rsreu.carservice.model.entities.Client;
import ru.rsreu.carservice.model.entities.Order;

public class GetClientOrdersPageAction implements Action {

	@Override
	public String execute(HttpServletRequest request, CarServiceBl carServiceBl)
			throws SQLException, Exception {
		HttpSession session = request.getSession();
		String login = session.getAttribute(Resourcer.getString("parameter.user.login")).toString();
		Client client = carServiceBl.getClient(login);
		Set<Order> orders = carServiceBl.getClientOrders(client);
		OrderUtils.setOrders(request, orders);
		return Resourcer.getString("path.page.client.orders");
	}

}
