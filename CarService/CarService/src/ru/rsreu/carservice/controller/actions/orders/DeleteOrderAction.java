package ru.rsreu.carservice.controller.actions.orders;

import java.util.Set;

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
import ru.rsreu.carservice.model.entities.SharePart;
import ru.rsreu.carservice.model.entities.Work;
import ru.rsreu.carservice.model.entities.Worker;

public class DeleteOrderAction implements Action {

	@Override
	public Url execute(HttpServletRequest request) throws DataBaseException, Exception {
		Order order = OrderUtils.parseOrder(request);
		ServletContext context = request.getServletContext();
		CarService carService = (CarService) context.getAttribute(Resourcer.getString("parameter.carservice"));
		Set<Worker> workers = carService.getOrderWorkers(order);
		order.setWorkers(workers);
		Set<Work> works = carService.getOrderWorks(order);
		order.setWorks(works);
		Set<SharePart> shareParts = carService.getOrderShareParts(order);
		order.setShareParts(shareParts);
		carService.deleteOrder(order);
		return new Url(BaseUtils.createUrl(Resourcer.getString("url.pattern.adminorders"),
				Resourcer.getString("action.getallorders")), RedirectType.SEND_REDIRECT);
	}
}
