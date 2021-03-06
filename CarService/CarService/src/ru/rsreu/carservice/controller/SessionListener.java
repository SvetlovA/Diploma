package ru.rsreu.carservice.controller;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import resources.Resourcer;
import ru.rsreu.carservice.model.bll.CarService;
import ru.rsreu.carservice.model.dal.exceptions.DataBaseException;
import ru.rsreu.carservice.model.entities.User;

public class SessionListener implements HttpSessionAttributeListener {

	/**
	 * Add attribute to session
	 */
	@Override
	public void attributeAdded(HttpSessionBindingEvent sessionBindingEvent) {
		System.out.println("Attribute added...");
		setUserStatus(sessionBindingEvent, true);
	}

	/**
	 * Remove attribute from session
	 */
	@Override
	public void attributeRemoved(HttpSessionBindingEvent sessionBindingEvent) {
		System.out.println("Attribute removed...");
		setUserStatus(sessionBindingEvent, false);
	}

	/**
	 * Replace atrribut from session
	 */
	@Override
	public void attributeReplaced(HttpSessionBindingEvent sessionBindingEvent) {
		try {
			throw new Exception("Session was changed.");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Set user status
	 * @param sessionBindingEvent
	 * @param isOnline
	 */
	private void setUserStatus(HttpSessionBindingEvent sessionBindingEvent, boolean isOnline) {
		HttpSession session = sessionBindingEvent.getSession();
		ServletContext context = session.getServletContext();
		CarService carService = (CarService) context.getAttribute(Resourcer.getString("parameter.carservice"));
		if (sessionBindingEvent.getName().compareTo("login") == 0) {
			try {
				User user = carService.getUser(sessionBindingEvent.getValue().toString());
				user.setIsOnline(isOnline);
				carService.updateUser(user);
			} catch (DataBaseException ex) {
				ex.printStackTrace();
			}
		}
	}
}
