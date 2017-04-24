package ru.rsreu.carservice.controller;

import java.io.IOException;
import java.sql.SQLException;

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
import ru.rsreu.carservice.model.bll.CarService;
import ru.rsreu.carservice.model.bll.Permission;

public class AutentificationFilter implements Filter {
	
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
		String url = servletRequest.getRequestURI();
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
				servletResponse.sendRedirect(Resourcer.getString("path.page.start"));
				return;
			}
		} catch (SQLException e) {
			throw new ServletException(e);
		}
		if (!url.contains(permission.toString().toLowerCase())) {
			System.out.println("No permission");
			servletResponse.sendRedirect(Resourcer.getString("path.page.start"));
		}
		System.out.println("Filter work correct...");
		filterChain.doFilter(request, response);
	}

	/**
	 * Init filter
	 */
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
	}

}
