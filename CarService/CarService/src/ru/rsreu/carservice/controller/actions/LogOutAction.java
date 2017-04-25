package ru.rsreu.carservice.controller.actions;


import javax.servlet.http.HttpServletRequest;

import resources.Resourcer;
import ru.rsreu.carservice.controller.Action;
import ru.rsreu.carservice.controller.RedirectType;
import ru.rsreu.carservice.controller.Url;
import ru.rsreu.carservice.model.dal.exceptions.DataBaseException;

public class LogOutAction implements Action {

	@Override
	public Url execute(HttpServletRequest request) throws DataBaseException {
		request.getSession().invalidate();
		return new Url(Resourcer.getString("path.page.index"), RedirectType.FORWARD);
	}
}
