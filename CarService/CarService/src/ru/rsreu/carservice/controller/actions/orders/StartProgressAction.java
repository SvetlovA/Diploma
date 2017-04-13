package ru.rsreu.carservice.controller.actions.orders;

import java.sql.SQLException;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import resources.Resourcer;
import ru.rsreu.carservice.controller.Action;
import ru.rsreu.carservice.controller.actions.utils.BaseUtils;
import ru.rsreu.carservice.controller.actions.utils.OrderUtils;
import ru.rsreu.carservice.model.bll.CarService;
import ru.rsreu.carservice.model.entities.Order;
import ru.rsreu.carservice.model.entities.WorkStatus;

public class StartProgressAction implements Action {

	@Override
	public String execute(HttpServletRequest request)
			throws SQLException, Exception {
		Order order = OrderUtils.parseOrder(request);
		order.setStatus(WorkStatus.InProgress);
		ServletContext context = request.getServletContext();
		CarService carService = (CarService) context.getAttribute(Resourcer.getString("parameter.carservice"));
		carService.updateOrder(order);
		return BaseUtils.getServletPath(Resourcer.getString("url.pattern.workerorders"), Resourcer.getString("action.getworkerorders"));
	}

	@Override
	public boolean isForward() {
		return false;
	}

}
