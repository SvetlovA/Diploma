package ru.rsreu.carservice.controller.actions.shareparts;

import java.sql.SQLException;
import java.util.UUID;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import resources.Resourcer;
import ru.rsreu.carservice.controller.Action;
import ru.rsreu.carservice.controller.actions.utils.BaseUtils;
import ru.rsreu.carservice.model.bll.CarService;
import ru.rsreu.carservice.model.entities.SharePart;

public class AddSharePartAction implements Action {

	private static final String SHAREPARTDESCRIPTION_PARAMETER_NAME = "sharepartdescription";
	private static final String SHAREPARTCOUNT_PARAMETER_NAME = "sharepartcount";
	private static final String SHAREPARTPRICE_PARAMETER_NAME = "sharepartprice";
	private static final String SHAREPARTNAME_PARAMETER_NAME = "sharepartname";

	@Override
	public String execute(HttpServletRequest request) throws SQLException {
		SharePart sharePart = new SharePart();
		UUID sharePartGuid = UUID.randomUUID();
		sharePart.setSharePartGuid(sharePartGuid);
		String sharePartName = request.getParameter(SHAREPARTNAME_PARAMETER_NAME);
		sharePart.setName(sharePartName);
		double sharePartPrice = Double.parseDouble(request.getParameter(SHAREPARTPRICE_PARAMETER_NAME));
		sharePart.setPrice(sharePartPrice);
		int sharePartCount = Integer.parseInt(request.getParameter(SHAREPARTCOUNT_PARAMETER_NAME));
		sharePart.setCount(sharePartCount);
		String sharePartDescription = request.getParameter(SHAREPARTDESCRIPTION_PARAMETER_NAME);
		sharePart.setDescription(sharePartDescription);
		ServletContext context = request.getServletContext();
		CarService carService = (CarService) context.getAttribute(Resourcer.getString("parameter.carservice"));
		carService.addSharePart(sharePart);
		return BaseUtils.getServletPath(Resourcer.getString("url.pattern.adminshareparts"), Resourcer.getString("action.getallshareparts"));
	}

	@Override
	public boolean isForward() {
		return false;
	}

}
