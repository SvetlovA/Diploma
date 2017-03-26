package ru.rsreu.carservice.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import resources.Resourcer;
import ru.rsreu.carservice.model.bll.CarServiceBl;
import ru.rsreu.carservice.model.bll.Permission;

public class AutentificationFilter implements Filter {
	
	private CarServiceBl carServiceBl;
	
	@Override
	public void destroy() {
		this.carServiceBl = null;
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain filterChain) throws IOException, ServletException {
		HttpServletRequest servletRequest = (HttpServletRequest) request;
		String url = servletRequest.getRequestURI();
		HttpSession session = servletRequest.getSession();
		RequestDispatcher dispatcher = request.getRequestDispatcher(Resourcer.getString("path.page.index"));
		Object login = session.getAttribute(Resourcer.getString("parameter.user.login"));
		Object password = session.getAttribute(Resourcer.getString("parameter.usre.password"));
		Permission permission = (Permission) session.getAttribute(Resourcer.getString("parameter.user.permission"));
		if (login == null || password == null || permission == null) {
			dispatcher.forward(request, response);
			return;
		}
		try {
			if (!this.carServiceBl.checkAutentification(login.toString(), password.toString())) {
				dispatcher.forward(request, response);
				return;
			}
		} catch (SQLException e) {
			throw new ServletException(e);
		}
		if (!url.contains(permission.toString().toLowerCase())) {
			dispatcher.forward(request, response);
		}
		filterChain.doFilter(request, response);
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		try {
			this.carServiceBl = new CarServiceBl();
		} catch (SQLException e) {
			throw new ServletException(e);
		}
	}

}
