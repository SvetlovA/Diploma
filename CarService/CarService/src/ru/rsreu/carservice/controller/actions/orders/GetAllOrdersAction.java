package ru.rsreu.carservice.controller.actions.orders;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import resources.Resourcer;
import ru.rsreu.carservice.controller.Action;
import ru.rsreu.carservice.controller.actions.utils.OrderUtils;
import ru.rsreu.carservice.model.bll.CarServiceBl;

public class GetAllOrdersAction implements Action {
	
	@Override
	public String execute(HttpServletRequest request, CarServiceBl carServiceBl) throws SQLException {
		OrderUtils.setOrders(request, carServiceBl.getAllOrders());
		return Resourcer.getString("path.page.all.orders");
	}

}
