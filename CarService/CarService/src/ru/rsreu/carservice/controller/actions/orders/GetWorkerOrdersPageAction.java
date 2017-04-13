package ru.rsreu.carservice.controller.actions.orders;

import java.sql.SQLException;
import java.util.Set;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import resources.Resourcer;
import ru.rsreu.carservice.controller.Action;
import ru.rsreu.carservice.controller.actions.utils.OrderUtils;
import ru.rsreu.carservice.model.bll.CarService;
import ru.rsreu.carservice.model.entities.Order;
import ru.rsreu.carservice.model.entities.Worker;

public class GetWorkerOrdersPageAction implements Action {

	@Override
	public String execute(HttpServletRequest request)
			throws SQLException, Exception {
		HttpSession session = request.getSession();
		String login = session.getAttribute(Resourcer.getString("parameter.user.login")).toString();
		ServletContext context = request.getServletContext();
		CarService carService = (CarService) context.getAttribute(Resourcer.getString("parameter.carservice"));
		Worker worker = carService.getWorker(login);
		Set<Order> workerOrders = carService.getWorkerOrders(worker);
		OrderUtils.setOrders(request, workerOrders);
		return Resourcer.getString("path.page.worker.orders");
	}

	@Override
	public boolean isForward() {
		return true;
	}

}
