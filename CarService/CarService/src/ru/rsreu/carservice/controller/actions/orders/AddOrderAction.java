package ru.rsreu.carservice.controller.actions.orders;

import java.sql.SQLException;
import java.util.Set;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import resources.Resourcer;
import ru.rsreu.carservice.controller.Action;
import ru.rsreu.carservice.controller.actions.utils.OrderUtils;
import ru.rsreu.carservice.controller.actions.utils.SharePartUtils;
import ru.rsreu.carservice.controller.actions.utils.WorkUtils;
import ru.rsreu.carservice.model.bll.CarServiceBl;
import ru.rsreu.carservice.model.entities.Car;
import ru.rsreu.carservice.model.entities.Client;
import ru.rsreu.carservice.model.entities.Order;
import ru.rsreu.carservice.model.entities.SharePart;
import ru.rsreu.carservice.model.entities.Work;

public class AddOrderAction implements Action {

	private static final String SELECTED_CAR_PARAMETER_NAME = "selectedCar";

	@Override
	public String execute(HttpServletRequest request, CarServiceBl carServiceBl)
			throws SQLException, Exception {
		Order order = new Order();
		UUID orderGuid = UUID.randomUUID();
		order.setOrderGuid(orderGuid);
		String carNumber = request.getParameter(SELECTED_CAR_PARAMETER_NAME);
		Car selectedCar = carServiceBl.getCar(carNumber);
		order.setCar(selectedCar);
		Set<Work> selectedWorks = WorkUtils.getSelectedWorks(request, carServiceBl);
		order.setWorks(selectedWorks);
		Set<SharePart> selectedShareParts = SharePartUtils.getSelectedShareParts(request, carServiceBl);
		order.setShareParts(selectedShareParts);
		carServiceBl.addOrder(order, order.getWorks(), order.getShareParts());
		HttpSession session = request.getSession();
		String login = session.getAttribute(Resourcer.getString("parameter.user.login")).toString();
		Client client = carServiceBl.getClient(login);
		Set<Order> orders = carServiceBl.getClientOrders(client);
		OrderUtils.setOrders(request, orders);
		return Resourcer.getString("path.page.client.orders");
	}

}
