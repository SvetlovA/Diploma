package ru.rsreu.carservice.controller.actions.workers;

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
import ru.rsreu.carservice.model.entities.Worker;

public class AddWorkerAction implements Action {

	private static final String EXPERIENCE_PARAMETER_NAME = "workerexperience";
	private static final String PATRONYMIC_PARAMETER_NAME = "workerpatronymic";
	private static final String NAME_PARAMETER_NAME = "workername";
	private static final String SURNAME_PARAMETER_NAME = "workersurname";
	private static final String PASSWORD_PARAMETER_NAME = "workerpassword";
	private static final String LOGIN_PARMETER_NAME = "workerlogin";

	@Override
	public Url execute(HttpServletRequest request) throws DataBaseException, Exception {
		Worker worker = new Worker();
		worker.setUserGuid(UUID.randomUUID());
		worker.setLogin(request.getParameter(LOGIN_PARMETER_NAME));
		worker.setSurname(request.getParameter(SURNAME_PARAMETER_NAME));
		worker.setName(request.getParameter(NAME_PARAMETER_NAME));
		worker.setPatronymic(request.getParameter(PATRONYMIC_PARAMETER_NAME));
		worker.setExperience(Integer.parseInt(request.getParameter(EXPERIENCE_PARAMETER_NAME)));
		String password = request.getParameter(PASSWORD_PARAMETER_NAME);
		ServletContext context = request.getServletContext();
		CarService carService = (CarService) context.getAttribute(Resourcer.getString("parameter.carservice"));
		carService.addAccount(worker, password);
		return new Url(BaseUtils.createUrl(Resourcer.getString("url.pattern.adminworkers"),
				Resourcer.getString("action.getallworkers")), RedirectType.SEND_REDIRECT);
	}
}
