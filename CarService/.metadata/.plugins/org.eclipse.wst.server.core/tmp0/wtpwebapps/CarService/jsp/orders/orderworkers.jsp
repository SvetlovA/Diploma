<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Order workers</title>
<link rel="stylesheet" href="styles/TableStyle.css">
</head>
<body>
<h3>Select workers to delete from order ${orderguid}</h3>
<form action="admin_orders" method="post">
	<input type="hidden" name="action" value="deleteorderworkers">
	<input type="hidden" name="orderid" value="${orderid}">
	<input type="hidden" name="orderguid" value="${orderguid}">
	<input type="hidden" name="orderdate" value="${orderdate}">
	<input type="hidden" name="ordertotalcost" value="${ordertotalcost}">
	<input type="hidden" name="orderworkstatus" value="${orderworkstatus}">
	<table class="table">
		<tr class="table-row">
			<th class="table-header-cell">Worker Guid</th>
			<th class="table-header-cell">Login</th>
			<th class="table-header-cell">Surname</th>
			<th class="table-header-cell">Name</th>
			<th class="table-header-cell">Patronymic</th>
			<th class="table-header-cell">Experience</th>
			<th class="table-header-cell action"></th>
		</tr>
		<c:forEach items="${workers}" var="worker">
		<tr class="table-row">
			<td class="table-cell">${worker.getUserGuid()}</td>
			<td class="table-cell">${worker.getLogin()}</td>
			<td class="table-cell">${worker.getSurname()}</td>
			<td class="table-cell">${worker.getName()}</td>
			<td class="table-cell">${worker.getPatronymic()}</td>
			<td class="table-cell">${worker.getExperience()}</td>
			<td class="table-cell action">
				<input type="checkbox" name="isselected" value="${worker.getUserGuid()}"/>
			</td>
		</tr>
		</c:forEach>
	</table>
	<hr>
	<input type="submit" value="Delete"/>
	<a href="admin_orders?action=getallorders">Back</a>
</form>
</body>
</html>