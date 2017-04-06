package ru.rsreu.carservice.controller;

import java.sql.SQLException;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import resources.Resourcer;
import ru.rsreu.carservice.model.bll.CarService;
import ru.rsreu.carservice.model.entities.User;

public class SessionListener implements HttpSessionAttributeListener {

	@Override
	public void attributeAdded(HttpSessionBindingEvent sessionBindingEvent) {
		setUserStatus(sessionBindingEvent, true);
	}

	@Override
	public void attributeRemoved(HttpSessionBindingEvent sessionBindingEvent) {
		setUserStatus(sessionBindingEvent, false);
	}

	@Override
	public void attributeReplaced(HttpSessionBindingEvent sessionBindingEvent) {
	}
	
	private void setUserStatus(HttpSessionBindingEvent sessionBindingEvent, boolean isOnline) {
		HttpSession session = sessionBindingEvent.getSession();
		ServletContext context = session.getServletContext();
		CarService carService = (CarService) context.getAttribute(Resourcer.getString("parameter.carservice"));
		if (sessionBindingEvent.getName().compareTo("login") == 0) {
			try {
				User user = carService.getUser(sessionBindingEvent.getValue().toString());
				user.setIsOnline(isOnline);
				carService.updateUser(user);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
