package ru.rsreu.carservice.controller.actions.orders;

import java.sql.SQLException;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import resources.Resourcer;
import ru.rsreu.carservice.controller.Action;
import ru.rsreu.carservice.controller.actions.utils.OrderUtils;
import ru.rsreu.carservice.model.bll.CarService;

public class GetAllOrdersAction implements Action {
	
	@Override
	public String execute(HttpServletRequest request) throws SQLException {
		ServletContext context = request.getServletContext();
		CarService carService = (CarService) context.getAttribute(Resourcer.getString("parameter.carservice"));
		OrderUtils.setOrders(request, carService.getAllOrders());
		return Resourcer.getString("path.page.all.orders");
	}

	@Override
	public boolean isForward() {
		return true;
	}

}
