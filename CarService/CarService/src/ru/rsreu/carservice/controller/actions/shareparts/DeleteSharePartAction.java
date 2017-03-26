package ru.rsreu.carservice.controller.actions.shareparts;

import java.sql.SQLException;
import javax.servlet.http.HttpServletRequest;
import resources.Resourcer;
import ru.rsreu.carservice.controller.Action;
import ru.rsreu.carservice.controller.actions.utils.SharePartUtils;
import ru.rsreu.carservice.model.bll.CarServiceBl;
import ru.rsreu.carservice.model.entities.SharePart;

public class DeleteSharePartAction implements Action {

	@Override
	public String execute(HttpServletRequest request, CarServiceBl carServiceBl) throws SQLException {
		SharePart sharePart = SharePartUtils.parseSharePart(request);
		carServiceBl.deleteSharePart(sharePart);
		SharePartUtils.setShareParts(request, carServiceBl.getAllShareParts());
		return Resourcer.getString("path.page.all.shareparts");
	}
}
