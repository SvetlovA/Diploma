package ru.rsreu.carservice.controller.actions.clients;


import javax.servlet.http.HttpServletRequest;

import resources.Resourcer;
import ru.rsreu.carservice.controller.Action;
import ru.rsreu.carservice.controller.RedirectType;
import ru.rsreu.carservice.controller.Url;
import ru.rsreu.carservice.controller.actions.utils.BaseUtils;
import ru.rsreu.carservice.controller.actions.utils.ClientUtils;
import ru.rsreu.carservice.model.dal.exceptions.DataBaseException;
import ru.rsreu.carservice.model.entities.Client;

public class GetDeleteClientPageAction implements Action {

	@Override
	public Url execute(HttpServletRequest request) throws DataBaseException {
		BaseUtils.setErrorMessage(request);
		Client client = ClientUtils.parseClient(request);
		ClientUtils.setClient(request, client);
		return new Url(Resourcer.getString("path.page.client.delete"), RedirectType.FORWARD);
	}
}
