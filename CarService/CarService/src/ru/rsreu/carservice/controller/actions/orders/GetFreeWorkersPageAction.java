package ru.rsreu.carservice.controller.actions.orders;

import java.sql.SQLException;
import javax.servlet.http.HttpServletRequest;

import resources.Resourcer;
import ru.rsreu.carservice.controller.Action;
import ru.rsreu.carservice.controller.actions.utils.OrderUtils;
import ru.rsreu.carservice.controller.actions.utils.WorkerUtils;
import ru.rsreu.carservice.model.bll.CarServiceBl;
import ru.rsreu.carservice.model.entities.Order;

public class GetFreeWorkersPageAction implements Action {

	@Override
	public String execute(HttpServletRequest request, CarServiceBl carServiceBl) throws SQLException {
		Order order = OrderUtils.parseOrder(request);
		OrderUtils.setOrder(request, order);
		WorkerUtils.setWorkers(request, carServiceBl.getFreeWorkers());
		return Resourcer.getString("path.page.free.workers");
	}

}
