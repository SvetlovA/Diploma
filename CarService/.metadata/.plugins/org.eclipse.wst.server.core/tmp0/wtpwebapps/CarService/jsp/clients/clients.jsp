<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Clients</title>
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
			<th class="table-header-cell">Cars</th>
			<th class="table-header-cell">Status</th>
			<th class="table-header-cell action"></th>
		</tr>
		<c:forEach items="${clients}" var="client">
		<tr class="table-row">
			<td class="table-cell guid">${client.getUserGuid()}</td>
			<td class="table-cell login">${client.getLogin()}</td>
			<td class="table-cell surname">${client.getSurname()}</td>
			<td class="table-cell name">${client.getName()}</td>
			<td class="table-cell patronymic">${client.getPatronymic()}</td>
			<td class="table-cell cars">${client.getCars()}</td>
			<td class="table-cell status">
				${client.getStatus()}
				<div class="indicator"></div>
			</td>
			<td class="table-cell action">
				<a href="admin_cars?action=getclientcarspage&clientid=${client.getUserId()}&clientguid=${client.getUserGuid()}&clientlogin=${client.getLogin()}&clientsurname=${client.getSurname()}&clientname=${client.getName()}&clientpatronymic=${client.getPatronymic()}">Cars</a>
				<a href="admin_deleteclient?action=getclientdeletepage&clientid=${client.getUserId()}&clientguid=${client.getUserGuid()}&clientlogin=${client.getLogin()}&clientsurname=${client.getSurname()}&clientname=${client.getName()}&clientpatronymic=${client.getPatronymic()}">Delete</a>
				<a href="admin_editclient?action=getclienteditpage&clientid=${client.getUserId()}&clientguid=${client.getUserGuid()}&clientlogin=${client.getLogin()}&clientsurname=${client.getSurname()}&clientname=${client.getName()}&clientpatronymic=${client.getPatronymic()}">Edit</a>
			</td>
		</tr>
		</c:forEach>
	</table>
	<hr>
	<a href="admin_addclient?action=getclientaddpage">Add</a>
	<a href="menu?action=getadminmenu">Back menu</a>
	<script src="scripts/IndicatorChecker.js"></script>
	<script src="scripts/Filter.js"></script>
	<script src="scripts/FilterPresenter.js"></script>
	<script src="scripts/FilterView.js"></script>
	<script src="scripts/FilterStarter.js"></script>
</body>
</html>