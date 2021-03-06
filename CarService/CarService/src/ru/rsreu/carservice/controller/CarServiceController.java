package ru.rsreu.carservice.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import resources.Resourcer;
import ru.rsreu.carservice.controller.actions.utils.BaseUtils;
import ru.rsreu.carservice.model.bll.CarService;
import ru.rsreu.carservice.model.dal.exceptions.DataBaseException;

public class CarServiceController extends HttpServlet {
	
	private static final String REFERER = "referer";
	
	private ActionFactory client;
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * Constructor of controller
	 * @throws SQLException
	 */
	public CarServiceController() throws SQLException {
		this.client = new ActionFactory();
	}
	
	@Override
	public void init() throws ServletException {
		super.init();
		ServletContext context = getServletContext();
		try {
			context.setAttribute(Resourcer.getString("parameter.carservice"), new CarService());
		} catch (SQLException e) {
			throw new ServletException(e);
		}
	}

	/**
	 * Get method
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processRequest(request, response);
	}
	
	/**
	 * Post method
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processRequest(request, response);
	}
	
	/**
	 * Process request
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Action action = this.client.getAction(request);
		Url url;
		try {
			url = action.execute(request);
		} catch (DataBaseException ex) {
			String previousUrl = request.getHeader(REFERER);
			url = new Url(BaseUtils.createErrorUrl(previousUrl, ex.getMessage()), RedirectType.SEND_REDIRECT);
		} catch (Exception ex) {
			throw new ServletException(ex);
		}
		if (url.getRedirectType() == RedirectType.FORWARD) {
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(url.getUrl());
			dispatcher.forward(request, response);
		} else {
			response.sendRedirect(url.getUrl());
		}
		return;
	}
}
