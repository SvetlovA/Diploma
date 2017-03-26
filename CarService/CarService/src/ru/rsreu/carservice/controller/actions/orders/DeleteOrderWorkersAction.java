package ru.rsreu.carservice.controller.actions.orders;

import java.sql.SQLException;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import resources.Resourcer;
import ru.rsreu.carservice.controller.Action;
import ru.rsreu.carservice.controller.actions.utils.OrderUtils;
import ru.rsreu.carservice.model.bll.CarServiceBl;
import ru.rsreu.carservice.model.entities.Order;
import ru.rsreu.carservice.model.entities.Worker;

public class DeleteOrderWorkersAction implements Action {

	@Override
	public String execute(HttpServletRequest request, CarServiceBl carServiceBl) throws SQLException {
		Order order = OrderUtils.parseOrder(request);
		Set<Worker> selectedWorkers = OrderUtils.getSelectedWorkers(request, carServiceBl);
		carServiceBl.deleteOrderWorkers(order, selectedWorkers);
		OrderUtils.setOrders(request, carServiceBl.getAllOrders());
		return Resourcer.getString("path.page.all.orders");
	}

}
