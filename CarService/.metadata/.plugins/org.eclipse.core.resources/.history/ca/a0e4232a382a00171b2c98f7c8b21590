<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registration</title>
<link rel="stylesheet" href="styles/RegistrationPageStyle.css">
</head>
<body>
	<h3>Registration</h3>
	<div class="error-message">${errorMessage}</div>
	<form id="registration-form" action="login" method="post">
		<input type="hidden" name="action" value="register">
		<label for="client-login">Login:</label><br>
		<input id="client-login" type="text" name="clientlogin" required="required"><br>
		<label for="client-password">Password:</label><br>
		<input id="client-password" type="password" name="clientpassword" required="required"><br>
		<label for="repeat-client-password">Repeat password:</label><br>
		<input id="repeat-client-password" type="password" name="repeatclientpassword" required="required">
		<div id="indicator"></div><br>
		<label for="client-surname">Surname:</label><br>
		<input id="client-surname" type="text" name="clientsurname" required="required"><br>
		<label for="client-name">Name:</label><br>
		<input id="client-name" type="text" name="clientname" required="required"><br>
		<label for="client-patronymic">Patronymic:</label><br>
		<input id="client-patronymic" type="text" name="clientpatronymic" required="required">
		<hr>
		<input type="submit" value="Register">
		<a href="login?action=getloginpage">Cancel</a>
	</form>
	<script src="scripts/RegistrationFormValidation.js"></script>
</body>
</html>