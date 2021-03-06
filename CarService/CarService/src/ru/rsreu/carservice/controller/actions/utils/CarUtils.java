package ru.rsreu.carservice.controller.actions.utils;

import java.util.Set;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import ru.rsreu.carservice.model.entities.Car;

public class CarUtils {
	
	private static final String CARS_ATTRIBUTE_NAME = "clientcars";
	private static final String CARMODEL_PARAMETER_NAME = "carmodel";
	private static final String CARMARK_PARAMETER_NAME = "carmark";
	private static final String CARNUMBER_PARAMETER_NAME = "carnumber";
	private static final String CARGUID_PARAMETER_NAME = "carguid";
	private static final String CARID_PARAMETER_NAME = "carid";

	private CarUtils() {
	}
	
	public static Car parseCar(HttpServletRequest request) {
		Car car = new Car();
		int carId = Integer.parseInt(request.getParameter(CARID_PARAMETER_NAME));
		car.setCarId(carId);
		UUID carGuid = UUID.fromString(request.getParameter(CARGUID_PARAMETER_NAME));
		car.setCarGuid(carGuid);
		String carNumber = request.getParameter(CARNUMBER_PARAMETER_NAME);
		car.setNumber(carNumber);
		String carMark = request.getParameter(CARMARK_PARAMETER_NAME);
		car.setMark(carMark);
		String carModel = request.getParameter(CARMODEL_PARAMETER_NAME);
		car.setModel(carModel);
		return car;
	}
	
	public static void setCar(HttpServletRequest request, Car car) {
		request.setAttribute(CARID_PARAMETER_NAME, car.getCarId());
		request.setAttribute(CARGUID_PARAMETER_NAME, car.getCarGuid());
		request.setAttribute(CARNUMBER_PARAMETER_NAME, car.getNumber());
		request.setAttribute(CARMARK_PARAMETER_NAME, car.getMark());
		request.setAttribute(CARMODEL_PARAMETER_NAME, car.getModel());
	}
	
	public static void setCars(HttpServletRequest request, Set<Car> cars) {
		request.setAttribute(CARS_ATTRIBUTE_NAME, cars);
	}
	
	public static String getUrl(String urlPattern, String action, Car car) {
		StringBuilder servletPath = new StringBuilder(BaseUtils.createUrl(urlPattern, action));
		servletPath.append("&");
		servletPath.append(CARID_PARAMETER_NAME);
		servletPath.append("=");
		servletPath.append(car.getCarId());
		servletPath.append("&");
		servletPath.append(CARGUID_PARAMETER_NAME);
		servletPath.append("=");
		servletPath.append(car.getCarGuid());
		servletPath.append("&");
		servletPath.append(CARNUMBER_PARAMETER_NAME);
		servletPath.append("=");
		servletPath.append(car.getNumber());
		servletPath.append("&");
		servletPath.append(CARMARK_PARAMETER_NAME);
		servletPath.append("=");
		servletPath.append(car.getMark());
		servletPath.append("&");
		servletPath.append(CARMODEL_PARAMETER_NAME);
		servletPath.append("=");
		servletPath.append(car.getModel());
		return servletPath.toString();
	}
}
