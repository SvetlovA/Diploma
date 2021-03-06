package ru.rsreu.carservice.controller.actions.orders;

import java.util.Set;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import resources.Resourcer;
import ru.rsreu.carservice.controller.Action;
import ru.rsreu.carservice.controller.RedirectType;
import ru.rsreu.carservice.controller.Url;
import ru.rsreu.carservice.controller.actions.utils.BaseUtils;
import ru.rsreu.carservice.controller.actions.utils.CarUtils;
import ru.rsreu.carservice.controller.actions.utils.SharePartUtils;
import ru.rsreu.carservice.controller.actions.utils.WorkUtils;
import ru.rsreu.carservice.model.bll.CarService;
import ru.rsreu.carservice.model.dal.exceptions.DataBaseException;
import ru.rsreu.carservice.model.entities.Car;
import ru.rsreu.carservice.model.entities.Client;
import ru.rsreu.carservice.model.entities.SharePart;
import ru.rsreu.carservice.model.entities.Work;

public class GetAddOrderPageAction implements Action {

	@Override
	public Url execute(HttpServletRequest request)
			throws DataBaseException, Exception {
		BaseUtils.setErrorMessage(request);
		HttpSession session = request.getSession();
		String login = session.getAttribute(Resourcer.getString("parameter.user.login")).toString();
		ServletContext context = request.getServletContext();
		CarService carService = (CarService) context.getAttribute(Resourcer.getString("parameter.carservice"));
		Client client = carService.getClient(login);
		Set<Work> works = carService.getAllWorks();
		Set<SharePart> shareParts = carService.getAllShareParts();
		Set<Car> clientCras = carService.getClientCars(client);
		CarUtils.setCars(request, clientCras);
		WorkUtils.setWorks(request, works);
		SharePartUtils.setShareParts(request, shareParts);
		return new Url(Resourcer.getString("path.page.order.add"), RedirectType.FORWARD);
	}
}
