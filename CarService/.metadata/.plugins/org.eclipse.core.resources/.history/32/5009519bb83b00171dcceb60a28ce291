<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cars</title>
<link rel="stylesheet" href="styles/TableStyle.css">
</head>
<body>
<h3>${clientname} cars</h3>
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
		<th class="table-header-cell">Number</th>
		<th class="table-header-cell">Mark</th>
		<th class="table-header-cell">Model</th>
		<th class="table-header-cell action"></th>
	</tr>
	<c:forEach items="${clientcars}" var="car">
	<tr class="table-row">
		<td class="table-cell guid">${car.getCarGuid()}</td>
		<td class="table-cell number">${car.getNumber()}</td>
		<td class="table-cell mark">${car.getMark()}</td>
		<td class="table-cell model">${car.getModel()}</td>
		<td class="table-cell action">
			<a href="admin_deletecar?action=getcardeletepage&carid=${car.getCarId()}&carguid=${car.getCarGuid()}&carnumber=${car.getNumber()}&carmark=${car.getMark()}&carmodel=${car.getModel()}&clientid=${clientid}&clientguid=${clientguid}&clientlogin=${clientlogin}&clientsurname=${clientsurname}&clientname=${clientname}&clientpatronymic=${clientpatronymic}">Delete</a>
		</td>
	</tr>
	</c:forEach>
</table>
<hr>
<a href="admin_addcar?action=getcaraddpage&clientid=${clientid}&clientguid=${clientguid}&clientlogin=${clientlogin}&clientsurname=${clientsurname}&clientname=${clientname}&clientpatronymic=${clientpatronymic}">Add</a>
<a href="admin_clients?action=getallclients">Back</a>
<script src="scripts/Filter.js"></script>
<script src="scripts/FilterPresenter.js"></script>
<script src="scripts/FilterView.js"></script>
<script src="scripts/FilterStarter.js"></script>
</body>
</html>