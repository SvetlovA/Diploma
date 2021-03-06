<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add order</title>
<link rel="stylesheet" href="styles/TableStyle.css">
</head>
<body>
	<div class="error-message">${errorMessage}</div>
	<form action="client_addorder" method="post">
		<input type="hidden" name="action" value="addorder">
		<h3>Select car for order:</h3>
		<select name="selectedCar" multiple="multiple">
			<c:forEach items="${clientcars}" var="car">
				<option value="${car.getNumber()}">${car}</option>
			</c:forEach>
		</select>
		<hr>
		<h3>Select works for order:</h3>
		<table class="table">
			<tr class="table-row">
				<th class="table-header-cell action"></th>
				<th class="table-header-cell">Work Guid</th>
				<th class="table-header-cell">Name</th>
				<th class="table-header-cell">Price</th>
				<th class="table-header-cell">Description</th>
			</tr>
			<c:forEach items="${works}" var="work">
				<tr class="table-row">
					<td class="table-cell action">
						<input type="checkbox" name="isselectedwork" value="${work.getWorkGuid()}">
					</td>
					<td class="table-cell">${work.getWorkGuid()}</td>
					<td class="table-cell">${work.getName()}</td>
					<td class="table-cell">${work.getPrice()}</td>
					<td class="table-cell">${work.getDescription()}</td>
				</tr>
			</c:forEach>
		</table>
		<hr>
		<h3>Select share parts for order(if you need it):</h3>
		<table class="table">
			<tr class="table-row">
				<th class="table-header-cell action"></th>
				<th class="table-header-cell">Share part Guid</th>
				<th class="table-header-cell">Name</th>
				<th class="table-header-cell">Price</th>
				<th class="table-header-cell">Count</th>
				<th class="table-header-cell">Description</th>
			</tr>
			<c:forEach items="${shareparts}" var="sharePart">
				<tr class="table-row">
					<td class="table-cell action">
						<input type="checkbox" name="isselectedsharepart" value="${sharePart.getSharePartGuid()}">
					</td>
					<td class="table-cell">${sharePart.getSharePartGuid()}</td>
					<td class="table-cell">${sharePart.getName()}</td>
					<td class="table-cell">${sharePart.getPrice()}</td>
					<td class="table-cell">${sharePart.getCount()}</td>
					<td class="table-cell">${sharePart.getDescription()}</td>
				</tr>
			</c:forEach>
		</table>
		<hr>
		<input type="submit" value="Add">
		<a href="menu?action=getclientmenu">Cancel</a>
	</form>
</body>
</html>