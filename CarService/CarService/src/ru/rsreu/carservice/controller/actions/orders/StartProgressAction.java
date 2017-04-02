package ru.rsreu.carservice.controller.actions.orders;

import java.sql.SQLException;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import resources.Resourcer;
import ru.rsreu.carservice.controller.Action;
import ru.rsreu.carservice.controller.actions.utils.OrderUtils;
import ru.rsreu.carservice.model.bll.CarServiceBl;
import ru.rsreu.carservice.model.entities.Order;
import ru.rsreu.carservice.model.entities.WorkStatus;
import ru.rsreu.carservice.model.entities.Worker;

public class StartProgressAction implements Action {

	@Override
	public String execute(HttpServletRequest request, CarServiceBl carServiceBl)
			throws SQLException, Exception {
		Order order = OrderUtils.parseOrder(request);
		order.setStatus(WorkStatus.InProgress);
		carServiceBl.updateOrder(order);
		HttpSession session = request.getSession();
		String login = session.getAttribute(Resourcer.getString("parameter.user.login")).toString();
		Worker worker = carServiceBl.getWorker(login);
		Set<Order> workerOrders = carServiceBl.getWorkerOrders(worker);
		OrderUtils.setOrders(request, workerOrders);
		return Resourcer.getString("path.page.worker.orders");
	}

}
