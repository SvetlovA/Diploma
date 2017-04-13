package ru.rsreu.carservice.controller.actions.utils;

import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import ru.rsreu.carservice.model.bll.CarService;
import ru.rsreu.carservice.model.entities.Order;
import ru.rsreu.carservice.model.entities.WorkStatus;
import ru.rsreu.carservice.model.entities.Worker;

public class OrderUtils {
	
	private static final String ORDERS_ATTRIBUTE_NAME = "orders";
	private static final String ORDERWORKSTATUS_PARAMETER_NAME = "orderworkstatus";
	private static final String ORDERTOTALCOST_PARAMETER_NAME = "ordertotalcost";
	private static final String ORDERGUID_PARAMETER_NAME = "orderguid";
	private static final String ORDERID_PARAMETER_NAME = "orderid";
	private static final String ISSELECTED_PARAMETER_NAME = "isselected";

	private OrderUtils() {
	}
	
	public static Order parseOrder(HttpServletRequest request) {
		Order order = new Order();
		int orderId = Integer.parseInt(request.getParameter(ORDERID_PARAMETER_NAME));
		order.setOrderId(orderId);
		UUID orderGuid = UUID.fromString(request.getParameter(ORDERGUID_PARAMETER_NAME));
		order.setOrderGuid(orderGuid);
		double orderTotalCost = Double.parseDouble(request.getParameter(ORDERTOTALCOST_PARAMETER_NAME));
		order.setTotalCost(orderTotalCost);
		WorkStatus orderWorkStatus = WorkStatus.valueOf(request.getParameter(ORDERWORKSTATUS_PARAMETER_NAME));
		order.setStatus(orderWorkStatus);
		return order;
	}
	
	public static void setOrder(HttpServletRequest request, Order order) {
		request.setAttribute(ORDERID_PARAMETER_NAME, order.getOrderId());
		request.setAttribute(ORDERGUID_PARAMETER_NAME, order.getOrderGuid());
		request.setAttribute(ORDERTOTALCOST_PARAMETER_NAME, order.getTotalCost());
		request.setAttribute(ORDERWORKSTATUS_PARAMETER_NAME, order.getStatus());
	}
	
	public static void setOrders(HttpServletRequest request, Set<Order> orders) {
		request.setAttribute(ORDERS_ATTRIBUTE_NAME, orders);
	}
	
	public static Set<Worker> getSelectedWorkers(HttpServletRequest request, CarService carServiceBl) throws SQLException {
		Set<Worker> selectedWorkers = new HashSet<Worker>();
		String[] selectedParameters = request.getParameterValues(ISSELECTED_PARAMETER_NAME);
		for (String selectedParameter : selectedParameters) {
			Worker worker = carServiceBl.getWorker(UUID.fromString(selectedParameter));
			selectedWorkers.add(worker);
		}
		
		return selectedWorkers;
	}
	
	public static String getServletPath(String urlPattern, String action, Order order) {
		StringBuilder servletPath = new StringBuilder(BaseUtils.getServletPath(urlPattern, action));
		servletPath.append("&");
		servletPath.append(ORDERID_PARAMETER_NAME);
		servletPath.append("=");
		servletPath.append(order.getOrderId());
		servletPath.append("&");
		servletPath.append(ORDERGUID_PARAMETER_NAME);
		servletPath.append("=");
		servletPath.append(order.getOrderGuid());
		servletPath.append("&");
		servletPath.append(ORDERTOTALCOST_PARAMETER_NAME);
		servletPath.append("=");
		servletPath.append(order.getTotalCost());
		servletPath.append("&");
		servletPath.append(ORDERWORKSTATUS_PARAMETER_NAME);
		servletPath.append("=");
		servletPath.append(order.getStatus());
		return servletPath.toString();
	}
}
