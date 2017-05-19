package ru.rsreu.carservice.controller.actions.clients.cars;


import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import resources.Resourcer;
import ru.rsreu.carservice.controller.Action;
import ru.rsreu.carservice.controller.RedirectType;
import ru.rsreu.carservice.controller.Url;
import ru.rsreu.carservice.controller.actions.utils.CarUtils;
import ru.rsreu.carservice.controller.actions.utils.ClientUtils;
import ru.rsreu.carservice.model.bll.CarService;
import ru.rsreu.carservice.model.dal.exceptions.DataBaseException;
import ru.rsreu.carservice.model.entities.Car;
import ru.rsreu.carservice.model.entities.Client;

public class DeleteCarAction implements Action {

	@Override
	public Url execute(HttpServletRequest request) throws DataBaseException, Exception {
		Car car = CarUtils.parseCar(request);
		ServletContext context = request.getServletContext();
		CarService carService = (CarService) context.getAttribute(Resourcer.getString("parameter.carservice"));
		carService.deleteCar(car);
		Client client = ClientUtils.parseClient(request);
		return new Url(ClientUtils.getUrl(Resourcer.getString("url.pattern.adminclientcars"),
				Resourcer.getString("action.getclientcarspage"), client), RedirectType.SEND_REDIRECT);
	}
}
