package ru.rsreu.carservice.controller.actions.works;


import javax.servlet.http.HttpServletRequest;

import resources.Resourcer;
import ru.rsreu.carservice.controller.Action;
import ru.rsreu.carservice.controller.RedirectType;
import ru.rsreu.carservice.controller.Url;
import ru.rsreu.carservice.controller.actions.utils.BaseUtils;
import ru.rsreu.carservice.model.dal.exceptions.DataBaseException;

public class GetAddWorkPageAction implements Action {
	@Override
	public Url execute(HttpServletRequest request) throws DataBaseException {
		BaseUtils.setErrorMessage(request);
		BaseUtils.setErrorMessage(request);
		return new Url(Resourcer.getString("path.page.work.add"), RedirectType.FORWARD);
	}
}
