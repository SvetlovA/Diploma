<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Workers</title>
</head>
<body>
	<table>
		<tr>
			<th>Worker ID</th>
			<th>worker Guid</th>
			<th>Login</th>
			<th>Surname</th>
			<th>Name</th>
			<th>Patronymic</th>
			<th>Experience</th>
			<th>Orders</th>
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
				<td>${worker.getOrders()}</td>
				<td>
					<a href="admin_deleteworker?action=getworkerdeletepage&workerid=${worker.getUserId()}&workerguid=${worker.getUserGuid()}&workerlogin=${worker.getLogin()}&workersurname=${worker.getSurname()}&workername=${worker.getName()}&workerpatronymic=${worker.getPatronymic()}&workerexperience=${worker.getExperience()}">Delete</a>
					<a href="admin_editworker?action=getworkereditpage&workerid=${worker.getUserId()}&workerguid=${worker.getUserGuid()}&workerlogin=${worker.getLogin()}&workersurname=${worker.getSurname()}&workername=${worker.getName()}&workerpatronymic=${worker.getPatronymic()}&workerexperience=${worker.getExperience()}">Edit</a>
				</td>
			</tr>
		</c:forEach>
	</table>
	<a href="admin_addworker?action=getworkeraddpage">Add</a><br/>
	<a href="menu?action=getadminmenu">Back menu</a>
</body>
</html>