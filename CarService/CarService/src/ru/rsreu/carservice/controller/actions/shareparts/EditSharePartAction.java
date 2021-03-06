package ru.rsreu.carservice.controller.actions.shareparts;


import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import resources.Resourcer;
import ru.rsreu.carservice.controller.Action;
import ru.rsreu.carservice.controller.RedirectType;
import ru.rsreu.carservice.controller.Url;
import ru.rsreu.carservice.controller.actions.utils.BaseUtils;
import ru.rsreu.carservice.controller.actions.utils.SharePartUtils;
import ru.rsreu.carservice.model.bll.CarService;
import ru.rsreu.carservice.model.dal.exceptions.DataBaseException;
import ru.rsreu.carservice.model.entities.SharePart;

public class EditSharePartAction implements Action {
	
	@Override
	public Url execute(HttpServletRequest request) throws DataBaseException, Exception {
		SharePart sharePart = SharePartUtils.parseSharePart(request);
		ServletContext context = request.getServletContext();
		CarService carService = (CarService) context.getAttribute(Resourcer.getString("parameter.carservice"));
		carService.updateSharePart(sharePart);
		return new Url(BaseUtils.createUrl(Resourcer.getString("url.pattern.adminshareparts"),
				Resourcer.getString("action.getallshareparts")), RedirectType.SEND_REDIRECT);
	}
}
