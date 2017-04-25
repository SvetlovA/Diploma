package ru.rsreu.carservice.controller.actions.works;


import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import resources.Resourcer;
import ru.rsreu.carservice.controller.Action;
import ru.rsreu.carservice.controller.RedirectType;
import ru.rsreu.carservice.controller.Url;
import ru.rsreu.carservice.controller.actions.utils.BaseUtils;
import ru.rsreu.carservice.controller.actions.utils.WorkUtils;
import ru.rsreu.carservice.model.bll.CarService;
import ru.rsreu.carservice.model.dal.exceptions.DataBaseException;
import ru.rsreu.carservice.model.entities.Work;

public class EditWorkAction implements Action {

	@Override
	public Url execute(HttpServletRequest request) throws DataBaseException {
		Work work = WorkUtils.parseWork(request);
		ServletContext context = request.getServletContext();
		CarService carService = (CarService) context.getAttribute(Resourcer.getString("parameter.carservice"));
		carService.updateWork(work);
		return new Url(BaseUtils.createUrl(Resourcer.getString("url.pattern.adminworks"),
				Resourcer.getString("action.getallworks")), RedirectType.SEND_REDIRECT);
	}
}
