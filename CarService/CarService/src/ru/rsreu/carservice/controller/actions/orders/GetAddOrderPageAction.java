package ru.rsreu.carservice.controller.actions.orders;

import java.sql.SQLException;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import resources.Resourcer;
import ru.rsreu.carservice.controller.Action;
import ru.rsreu.carservice.controller.actions.utils.CarUtils;
import ru.rsreu.carservice.controller.actions.utils.SharePartUtils;
import ru.rsreu.carservice.controller.actions.utils.WorkUtils;
import ru.rsreu.carservice.model.bll.CarServiceBl;
import ru.rsreu.carservice.model.entities.Car;
import ru.rsreu.carservice.model.entities.Client;
import ru.rsreu.carservice.model.entities.SharePart;
import ru.rsreu.carservice.model.entities.Work;

public class GetAddOrderPageAction implements Action {

	@Override
	public String execute(HttpServletRequest request, CarServiceBl carServiceBl)
			throws SQLException, Exception {
		HttpSession session = request.getSession();
		String login = session.getAttribute(Resourcer.getString("parameter.user.login")).toString();
		Client client = carServiceBl.getClient(login);
		Set<Work> works = carServiceBl.getAllWorks();
		Set<SharePart> shareParts = carServiceBl.getAllShareParts();
		Set<Car> clientCras = carServiceBl.getClientCars(client);
		CarUtils.setCars(request, clientCras);
		WorkUtils.setWorks(request, works);
		SharePartUtils.setShareParts(request, shareParts);
		return Resourcer.getString("path.page.order.add");
	}

}
