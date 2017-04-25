<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Client orders</title>
<link rel="stylesheet" href="styles/TableStyle.css">
</head>
<body>
	<div class="error-message">${errorMessage}</div>
	<table class="table">
		<tr class="table-row">
			<th class="table-header-cell">OrderGuid</th>
			<th class="table-header-cell">Order date</th>
			<th class="table-header-cell">Car</th>
			<th class="table-header-cell">Workers</th>
			<th class="table-header-cell">Share parts</th>
			<th class="table-header-cell">Works</th>
			<th class="table-header-cell">Total cost</th>
			<th class="table-header-cell">Status</th>
			<th class="table-header-cell action"></th>
		</tr>
		<c:forEach items="${orders}" var="order">
		<tr class="table-row">
			<td class="table-cell">${order.getOrderGuid()}</td>
			<td class="table-cell">${order.getOrderDate()}</td>
			<td class="table-cell">${order.getCar()}</td>
			<td class="table-cell">${order.getWorkers()}</td>
			<td class="table-cell">${order.getShareParts()}</td>
			<td class="table-cell">${order.getWorks()}</td>
			<td class="table-cell">${order.getTotalCost()}</td>
			<td class="table-cell">${order.getStatus()}</td>
		</tr>
		</c:forEach>
	</table>
	<hr>
	<a href="client_addorder?action=getaddorderpage">Add</a>
	<a href="menu?action=getclientmenu">Back menu</a>
</body>
</html>