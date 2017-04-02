<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Order workers</title>
</head>
<body>
<h3>Select workers to delete from order ${orderguid}</h3>
<form action="admin_orders" method="post">
	<input type="hidden" name="action" value="deleteorderworkers"/>
	<input type="hidden" name="orderid" value="${orderid}"/>
	<input type="hidden" name="orderguid" value="${orderguid}"/>
	<input type="hidden" name="ordertotalcost" value="${ordertotalcost}"/>
	<input type="hidden" name="orderworkstatus" value="${orderworkstatus}"/>
	<table>
		<tr>
			<th>Worker ID</th>
			<th>worker Guid</th>
			<th>Login</th>
			<th>Surname</th>
			<th>Name</th>
			<th>Patronymic</th>
			<th>Experience</th>
		</tr>
		<c:forEach items="${workers}" var="worker">
			<tr>
				<td>${worker.getUserId()}</td>
				<td>${worker.getUserGuid()}</td>
				<td>${worker.getLogin()}</td>
				<td>${worker.getSurname()}</td>
				<td>${worker.getName()}</td>
				<td>${worker.getPatronymic()}</td>
				<td>${worker.getExperience()}</td>
				<td><input type="checkbox" name="isselected" value="${worker.getUserGuid()}"/></td>
			</tr>
		</c:forEach>
	</table>
	<input type="submit" value="Delete"/>
	<a href="admin_orders?action=getallorders">Back</a>
</form>
</body>
</html>