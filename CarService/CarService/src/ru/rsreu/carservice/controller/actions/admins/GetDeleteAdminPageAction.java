package ru.rsreu.carservice.controller.actions.admins;

import javax.servlet.http.HttpServletRequest;

import resources.Resourcer;
import ru.rsreu.carservice.controller.Action;
import ru.rsreu.carservice.controller.RedirectType;
import ru.rsreu.carservice.controller.Url;
import ru.rsreu.carservice.controller.actions.utils.BaseUtils;
import ru.rsreu.carservice.controller.actions.utils.UserUtils;
import ru.rsreu.carservice.model.dal.exceptions.DataBaseException;
import ru.rsreu.carservice.model.entities.User;

public class GetDeleteAdminPageAction implements Action {

	@Override
	public Url execute(HttpServletRequest request) throws DataBaseException,
			Exception {
		BaseUtils.setErrorMessage(request);
		User admin = UserUtils.parseUser(request);
		UserUtils.setUser(request, admin);
		return new Url(Resourcer.getString("path.page.delete.admin"), RedirectType.FORWARD);
	}
}
