<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Free workers</title>
<link rel="stylesheet" href="styles/TableStyle.css">
</head>
<body>
<h3>Select workers for order ${orderguid}</h3>
<div class="error-message">${errorMessage}</div>
<div class="filter">
	<select class="property-names"></select>
	<select class="signs"></select>
	<input class="value" type="text">
	<input class="btn-apply" type="button" value="Apply">
	<input class="btn-cancel" type="button" value="Cancel">
</div>
<form action="admin_orders" method="post">
	<input type="hidden" name="action" value="addorderworkers">
	<input type="hidden" name="orderid" value="${orderid}">
	<input type="hidden" name="orderguid" value="${orderguid}">
	<input type="hidden" name="orderdate" value="${orderdate}">
	<input type="hidden" name="ordertotalcost" value="${ordertotalcost}">
	<input type="hidden" name="orderworkstatus" value="${orderworkstatus}">
	<table class="table">
		<tr class="table-row">
			<th class="table-header-cell">Guid</th>
			<th class="table-header-cell">Login</th>
			<th class="table-header-cell">Surname</th>
			<th class="table-header-cell">Name</th>
			<th class="table-header-cell">Patronymic</th>
			<th class="table-header-cell">Experience</th>
			<th class="table-header-cell action"></th>
		</tr>
		<c:forEach items="${workers}" var="worker">
		<tr class="table-row">
			<td class="table-cell guid">${worker.getUserGuid()}</td>
			<td class="table-cell login">${worker.getLogin()}</td>
			<td class="table-cell surname">${worker.getSurname()}</td>
			<td class="table-cell name">${worker.getName()}</td>
			<td class="table-cell patronymic">${worker.getPatronymic()}</td>
			<td class="table-cell experience">${worker.getExperience()}</td>
			<td class="table-cell action">
				<input type="checkbox" name="isselected" value="${worker.getUserGuid()}"/>
			</td>
		</tr>
		</c:forEach>
	</table>
	<hr>
	<input type="submit" value="Add"/>
	<a href="admin_orders?action=getallorders">Back</a>
</form>
<script src="scripts/Filter.js"></script>
<script src="scripts/FilterPresenter.js"></script>
<script src="scripts/FilterView.js"></script>
<script src="scripts/FilterStarter.js"></script>
</body>
</html>