package ru.rsreu.carservice.controller.actions.clients.cars;

import java.sql.SQLException;
import java.util.UUID;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import resources.Resourcer;
import ru.rsreu.carservice.controller.Action;
import ru.rsreu.carservice.controller.actions.utils.ClientUtils;
import ru.rsreu.carservice.model.bll.CarService;
import ru.rsreu.carservice.model.entities.Car;
import ru.rsreu.carservice.model.entities.Client;

public class AddCarAction implements Action {

	private static final String CARMODEL_PARAMETER_NAME = "carmodel";
	private static final String CARMARK_PARAMETER_NAME = "carmark";
	private static final String CARSTATENUMBER_PARAMETER_NAME = "carstatenumber";

	@Override
	public String execute(HttpServletRequest request) throws SQLException {
		Car car = new Car();
		UUID carGuid = UUID.randomUUID();
		car.setCarGuid(carGuid);
		String stateNumber = request.getParameter(CARSTATENUMBER_PARAMETER_NAME);
		car.setNumber(stateNumber);
		String carMark = request.getParameter(CARMARK_PARAMETER_NAME);
		car.setMark(carMark);
		String carModel = request.getParameter(CARMODEL_PARAMETER_NAME);
		car.setModel(carModel);
		Client client = ClientUtils.parseClient(request);
		car.setClient(client);
		ServletContext context = request.getServletContext();
		CarService carService = (CarService) context.getAttribute(Resourcer.getString("parameter.carservice"));
		carService.addCar(car);
		return ClientUtils.getServletPath(Resourcer.getString("url.pattern.admincars"), Resourcer.getString("action.getclientcarspage"), client);
	}

	@Override
	public boolean isForward() {
		return false;
	}
	
}
