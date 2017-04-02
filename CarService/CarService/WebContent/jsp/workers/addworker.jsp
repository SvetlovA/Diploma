<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Worker</title>
</head>
<body>
<h3>Add worker</h3>
	<form action="admin_workers" method="post">
		<input type="hidden" name="action" value="addworker"/><br/>
		<label for="login">Input login:</label><br/>
		<input id="login" type="text" name="workerlogin" required="required"><br/>
		<label for="password">Input password:</label><br/>
		<input id="password" type="password" name="workerpassword" required="required"><br/>
		<label for="surname">Input surname:</label><br/>
		<input id="surname" type="text" name="workersurname" required="required"><br/>
		<label for="name">Input name:</label><br/>
		<input id="name" type="text" name="workername" required="required"><br/>
		<label for="patronymic">Input patronymic:</label><br/>
		<input id="patronymic" type="text" name="workerpatronymic" required="required"><br/>
		<label for="experience">Input experience</label><br/>
		<input id="experience" type="number" name="workerexperience" required="required"><br/>
		<hr/>
		<input type="submit" value="Add"/>
		<a href="admin_workers?action=getallworkers">Cancel</a>
	</form>
</body>
</html>