package ru.rsreu.carservice.controller.actions.shareparts;


import javax.servlet.http.HttpServletRequest;

import resources.Resourcer;
import ru.rsreu.carservice.controller.Action;
import ru.rsreu.carservice.controller.RedirectType;
import ru.rsreu.carservice.controller.Url;
import ru.rsreu.carservice.controller.actions.utils.BaseUtils;
import ru.rsreu.carservice.model.dal.exceptions.DataBaseException;

public class GetAddSharePartPageAction implements Action {

	@Override
	public Url execute(HttpServletRequest request) throws DataBaseException, Exception {
		BaseUtils.setErrorMessage(request);
		return new Url(Resourcer.getString("path.page.sharepart.add"), RedirectType.FORWARD);
	}
}
