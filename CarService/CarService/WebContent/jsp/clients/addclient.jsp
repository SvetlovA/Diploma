<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add client</title>
</head>
<body>
<h3>Add client</h3>
<div class="error-message">${errorMessage}</div>
<form action="admin_clients" method="post">
	<input type="hidden" name="action" value="addclient"/>
	<label for="clientlogin">Input client login:</label><br/>
	<input id="clientlogin" type="text" name="clientlogin" required="required"><br/>
	<label for="cientpassword">Input client password:</label><br/>
	<input id="clientpassword" type="password" name="clientpassword" required="required"><br/>
	<label for="clientsurname">Input client surname:</label><br/>
	<input id="clientsurname" type="text" name="clientsurname" required="required"><br/>
	<label for="clientname"> Input client name:</label><br/>
	<input id="clientname" type="text" name="clientname" required="required"><br/>
	<label for="clientpatronymic">Input client patronymic:</label><br/>
	<input id="clientpatronymic" type="text" name="clientpatronymic" required="required"><br/>
	<input type="submit" value="Add"/>
	<a href="admin_clients?action=getallclients">Cancel</a>
</form>
</body>
</html>