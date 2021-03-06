package ru.rsreu.carservice.controller.actions.utils;

import java.util.Set;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import ru.rsreu.carservice.model.entities.Client;

public class ClientUtils {
	
	private static final String CLIENTS_ATTRIBUTE_NAME = "clients";
	private static final String CLIENTGUID_PARAMETER_NAME = "clientguid";
	private static final String CLIENTPATRONYMIC_PARAMETER_NAME = "clientpatronymic";
	private static final String CLIENTNAME_PARAMETER_NAME = "clientname";
	private static final String CLIENTSURNAME_PARAMETER_NAME = "clientsurname";
	private static final String CLIENTLOGIN_PARAMETER_NAME = "clientlogin";
	private static final String CLIENTID_PARAMETER_NAME = "clientid";
	
	private ClientUtils() {
	}
	
	public static Client parseClient(HttpServletRequest request) {
		Client client = new Client();
		int clientId = Integer.parseInt(request.getParameter(CLIENTID_PARAMETER_NAME));
		client.setUserId(clientId);
		UUID clientGuid = UUID.fromString(request.getParameter(CLIENTGUID_PARAMETER_NAME));
		client.setUserGuid(clientGuid);
		String clientLogin = request.getParameter(CLIENTLOGIN_PARAMETER_NAME);
		client.setLogin(clientLogin);
		String clientSurname = request.getParameter(CLIENTSURNAME_PARAMETER_NAME);
		client.setSurname(clientSurname);
		String clientName = request.getParameter(CLIENTNAME_PARAMETER_NAME);
		client.setName(clientName);
		String clientPatronymic = request.getParameter(CLIENTPATRONYMIC_PARAMETER_NAME);
		client.setPatronymic(clientPatronymic);
		return client;
	}
	
	public static void setClient(HttpServletRequest request, Client client) {
		request.setAttribute(CLIENTID_PARAMETER_NAME, client.getUserId());
		request.setAttribute(CLIENTGUID_PARAMETER_NAME, client.getUserGuid());
		request.setAttribute(CLIENTLOGIN_PARAMETER_NAME, client.getLogin());
		request.setAttribute(CLIENTSURNAME_PARAMETER_NAME, client.getSurname());
		request.setAttribute(CLIENTNAME_PARAMETER_NAME, client.getName());
		request.setAttribute(CLIENTPATRONYMIC_PARAMETER_NAME, client.getPatronymic());
	}
	
	public static void setClients(HttpServletRequest request, Set<Client> clients) {
		request.setAttribute(CLIENTS_ATTRIBUTE_NAME, clients);
	}
	
	public static String getUrl(String urlPattern, String action, Client client) {
		StringBuilder servletPath = new StringBuilder(BaseUtils.createUrl(urlPattern, action));
		servletPath.append("&");
		servletPath.append(CLIENTID_PARAMETER_NAME);
		servletPath.append("=");
		servletPath.append(client.getUserId());
		servletPath.append("&");
		servletPath.append(CLIENTGUID_PARAMETER_NAME);
		servletPath.append("=");
		servletPath.append(client.getUserGuid());
		servletPath.append("&");
		servletPath.append(CLIENTLOGIN_PARAMETER_NAME);
		servletPath.append("=");
		servletPath.append(client.getLogin());
		servletPath.append("&");
		servletPath.append(CLIENTSURNAME_PARAMETER_NAME);
		servletPath.append("=");
		servletPath.append(client.getSurname());
		servletPath.append("&");
		servletPath.append(CLIENTNAME_PARAMETER_NAME);
		servletPath.append("=");
		servletPath.append(client.getName());
		servletPath.append("&");
		servletPath.append(CLIENTPATRONYMIC_PARAMETER_NAME);
		servletPath.append("=");
		servletPath.append(client.getPatronymic());
		return servletPath.toString();
	}
}
