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
	<div class="filter">
		<select class="property-names"></select>
		<select class="signs"></select>
		<input class="value" type="text">
		<input class="btn-apply" type="button" value="Apply">
		<input class="btn-cancel" type="button" value="Cancel">
	</div>
	<table class="table">
		<tr class="table-row">
			<th class="table-header-cell">Guid</th>
			<th class="table-header-cell">Date</th>
			<th class="table-header-cell">Car</th>
			<th class="table-header-cell">Workers</th>
			<th class="table-header-cell">ShareParts</th>
			<th class="table-header-cell">Works</th>
			<th class="table-header-cell">Cost</th>
			<th class="table-header-cell">Status</th>
			<th class="table-header-cell action"></th>
		</tr>
		<c:forEach items="${orders}" var="order">
		<tr class="table-row">
			<td class="table-cell guid">${order.getOrderGuid()}</td>
			<td class="table-cell date">${order.getOrderDate()}</td>
			<td class="table-cell car">${order.getCar()}</td>
			<td class="table-cell workers">${order.getWorkers()}</td>
			<td class="table-cell shareparts">${order.getShareParts()}</td>
			<td class="table-cell works">${order.getWorks()}</td>
			<td class="table-cell cost">${order.getTotalCost()}</td>
			<td class="table-cell status">${order.getStatus()}</td>
		</tr>
		</c:forEach>
	</table>
	<hr>
	<a href="client_addorder?action=getaddorderpage">Add</a>
	<a href="menu?action=getclientmenu">Back menu</a>
	<script src="scripts/Filter.js"></script>
	<script src="scripts/FilterPresenter.js"></script>
	<script src="scripts/FilterView.js"></script>
	<script src="scripts/FilterStarter.js"></script>
</body>
</html>