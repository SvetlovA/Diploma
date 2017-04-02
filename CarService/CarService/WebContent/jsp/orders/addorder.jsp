<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Works</title>
</head>
<body>
	<form action="client_addorder" method="post">
		<input type="hidden" name="action" value="addorder">
		<h3>Select car for order:</h3>
		<select name="selectedCar" multiple="multiple">
			<c:forEach items="${clientcars}" var="car">
				<option value="${car.getNumber()}">${car}</option>
			</c:forEach>
		</select>
		<h3>Select works for order:</h3>
		<table>
			<tr>
				<th>Work ID</th>
				<th>Work Guid</th>
				<th>Name</th>
				<th>Price</th>
				<th>Description</th>
			</tr>
			<c:forEach items="${works}" var="work">
				<tr>
					<td>${work.getWorkId()}</td>
					<td>${work.getWorkGuid()}</td>
					<td>${work.getName()}</td>
					<td>${work.getPrice()}</td>
					<td>${work.getDescription()}</td>
					<td>
						<input type="checkbox" name="isselectedwork" value="${work.getWorkGuid()}">
					</td>
				</tr>
			</c:forEach>
		</table>
		<hr>
		<h3>Select share parts for order(if you need it):</h3>
		<table>
			<tr>
				<th>Share part ID</th>
				<th>Share part Guid</th>
				<th>Name</th>
				<th>Price</th>
				<th>Count</th>
				<th>Description</th>
			</tr>
			<c:forEach items="${shareparts}" var="sharePart">
				<tr>
					<td>${sharePart.getSharePartId()}</td>
					<td>${sharePart.getSharePartGuid()}</td>
					<td>${sharePart.getName()}</td>
					<td>${sharePart.getPrice()}</td>
					<td>${sharePart.getCount()}</td>
					<td>${sharePart.getDescription()}</td>
					<td>
						<input type="checkbox" name="isselectedsharepart" value="${sharePart.getSharePartGuid()}">
					</td>
				</tr>
			</c:forEach>
		</table>
		<hr>
		<input type="submit" value="Add">
		<a href="menu?action=getclientmenu">Cancel</a>
	</form>
</body>
</html>