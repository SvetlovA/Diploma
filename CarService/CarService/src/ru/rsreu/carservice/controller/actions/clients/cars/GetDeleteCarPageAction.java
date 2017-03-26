package ru.rsreu.carservice.controller.actions.clients.cars;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import resources.Resourcer;
import ru.rsreu.carservice.controller.Action;
import ru.rsreu.carservice.controller.actions.utils.CarUtils;
import ru.rsreu.carservice.controller.actions.utils.ClientUtils;
import ru.rsreu.carservice.model.bll.CarServiceBl;
import ru.rsreu.carservice.model.entities.Car;
import ru.rsreu.carservice.model.entities.Client;

public class GetDeleteCarPageAction implements Action {

	@Override
	public String execute(HttpServletRequest request, CarServiceBl carServiceBl) throws SQLException {
		Car car = CarUtils.parseCar(request);
		Client client = ClientUtils.parseClient(request);
		CarUtils.setCar(request, car);
		ClientUtils.setClient(request, client);
		return Resourcer.getString("path.page.car.delete");
	}

}
