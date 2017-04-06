package ru.rsreu.carservice.controller.actions.orders;

import java.sql.SQLException;
import java.util.Set;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import resources.Resourcer;
import ru.rsreu.carservice.controller.Action;
import ru.rsreu.carservice.controller.actions.utils.OrderUtils;
import ru.rsreu.carservice.model.bll.CarService;
import ru.rsreu.carservice.model.entities.Order;
import ru.rsreu.carservice.model.entities.Worker;

public class AddOrderWorkersAction implements Action {

	@Override
	public String execute(HttpServletRequest request) throws SQLException {
		ServletContext context = request.getServletContext();
		CarService carService = (CarService) context.getAttribute(Resourcer.getString("parameter.carservice"));
		Set<Worker> selectedWorkers = OrderUtils.getSelectedWorkers(request, carService);
		Order order = OrderUtils.parseOrder(request);
		carService.addOrderWorkers(order, selectedWorkers);
		OrderUtils.setOrders(request, carService.getAllOrders());
		return Resourcer.getString("path.page.all.orders");
	}
}
