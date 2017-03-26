package ru.rsreu.carservice.controller.actions.utils;

import java.util.Set;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import ru.rsreu.carservice.model.entities.Worker;

public class WorkerUtils {
	
	private static final String WORKERS_ATTRIBUTE_NAME = "workers";
	private static final String EXPERIENCE_PARAMETER_NAME = "workerexperience";
	private static final String PATRONYMIC_PARAMETER_NAME = "workerpatronymic";
	private static final String NAME_PARAMETER_NAME = "workername";
	private static final String SURNAME_PARAMETER_NAME = "workersurname";
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
		String surname = request.getParameter(SURNAME_PARAMETER_NAME);
		worker.setSurname(surname);
		String name = request.getParameter(NAME_PARAMETER_NAME);
		worker.setName(name);
		String patronymic = request.getParameter(PATRONYMIC_PARAMETER_NAME);
		worker.setPatronymic(patronymic);
		int experience = Integer.parseInt(request.getParameter(EXPERIENCE_PARAMETER_NAME));
		worker.setExperience(experience);
		return worker;
	}
	
	public static void setWorker(HttpServletRequest request, Worker worker) {
		request.setAttribute(WORKERID_PARAMETER_NAME, request.getParameter(WORKERID_PARAMETER_NAME));
		request.setAttribute(WORKERGUID_PARAMETER_NAME, request.getParameter(WORKERGUID_PARAMETER_NAME));
		request.setAttribute(WORKERLOGIN_PARAMETER_NAME, request.getParameter(WORKERLOGIN_PARAMETER_NAME));
		request.setAttribute(SURNAME_PARAMETER_NAME, request.getParameter(SURNAME_PARAMETER_NAME));
		request.setAttribute(NAME_PARAMETER_NAME, request.getParameter(NAME_PARAMETER_NAME));
		request.setAttribute(PATRONYMIC_PARAMETER_NAME, request.getParameter(PATRONYMIC_PARAMETER_NAME));
		request.setAttribute(EXPERIENCE_PARAMETER_NAME, request.getParameter(EXPERIENCE_PARAMETER_NAME));
	}
	
	public static void setWorkers(HttpServletRequest request, Set<Worker> workers) {
		request.setAttribute(WORKERS_ATTRIBUTE_NAME, workers);
	}
}
