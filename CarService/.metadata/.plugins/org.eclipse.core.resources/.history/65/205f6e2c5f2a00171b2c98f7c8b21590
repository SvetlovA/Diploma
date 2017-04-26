package ru.rsreu.carservice.controller.actions.clients.cars;


import javax.servlet.http.HttpServletRequest;

import resources.Resourcer;
import ru.rsreu.carservice.controller.Action;
import ru.rsreu.carservice.controller.RedirectType;
import ru.rsreu.carservice.controller.Url;
import ru.rsreu.carservice.controller.actions.utils.BaseUtils;
import ru.rsreu.carservice.controller.actions.utils.CarUtils;
import ru.rsreu.carservice.controller.actions.utils.ClientUtils;
import ru.rsreu.carservice.model.dal.exceptions.DataBaseException;
import ru.rsreu.carservice.model.entities.Car;
import ru.rsreu.carservice.model.entities.Client;

public class GetDeleteCarPageAction implements Action {

	@Override
	public Url execute(HttpServletRequest request) throws DataBaseException {
		BaseUtils.setErrorMessage(request);
		Car car = CarUtils.parseCar(request);
		Client client = ClientUtils.parseClient(request);
		CarUtils.setCar(request, car);
		ClientUtils.setClient(request, client);
		return new Url(Resourcer.getString("path.page.car.delete"), RedirectType.FORWARD);
	}
}
