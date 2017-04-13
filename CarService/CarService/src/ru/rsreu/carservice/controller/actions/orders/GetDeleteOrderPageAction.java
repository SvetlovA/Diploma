package ru.rsreu.carservice.controller.actions.orders;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import resources.Resourcer;
import ru.rsreu.carservice.controller.Action;
import ru.rsreu.carservice.controller.actions.utils.OrderUtils;
import ru.rsreu.carservice.model.entities.Order;

public class GetDeleteOrderPageAction implements Action {

	@Override
	public String execute(HttpServletRequest request) throws SQLException {
		Order order = OrderUtils.parseOrder(request);
		OrderUtils.setOrder(request, order);
		return Resourcer.getString("path.page.order.delete");
	}

	@Override
	public boolean isForward() {
		return true;
	}

}
