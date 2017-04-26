package ru.rsreu.carservice.controller.actions.shareparts;


import javax.servlet.http.HttpServletRequest;

import resources.Resourcer;
import ru.rsreu.carservice.controller.Action;
import ru.rsreu.carservice.controller.RedirectType;
import ru.rsreu.carservice.controller.Url;
import ru.rsreu.carservice.controller.actions.utils.BaseUtils;
import ru.rsreu.carservice.controller.actions.utils.SharePartUtils;
import ru.rsreu.carservice.model.dal.exceptions.DataBaseException;
import ru.rsreu.carservice.model.entities.SharePart;

public class GetEditSharePartPageAction implements Action {
	
	@Override
	public Url execute(HttpServletRequest request) throws DataBaseException, Exception {
		BaseUtils.setErrorMessage(request);
		SharePart sharePart = SharePartUtils.parseSharePart(request);
		SharePartUtils.setSharePart(request, sharePart);
		return new Url(Resourcer.getString("path.page.sharepart.edit"), RedirectType.FORWARD);
	}
}
