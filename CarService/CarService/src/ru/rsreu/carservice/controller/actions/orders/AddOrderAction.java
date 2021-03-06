package ru.rsreu.carservice.controller.actions.orders;

import java.util.Set;
import java.util.UUID;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import resources.Resourcer;
import ru.rsreu.carservice.controller.Action;
import ru.rsreu.carservice.controller.RedirectType;
import ru.rsreu.carservice.controller.Url;
import ru.rsreu.carservice.controller.actions.utils.BaseUtils;
import ru.rsreu.carservice.controller.actions.utils.SharePartUtils;
import ru.rsreu.carservice.controller.actions.utils.WorkUtils;
import ru.rsreu.carservice.model.bll.CarService;
import ru.rsreu.carservice.model.dal.exceptions.DataBaseException;
import ru.rsreu.carservice.model.entities.Car;
import ru.rsreu.carservice.model.entities.Order;
import ru.rsreu.carservice.model.entities.SharePart;
import ru.rsreu.carservice.model.entities.Work;

public class AddOrderAction implements Action {

	private static final String SELECTED_CAR_PARAMETER_NAME = "selectedCar";

	@Override
	public Url execute(HttpServletRequest request)
			throws DataBaseException, Exception {
		Order order = new Order();
		UUID orderGuid = UUID.randomUUID();
		order.setOrderGuid(orderGuid);
		String carNumber = request.getParameter(SELECTED_CAR_PARAMETER_NAME);
		ServletContext context = request.getServletContext();
		CarService carService = (CarService) context.getAttribute(Resourcer.getString("parameter.carservice"));
		Car selectedCar = carService.getCar(carNumber);
		order.setCar(selectedCar);
		Set<Work> selectedWorks = WorkUtils.getSelectedWorks(request, carService);
		order.setWorks(selectedWorks);
		Set<SharePart> selectedShareParts = SharePartUtils.getSelectedShareParts(request, carService);
		order.setShareParts(selectedShareParts);
		carService.addOrder(order, order.getWorks(), order.getShareParts());
		return new Url(BaseUtils.createUrl(Resourcer.getString("url.pattern.clientorders"),
				Resourcer.getString("action.getclientorders")), RedirectType.SEND_REDIRECT);
	}
}
