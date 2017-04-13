package ru.rsreu.carservice.controller.actions.shareparts;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import resources.Resourcer;
import ru.rsreu.carservice.controller.Action;
import ru.rsreu.carservice.controller.actions.utils.SharePartUtils;
import ru.rsreu.carservice.model.entities.SharePart;

public class GetEditSharePartPageAction implements Action {
	
	@Override
	public String execute(HttpServletRequest request) throws SQLException {
		SharePart sharePart = SharePartUtils.parseSharePart(request);
		SharePartUtils.setSharePart(request, sharePart);
		return Resourcer.getString("path.page.sharepart.edit");
	}

	@Override
	public boolean isForward() {
		return true;
	}
}
