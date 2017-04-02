<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h3>Edit worker ${workername}</h3>
	<form action="admin_workers" method="post">
		<input type="hidden" name="action" value="editworker"/>
		<input type="hidden" name="userId" value="${workerid}"/>
		<input type="hidden" name="userGuid" value="${workerguid}"/>
		<input type="hidden" name="workerLogin" value="${workerlogin}"/>
		<label>Worker ID: ${workerid}</label><br/>
		<label>Worker guid: ${workerguid}</label><br/>
		<label>Login: ${workerlogin}</label><br/>
		<label for="surname">Surname:</label><br/>
		<input id="surname" type="text" name="surname" value="${workersurname}" required="required"><br/>
		<label for="name">Name:</label><br/>
		<input id="name" type="text" name="name" value="${workername}" required="required"><br/>
		<label for="patronymic">Patronymic:</label><br/>
		<input id="patronymic" type="text" name="patronymic" value="${workerpatronymic}" required="required"><br/>
		<label for="experience">Experience</label><br/>
		<input id="experience" type="number" name="experience" value="${workerexperience}" required="required"><br/>
		<hr/>
		<input type="submit" value="Update"/>
		<a href="admin_workers?action=getallworkers">Cancel</a>
	</form>
</body>
</html>