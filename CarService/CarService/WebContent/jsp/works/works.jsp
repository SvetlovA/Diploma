<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Works</title>
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
			<th class="table-header-cell">Name</th>
			<th class="table-header-cell">Price</th>
			<th class="table-header-cell">Description</th>
			<th class="table-header-cell action"></th>
		</tr>
		<c:forEach items="${works}" var="work">
		<tr class="table-row">
			<td class="table-cell guid">${work.getWorkGuid()}</td>
			<td class="table-cell name">${work.getName()}</td>
			<td class="table-cell price">${work.getPrice()}</td>
			<td class="table-cell description">${work.getDescription()}</td>
			<td class="table-cell action">
				<a href="admin_deletework?action=getworkdeletepage&workid=${work.getWorkId()}&workguid=${work.getWorkGuid()}&workname=${work.getName()}&workprice=${work.getPrice()}&workdescription=${work.getDescription()}">Delete</a>
				<a href="admin_editwork?action=getworkeditpage&workid=${work.getWorkId()}&workguid=${work.getWorkGuid()}&workname=${work.getName()}&workprice=${work.getPrice()}&workdescription=${work.getDescription()}">Edit</a>
			</td>
		</tr>
		</c:forEach>
	</table>
	<hr>
	<a href="admin_addwork?action=getworkaddpage">Add</a>
	<a href="menu?action=getadminmenu">Back menu</a>
	<script src="scripts/Filter.js"></script>
	<script src="scripts/FilterPresenter.js"></script>
	<script src="scripts/FilterView.js"></script>
	<script src="scripts/FilterStarter.js"></script>
</body>
</html>