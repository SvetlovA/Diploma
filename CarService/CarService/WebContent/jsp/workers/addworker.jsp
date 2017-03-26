<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
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
		<input id="login" type="text" name="workerlogin"/><br/>
		<label for="password">Input password:</label><br/>
		<input id="password" type="password" name="workerpassword"><br/>
		<label for="surname">Input surname:</label><br/>
		<input id="surname" type="text" name="workersurname"><br/>
		<label for="name">Input name:</label><br/>
		<input id="name" type="text" name="workername"><br/>
		<label for="patronymic">Input patronymic:</label><br/>
		<input id="patronymic" type="text" name="workerpatronymic"><br/>
		<label for="experience">Input experience</label><br/>
		<input id="experience" type="text" name="workerexperience"><br/>
		<hr/>
		<input type="submit" value="Add"/>
		<a href="admin_workers?action=getallworkers">Cancel</a>
	</form>
</body>
</html>