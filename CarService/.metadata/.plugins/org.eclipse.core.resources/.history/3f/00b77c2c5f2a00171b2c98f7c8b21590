package ru.rsreu.carservice.controller.actions.orders;


import javax.servlet.http.HttpServletRequest;

import resources.Resourcer;
import ru.rsreu.carservice.controller.Action;
import ru.rsreu.carservice.controller.RedirectType;
import ru.rsreu.carservice.controller.Url;
import ru.rsreu.carservice.controller.actions.utils.BaseUtils;
import ru.rsreu.carservice.controller.actions.utils.OrderUtils;
import ru.rsreu.carservice.model.dal.exceptions.DataBaseException;
import ru.rsreu.carservice.model.entities.Order;

public class GetDeleteOrderPageAction implements Action {

	@Override
	public Url execute(HttpServletRequest request) throws DataBaseException {
		BaseUtils.setErrorMessage(request);
		Order order = OrderUtils.parseOrder(request);
		OrderUtils.setOrder(request, order);
		return new Url(Resourcer.getString("path.page.order.delete"), RedirectType.FORWARD);
	}
}
