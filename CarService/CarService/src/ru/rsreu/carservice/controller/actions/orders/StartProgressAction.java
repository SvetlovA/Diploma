package ru.rsreu.carservice.controller.actions.orders;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import resources.Resourcer;
import ru.rsreu.carservice.controller.Action;
import ru.rsreu.carservice.controller.RedirectType;
import ru.rsreu.carservice.controller.Url;
import ru.rsreu.carservice.controller.actions.utils.BaseUtils;
import ru.rsreu.carservice.controller.actions.utils.OrderUtils;
import ru.rsreu.carservice.model.bll.CarService;
import ru.rsreu.carservice.model.dal.exceptions.DataBaseException;
import ru.rsreu.carservice.model.entities.Order;
import ru.rsreu.carservice.model.entities.WorkStatus;

public class StartProgressAction implements Action {

	@Override
	public Url execute(HttpServletRequest request)
			throws Exception, DataBaseException {
		BaseUtils.setErrorMessage(request);
		Order order = OrderUtils.parseOrder(request);
		order.setStatus(WorkStatus.InProgress);
		ServletContext context = request.getServletContext();
		CarService carService = (CarService) context.getAttribute(Resourcer.getString("parameter.carservice"));
		carService.updateOrder(order);
		return new Url(BaseUtils.createUrl(Resourcer.getString("url.pattern.workerorders"),
				Resourcer.getString("action.getworkerorders")), RedirectType.SEND_REDIRECT);
	}
}
