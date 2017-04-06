package ru.rsreu.carservice.controller.actions.orders;

import java.sql.SQLException;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import resources.Resourcer;
import ru.rsreu.carservice.controller.Action;
import ru.rsreu.carservice.controller.actions.utils.OrderUtils;
import ru.rsreu.carservice.controller.actions.utils.WorkerUtils;
import ru.rsreu.carservice.model.bll.CarService;
import ru.rsreu.carservice.model.entities.Order;

public class GetFreeWorkersPageAction implements Action {

	@Override
	public String execute(HttpServletRequest request) throws SQLException {
		Order order = OrderUtils.parseOrder(request);
		OrderUtils.setOrder(request, order);
		ServletContext context = request.getServletContext();
		CarService carService = (CarService) context.getAttribute(Resourcer.getString("parameter.carservice"));
		WorkerUtils.setWorkers(request, carService.getFreeWorkers());
		return Resourcer.getString("path.page.free.workers");
	}

}
