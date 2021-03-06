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
import ru.rsreu.carservice.model.entities.Order;
import ru.rsreu.carservice.model.entities.Worker;

public class GetWorkerOrdersPageAction implements Action {

	@Override
	public Url execute(HttpServletRequest request)
			throws DataBaseException, Exception {
		BaseUtils.setErrorMessage(request);
		HttpSession session = request.getSession();
		String login = session.getAttribute(Resourcer.getString("parameter.user.login")).toString();
		ServletContext context = request.getServletContext();
		CarService carService = (CarService) context.getAttribute(Resourcer.getString("parameter.carservice"));
		Worker worker = carService.getWorker(login);
		Set<Order> workerOrders = carService.getWorkerOrders(worker);
		OrderUtils.setOrders(request, workerOrders);
		return new Url(Resourcer.getString("path.page.worker.orders"), RedirectType.FORWARD);
	}
}
