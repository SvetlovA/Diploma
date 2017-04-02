<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
</head>
<body>
	<form action="menu" method="POST">
		<input type="hidden" name="action" value="login"><br/>
		<label for="login">Login:</label><br/>
		<input id="login" type="text" name="login" required="required"><br/>
		<label for="password"> Password:</label><br/>
		<input id="password" type="password" name="password" required="required"> <br />
		${errorLoginPassword}
		<input type="submit" value="login">
	</form>
</body>
</html>