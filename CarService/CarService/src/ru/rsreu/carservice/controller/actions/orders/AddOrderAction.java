package ru.rsreu.carservice.controller.actions.orders;

import java.sql.SQLException;
import java.util.Set;
import java.util.UUID;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import resources.Resourcer;
import ru.rsreu.carservice.controller.Action;
import ru.rsreu.carservice.controller.actions.utils.OrderUtils;
import ru.rsreu.carservice.controller.actions.utils.SharePartUtils;
import ru.rsreu.carservice.controller.actions.utils.WorkUtils;
import ru.rsreu.carservice.model.bll.CarService;
import ru.rsreu.carservice.model.entities.Car;
import ru.rsreu.carservice.model.entities.Client;
import ru.rsreu.carservice.model.entities.Order;
import ru.rsreu.carservice.model.entities.SharePart;
import ru.rsreu.carservice.model.entities.Work;

public class AddOrderAction implements Action {

	private static final String SELECTED_CAR_PARAMETER_NAME = "selectedCar";

	@Override
	public String execute(HttpServletRequest request)
			throws SQLException, Exception {
		Order order = new Order();
		UUID orderGuid = UUID.randomUUID();
		order.setOrderGuid(orderGuid);
		String carNumber = request.getParameter(SELECTED_CAR_PARAMETER_NAME);
		ServletContext context = request.getServletContext();
		CarService carService = (CarService) context.getAttribute(Resourcer.getString("parameter.carservice"));
		Car selectedCar = carService.getCar(carNumber);
		order.setCar(selectedCar);
		Set<Work> selectedWorks = WorkUtils.getSelectedWorks(request, carService);
		order.setWorks(selectedWorks);
		Set<SharePart> selectedShareParts = SharePartUtils.getSelectedShareParts(request, carService);
		order.setShareParts(selectedShareParts);
		carService.addOrder(order, order.getWorks(), order.getShareParts());
		HttpSession session = request.getSession();
		String login = session.getAttribute(Resourcer.getString("parameter.user.login")).toString();
		Client client = carService.getClient(login);
		Set<Order> orders = carService.getClientOrders(client);
		OrderUtils.setOrders(request, orders);
		return Resourcer.getString("path.page.client.orders");
	}

}
