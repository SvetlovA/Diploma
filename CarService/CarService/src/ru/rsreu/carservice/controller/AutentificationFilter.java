package ru.rsreu.carservice.controller;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import resources.Resourcer;
import ru.rsreu.carservice.controller.actions.utils.BaseUtils;
import ru.rsreu.carservice.model.bll.CarService;
import ru.rsreu.carservice.model.bll.Permission;
import ru.rsreu.carservice.model.dal.exceptions.DataBaseException;

public class AutentificationFilter implements Filter {
	
	private static final String SERVLET_PATH_SEPARATOR = "_";

	/**
	 * Destroy filter
	 */
	@Override
	public void destroy() {
	}

	/**
	 * Main filter logic
	 */
	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain filterChain) throws IOException, ServletException {
		HttpServletRequest servletRequest = (HttpServletRequest) request;
		HttpServletResponse servletResponse = (HttpServletResponse) response;
		HttpSession session = servletRequest.getSession();
		ServletContext context = servletRequest.getServletContext();
		CarService carService = (CarService) context.getAttribute(Resourcer.getString("parameter.carservice"));
		Object login = session.getAttribute(Resourcer.getString("parameter.user.login"));
		Object password = session.getAttribute(Resourcer.getString("parameter.user.password"));
		Permission permission = (Permission) session.getAttribute(Resourcer.getString("parameter.user.permission"));
		if (login == null || password == null || permission == null) {
			System.out.println("Login or password or permission are null...");
			servletResponse.sendRedirect(Resourcer.getString("path.page.start"));
			return;
		}
		try {
			if (!carService.checkAutentification(login.toString(), password.toString())) {
				System.out.println("Autentification failed...");
				servletResponse.sendRedirect(BaseUtils.createUrl(Resourcer.getString("url.pattern.login"),
						Resourcer.getString("action.logout")));
				return;
			}
		} catch (DataBaseException ex) {
			throw new ServletException(ex);
		}
		String currentPermission = getPermission(servletRequest.getServletPath());
		System.out.println(currentPermission);
		if (!currentPermission.contains(permission.toString().toLowerCase())) {
			System.out.println("No permission");
			servletResponse.sendRedirect(BaseUtils.createUrl(Resourcer.getString("url.pattern.login"),
					Resourcer.getString("action.logout")));
			return;
		}
		System.out.println("Filter work correct...");
		filterChain.doFilter(request, response);
	}
	
	private String getPermission(String servletPath) {
		String[] servletPathParts = servletPath.split(SERVLET_PATH_SEPARATOR);
		StringBuilder permission = new StringBuilder();
		for (int i = 0; i < servletPathParts.length - 1; i++) {
			permission.append(servletPathParts[i]);
		}
		return permission.toString();
	}

	/**
	 * Init filter
	 */
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
	}

}
