package ru.rsreu.carservice.controller.actions.utils;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import ru.rsreu.carservice.model.bll.CarService;
import ru.rsreu.carservice.model.dal.exceptions.DataBaseException;
import ru.rsreu.carservice.model.entities.Work;

public class WorkUtils {
	
	private static final String WORKS_ATTRIBUTE_NAME = "works";
	private static final String WORKDESCRIPTION_PARAMETER_NAME = "workdescription";
	private static final String WORKPRICE_PARAMETER_NAME = "workprice";
	private static final String WORKNAME_PARAMETER_NAME = "workname";
	private static final String WORKGUID_PARAMETER_NAME = "workguid";
	private static final String WORKID_PARAMETER_NAME = "workid";
	private static final String ISSELECTED_PARAMETER_NAME = "isselectedwork";
	
	private WorkUtils() {
	}
	
	public static Work parseWork(HttpServletRequest request) {
		Work work = new Work();
		int id = Integer.parseInt(request.getParameter(WORKID_PARAMETER_NAME));
		work.setWorkId(id);
		UUID guid = UUID.fromString(request.getParameter(WORKGUID_PARAMETER_NAME));
		work.setWorkGuid(guid);
		String name = request.getParameter(WORKNAME_PARAMETER_NAME);
		work.setName(name);
		double price = Double.parseDouble(request.getParameter(WORKPRICE_PARAMETER_NAME));
		work.setPrice(price);
		String description = request.getParameter(WORKDESCRIPTION_PARAMETER_NAME);
		work.setDescription(description);
		return work;
	}
	
	public static void setWork(HttpServletRequest request, Work work) {
		request.setAttribute(WORKID_PARAMETER_NAME, request.getParameter(WORKID_PARAMETER_NAME));
		request.setAttribute(WORKGUID_PARAMETER_NAME, request.getParameter(WORKGUID_PARAMETER_NAME));
		request.setAttribute(WORKNAME_PARAMETER_NAME, request.getParameter(WORKNAME_PARAMETER_NAME));
		request.setAttribute(WORKPRICE_PARAMETER_NAME, request.getParameter(WORKPRICE_PARAMETER_NAME));
		request.setAttribute(WORKDESCRIPTION_PARAMETER_NAME, request.getParameter(WORKDESCRIPTION_PARAMETER_NAME));
	}
	
	public static void setWorks(HttpServletRequest request, Set<Work> works) {
		request.setAttribute(WORKS_ATTRIBUTE_NAME, works);
	}
	
	public static Set<Work> getSelectedWorks(HttpServletRequest request, CarService carServiceBl) throws DataBaseException {
		Set<Work> selectedWorks = new HashSet<Work>();
		String[] selectedParameters = request.getParameterValues(ISSELECTED_PARAMETER_NAME);
		for (String parameter : selectedParameters) {
			UUID workGuid = UUID.fromString(parameter);
			Work work = carServiceBl.getWork(workGuid);
			selectedWorks.add(work);
		}
		return selectedWorks;
	}
	
	public static String getUrl(String urlPattern, String action, Work work) {
		StringBuilder servletPath = new StringBuilder(BaseUtils.createUrl(urlPattern, action));
		servletPath.append("&");
		servletPath.append(WORKID_PARAMETER_NAME);
		servletPath.append("=");
		servletPath.append(work.getWorkId());
		servletPath.append("&");
		servletPath.append(WORKGUID_PARAMETER_NAME);
		servletPath.append("=");
		servletPath.append(work.getWorkGuid());
		servletPath.append("&");
		servletPath.append(WORKNAME_PARAMETER_NAME);
		servletPath.append("=");
		servletPath.append(work.getName());
		servletPath.append("&");
		servletPath.append(WORKPRICE_PARAMETER_NAME);
		servletPath.append("=");
		servletPath.append(work.getPrice());
		servletPath.append("&");
		servletPath.append(WORKDESCRIPTION_PARAMETER_NAME);
		servletPath.append("=");
		servletPath.append(work.getDescription());
		return servletPath.toString();
	}
}
