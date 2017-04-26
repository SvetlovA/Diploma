package ru.rsreu.carservice.controller.actions.clients;


import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import resources.Resourcer;
import ru.rsreu.carservice.controller.Action;
import ru.rsreu.carservice.controller.RedirectType;
import ru.rsreu.carservice.controller.Url;
import ru.rsreu.carservice.controller.actions.utils.BaseUtils;
import ru.rsreu.carservice.controller.actions.utils.ClientUtils;
import ru.rsreu.carservice.model.bll.CarService;
import ru.rsreu.carservice.model.dal.exceptions.DataBaseException;
import ru.rsreu.carservice.model.entities.Client;

public class EditClientAction implements Action {

	@Override
	public Url execute(HttpServletRequest request) throws DataBaseException, Exception {
		Client client = ClientUtils.parseClient(request);
		ServletContext context = request.getServletContext();
		CarService carService = (CarService) context.getAttribute(Resourcer.getString("parameter.carservice"));
		carService.updateClient(client);
		return new Url(BaseUtils.createUrl(Resourcer.getString("url.pattern.adminclients"),
				Resourcer.getString("action.getallclients")), RedirectType.SEND_REDIRECT);
	}
}
