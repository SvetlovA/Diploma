<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Clients</title>
</head>
<body>
	<table>
		<tr>
			<th>Client ID</th>
			<th>Client Guid</th>
			<th>Login</th>
			<th>Surname</th>
			<th>Name</th>
			<th>Patronymic</th>
			<th>Cars</th>
		</tr>
		<c:forEach items="${clients}" var="client">
			<tr>
				<td>${client.getUserId()}</td>
				<td>${client.getUserGuid()}</td>
				<td>${client.getLogin()}</td>
				<td>${client.getSurname()}</td>
				<td>${client.getName()}</td>
				<td>${client.getPatronymic()}</td>
				<td>${client.getCars()}</td>
				<td>
					<a href="admin_cars?action=getclientcarspage&clientid=${client.getUserId()}&clientguid=${client.getUserGuid()}&clientlogin=${client.getLogin()}&clientsurname=${client.getSurname()}&clientname=${client.getName()}&clientpatronymic=${client.getPatronymic()}">Cars</a>
					<a href="admin_deleteclient?action=getclientdeletepage&clientid=${client.getUserId()}&clientguid=${client.getUserGuid()}&clientlogin=${client.getLogin()}&clientsurname=${client.getSurname()}&clientname=${client.getName()}&clientpatronymic=${client.getPatronymic()}">Delete</a>
					<a href="admin_editclient?action=getclienteditpage&clientid=${client.getUserId()}&clientguid=${client.getUserGuid()}&clientlogin=${client.getLogin()}&clientsurname=${client.getSurname()}&clientname=${client.getName()}&clientpatronymic=${client.getPatronymic()}">Edit</a>
				</td>
			</tr>
		</c:forEach>
	</table>
	<a href="admin_addclient?action=getclientaddpage">Add</a>
	<a href="menu?action=getadminmenu">Back menu</a>
</body>
</html>