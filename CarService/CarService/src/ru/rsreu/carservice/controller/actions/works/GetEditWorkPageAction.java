package ru.rsreu.carservice.controller.actions.works;


import javax.servlet.http.HttpServletRequest;

import resources.Resourcer;
import ru.rsreu.carservice.controller.Action;
import ru.rsreu.carservice.controller.RedirectType;
import ru.rsreu.carservice.controller.Url;
import ru.rsreu.carservice.controller.actions.utils.BaseUtils;
import ru.rsreu.carservice.controller.actions.utils.WorkUtils;
import ru.rsreu.carservice.model.dal.exceptions.DataBaseException;
import ru.rsreu.carservice.model.entities.Work;

public class GetEditWorkPageAction implements Action {

	@Override
	public Url execute(HttpServletRequest request) throws DataBaseException {
		BaseUtils.setErrorMessage(request);
		Work work = WorkUtils.parseWork(request);
		WorkUtils.setWork(request, work);
		return new Url(Resourcer.getString("path.page.work.edit"), RedirectType.FORWARD);
	}
}
