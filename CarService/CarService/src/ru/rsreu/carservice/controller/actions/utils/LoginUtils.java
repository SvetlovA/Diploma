package ru.rsreu.carservice.controller.actions.utils;

import resources.Resourcer;
import ru.rsreu.carservice.model.bll.Permission;

public class LoginUtils {
	
	private LoginUtils() {
	}
	
	public static String getPage(Permission permission) throws Exception {
		switch (permission) {
		case ADMIN:
			return Resourcer.getString("path.page.menu.admin");
		case CLIENT:
			return Resourcer.getString("path.page.menu.client");
		case WORKER:
			return Resourcer.getString("path.page.menu.worker");
		default:
			throw new Exception("Page doesn't exists.");
		}
	}
}
