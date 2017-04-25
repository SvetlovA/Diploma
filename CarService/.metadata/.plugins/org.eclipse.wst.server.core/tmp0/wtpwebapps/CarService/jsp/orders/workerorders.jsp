<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Orders</title>
<link rel="stylesheet" href="styles/TableStyle.css">
</head>
<body>
	<div class="error-message">${errorMessage}</div>
	<table class="table">
		<tr class="table-row">
			<th class="table-header-cell">OrderGuid</th>
			<th class="table-header-cell">OrderDate</th>
			<th class="table-header-cell">Car</th>
			<th class="table-header-cell">Workers</th>
			<th class="table-header-cell">Share parts</th>
			<th class="table-header-cell">Works</th>
			<th class="table-header-cell">Total cost</th>
			<th class="table-header-cell">Status</th>
			<th class="table-header-cell action"></th>
		</tr>
		<c:forEach items="${orders}" var="order">
		<tr class="Table-row">
			<td class="table-cell">${order.getOrderGuid()}</td>
			<td class="table-cell">${order.getOrderDate()}</td>
			<td class="table-cell">${order.getCar()}</td>
			<td class="table-cell">${order.getWorkers()}</td>
			<td class="table-cell">${order.getShareParts()}</td>
			<td class="table-cell">${order.getWorks()}</td>
			<td class="table-cell">${order.getTotalCost()}</td>
			<td class="table-cell">${order.getStatus()}</td>
			<td class="table-cell action">
				<a href="worker_orders?action=startprogress&orderid=${order.getOrderId()}&orderguid=${order.getOrderGuid()}&orderdate=${order.getOrderDate()}&ordertotalcost=${order.getTotalCost()}&orderworkstatus=${order.getStatus()}">Start progress</a>
				<a href="worker_orders?action=resolve&orderid=${order.getOrderId()}&orderguid=${order.getOrderGuid()}&orderdate=${order.getOrderDate()}&ordertotalcost=${order.getTotalCost()}&orderworkstatus=${order.getStatus()}">Resolve</a>
			</td>
		</tr>
		</c:forEach>
	</table>
	<hr>
	<a href="menu?action=getworkermenu">Back menu</a>
</body>
</html>