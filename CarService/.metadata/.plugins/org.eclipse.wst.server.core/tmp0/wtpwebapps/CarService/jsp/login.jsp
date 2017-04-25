<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
<link rel="stylesheet" href="styles/LoginStyle.css">
</head>
<body>
	<form action="menu" method="POST">
		<input type="hidden" name="action" value="login">
		<div class="item login">
			<label for="login">Login:</label><br/>
			<input id="login" type="text" name="login" required="required">
		</div>
		<div class="item password">
			<label for="password">Password:</label><br/>
			<input id="password" type="password" name="password" required="required">
		</div>
		<div class="item buttons">
			<input type="submit" value="login">
			<a href="registration?action=getregistrationpage">Registration</a>
		</div>
		<div class="item error-message">${errorMessage}</div>
	</form>
</body>
</html>