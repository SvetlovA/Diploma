package ru.rsreu.carservice.controller.actions.clients;

import java.util.UUID;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import resources.Resourcer;
import ru.rsreu.carservice.controller.Action;
import ru.rsreu.carservice.controller.RedirectType;
import ru.rsreu.carservice.controller.Url;
import ru.rsreu.carservice.controller.actions.utils.BaseUtils;
import ru.rsreu.carservice.model.bll.CarService;
import ru.rsreu.carservice.model.dal.exceptions.DataBaseException;
import ru.rsreu.carservice.model.entities.Client;

public class AddClientAction implements Action {
	
	private static final String CLIENTPASSWORD_PARAMETER_NAME = "clientpassword";
	private static final String CLIENTPATRONYMIC_PARAMETER_NAME = "clientpatronymic";
	private static final String CLIENTNAME_PARAMETER_NAME = "clientname";
	private static final String CLIENTSURNAME_PARAMETER_NAME = "clientsurname";
	private static final String CLIENTLOGIN_PARAMETER_NAME = "clientlogin";

	@Override
	public Url execute(HttpServletRequest request) throws DataBaseException, Exception {
		Client client = new Client();
		UUID clientGuid = UUID.randomUUID();
		client.setUserGuid(clientGuid);
		String clientLogin = request.getParameter(CLIENTLOGIN_PARAMETER_NAME);
		client.setLogin(clientLogin);
		String clientSurname = request.getParameter(CLIENTSURNAME_PARAMETER_NAME);
		client.setSurname(clientSurname);
		String clientName = request.getParameter(CLIENTNAME_PARAMETER_NAME);
		client.setName(clientName);
		String clientPatronymic = request.getParameter(CLIENTPATRONYMIC_PARAMETER_NAME);
		client.setPatronymic(clientPatronymic);
		String clientPassword = request.getParameter(CLIENTPASSWORD_PARAMETER_NAME);
		ServletContext context = request.getServletContext();
		CarService carService = (CarService) context.getAttribute(Resourcer.getString("parameter.carservice"));
		carService.addAccount(client, clientPassword);
		return new Url(BaseUtils.createUrl(Resourcer.getString("url.pattern.adminclients"),
				Resourcer.getString("action.getallclients")), RedirectType.SEND_REDIRECT);
	}
}
