<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Delete worker</title>
</head>
<body>
<h3>Are you sure to delete worker ${workername}?</h3>
	<div class="error-message">${errorMessage}</div>
	<form action="admin_workers" method="post">
		<input type="hidden" name="action" value="deleteworker"/>
		<input type="hidden" name="workerid" value="${workerid}">
		<input type="hidden" name="workerguid" value="${workerguid}"/>
		<input type="hidden" name="workerlogin" value="${workerlogin}">
		<input type="hidden" name="workersurname" value="${workersurname}">
		<input type="hidden" name="workername" value="${workername}">
		<input type="hidden" name="workerpatronymic" value="${workerpatronymic}">
		<input type="hidden" name="workerexperience" value="${workerexperience}">
		<label>Worker ID: ${workerid}</label><br/>
		<label>Worker guid: ${workerguid}</label><br/>
		<label>Login: ${workerlogin}</label><br/>
		<label>Surname: ${workersurname}</label><br/>
		<label>Name: ${workername}</label><br/>
		<label>Patronymic: ${workerpatronymic}</label><br/>
		<label>Experience: ${workerexperience}</label><br/>
		<hr/>
		<input type="submit" value="Submit"/>
		<a href="admin_workers?action=getallworkers">Cancel</a>
	</form>
</body>
</html>