<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Client orders</title>
</head>
<body>
	<table>
		<tr>
			<th>OrderId</th>
			<th>OrderGuid</th>
			<th>Car</th>
			<th>Workers</th>
			<th>Share parts</th>
			<th>Works</th>
			<th>Total cost</th>
			<th>Status</th>
		</tr>
		<c:forEach items="${orders}" var="order">
			<tr>
				<td>${order.getOrderId()}</td>
				<td>${order.getOrderGuid()}</td>
				<td>${order.getCar()}</td>
				<td>${order.getWorkers()}</td>
				<td>${order.getShareParts()}</td>
				<td>${order.getWorks()}</td>
				<td>${order.getTotalCost()}</td>
				<td>${order.getStatus()}</td>
			</tr>
		</c:forEach>
	</table>
	<a href="client_addorder?action=getaddorderpage">Add</a>
	<a href="menu?action=getclientmenu">Back menu</a>
</body>
</html>