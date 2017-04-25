package ru.rsreu.carservice.controller.actions.utils;

import java.util.Set;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import ru.rsreu.carservice.model.entities.Worker;

public class WorkerUtils {
	
	private static final String WORKERS_ATTRIBUTE_NAME = "workers";
	private static final String WORKEREXPERIENCE_PARAMETER_NAME = "workerexperience";
	private static final String WORKERPATRONYMIC_PARAMETER_NAME = "workerpatronymic";
	private static final String WORKERNAME_PARAMETER_NAME = "workername";
	private static final String WORKERSURNAME_PARAMETER_NAME = "workersurname";
	private static final String WORKERLOGIN_PARAMETER_NAME = "workerlogin";
	private static final String WORKERGUID_PARAMETER_NAME = "workerguid";
	private static final String WORKERID_PARAMETER_NAME = "workerid";
	
	private WorkerUtils() {
	}
	
	public static Worker parseWorker(HttpServletRequest request) {
		Worker worker = new Worker();
		int id = Integer.parseInt(request.getParameter(WORKERID_PARAMETER_NAME));
		worker.setUserId(id);
		UUID guid = UUID.fromString(request.getParameter(WORKERGUID_PARAMETER_NAME));
		worker.setUserGuid(guid);
		String lgoin = request.getParameter(WORKERLOGIN_PARAMETER_NAME);
		worker.setLogin(lgoin);
		String surname = request.getParameter(WORKERSURNAME_PARAMETER_NAME);
		worker.setSurname(surname);
		String name = request.getParameter(WORKERNAME_PARAMETER_NAME);
		worker.setName(name);
		String patronymic = request.getParameter(WORKERPATRONYMIC_PARAMETER_NAME);
		worker.setPatronymic(patronymic);
		int experience = Integer.parseInt(request.getParameter(WORKEREXPERIENCE_PARAMETER_NAME));
		worker.setExperience(experience);
		return worker;
	}
	
	public static void setWorker(HttpServletRequest request, Worker worker) {
		request.setAttribute(WORKERID_PARAMETER_NAME, request.getParameter(WORKERID_PARAMETER_NAME));
		request.setAttribute(WORKERGUID_PARAMETER_NAME, request.getParameter(WORKERGUID_PARAMETER_NAME));
		request.setAttribute(WORKERLOGIN_PARAMETER_NAME, request.getParameter(WORKERLOGIN_PARAMETER_NAME));
		request.setAttribute(WORKERSURNAME_PARAMETER_NAME, request.getParameter(WORKERSURNAME_PARAMETER_NAME));
		request.setAttribute(WORKERNAME_PARAMETER_NAME, request.getParameter(WORKERNAME_PARAMETER_NAME));
		request.setAttribute(WORKERPATRONYMIC_PARAMETER_NAME, request.getParameter(WORKERPATRONYMIC_PARAMETER_NAME));
		request.setAttribute(WORKEREXPERIENCE_PARAMETER_NAME, request.getParameter(WORKEREXPERIENCE_PARAMETER_NAME));
	}
	
	public static void setWorkers(HttpServletRequest request, Set<Worker> workers) {
		request.setAttribute(WORKERS_ATTRIBUTE_NAME, workers);
	}
	
	public static String getUrl(String urlPattern, String action, Worker worker) {
		StringBuilder servletPath = new StringBuilder(BaseUtils.createUrl(urlPattern, action));
		servletPath.append("&");
		servletPath.append(WORKERID_PARAMETER_NAME);
		servletPath.append("=");
		servletPath.append(worker.getUserId());
		servletPath.append("&");
		servletPath.append(WORKERGUID_PARAMETER_NAME);
		servletPath.append("=");
		servletPath.append(worker.getUserGuid());
		servletPath.append("&");
		servletPath.append(WORKERLOGIN_PARAMETER_NAME);
		servletPath.append("=");
		servletPath.append(worker.getLogin());
		servletPath.append("&");
		servletPath.append(WORKERSURNAME_PARAMETER_NAME);
		servletPath.append("=");
		servletPath.append(worker.getSurname());
		servletPath.append("&");
		servletPath.append(WORKERNAME_PARAMETER_NAME);
		servletPath.append("=");
		servletPath.append(worker.getName());
		servletPath.append("&");
		servletPath.append(WORKERPATRONYMIC_PARAMETER_NAME);
		servletPath.append("=");
		servletPath.append(worker.getPatronymic());
		servletPath.append("&");
		servletPath.append(WORKEREXPERIENCE_PARAMETER_NAME);
		servletPath.append("=");
		servletPath.append(worker.getExperience());
		return servletPath.toString();
	}
}
