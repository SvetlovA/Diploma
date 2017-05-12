<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Workers</title>
<link rel="stylesheet" href="styles/TableStyle.css">
<link rel="stylesheet" href="styles/IndicatorStyle.css">
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
			<th class="table-header-cell">Login</th>
			<th class="table-header-cell">Surname</th>
			<th class="table-header-cell">Name</th>
			<th class="table-header-cell">Patronymic</th>
			<th class="table-header-cell">Experience</th>
			<th class="table-header-cell">Orders</th>
			<th class="table-header-cell">Status</th>
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
			<td class="table-cell orders">${worker.getOrders()}</td>
			<td class="table-cell status">
				${worker.getStatus()}
				<div class="indicator"></div>
			</td>
			<td class="table-cell action">
				<a href="admin_deleteworker?action=getworkerdeletepage&workerid=${worker.getUserId()}&workerguid=${worker.getUserGuid()}&workerlogin=${worker.getLogin()}&workersurname=${worker.getSurname()}&workername=${worker.getName()}&workerpatronymic=${worker.getPatronymic()}&workerexperience=${worker.getExperience()}">Delete</a>
				<a href="admin_editworker?action=getworkereditpage&workerid=${worker.getUserId()}&workerguid=${worker.getUserGuid()}&workerlogin=${worker.getLogin()}&workersurname=${worker.getSurname()}&workername=${worker.getName()}&workerpatronymic=${worker.getPatronymic()}&workerexperience=${worker.getExperience()}">Edit</a>
			</td>
		</tr>
		</c:forEach>
	</table>
	<hr>
	<a href="admin_addworker?action=getworkeraddpage">Add</a>
	<a href="menu?action=getadminmenu">Back menu</a>
	<script src="scripts/IndicatorChecker.js"></script>
	<script src="scripts/Filter.js"></script>
	<script src="scripts/FilterPresenter.js"></script>
	<script src="scripts/FilterView.js"></script>
	<script src="scripts/FilterStarter.js"></script>
</body>
</html>