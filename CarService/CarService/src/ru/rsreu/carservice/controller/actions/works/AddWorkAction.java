package ru.rsreu.carservice.controller.actions.works;

import java.util.UUID;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import resources.Resourcer;
import ru.rsreu.carservice.controller.Action;
import ru.rsreu.carservice.controller.RedirectType;
import ru.rsreu.carservice.controller.Url;
import ru.rsreu.carservice.controller.actions.utils.BaseUtils;
import ru.rsreu.carservice.model.bll.CarService;
import ru.rsreu.carservice.model.dal.exceptions.DataBaseException;
import ru.rsreu.carservice.model.entities.Work;

public class AddWorkAction implements Action {
	private static final String WORKDESCRIPTION_PARAMETERNAME = "workdescription";
	private static final String WORKPRICE_PARAMETER_NAME = "workprice";
	private static final String WORKNAME_PARAMETER_NAME = "workname";

	@Override
	public Url execute(HttpServletRequest request) throws DataBaseException, Exception {
		Work work = new Work();
		work.setWorkGuid(UUID.randomUUID());
		String workName = request.getParameter(WORKNAME_PARAMETER_NAME);
		work.setName(workName);
		double workPrice = Double.parseDouble(request.getParameter(WORKPRICE_PARAMETER_NAME));
		work.setPrice(workPrice);
		String workDescription = request.getParameter(WORKDESCRIPTION_PARAMETERNAME);
		work.setDescription(workDescription);
		ServletContext context = request.getServletContext();
		CarService carService = (CarService) context.getAttribute(Resourcer.getString("parameter.carservice"));
		carService.addWork(work);
		return new Url(BaseUtils.createUrl(Resourcer.getString("url.pattern.adminworks"),
				Resourcer.getString("action.getallworks")), RedirectType.SEND_REDIRECT);
	}
}
