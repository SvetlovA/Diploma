<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add car</title>
</head>
<body>
<h3>Add car</h3>
<div class="error-message">${errorMessage}</div>
<form action="admin_client_cars" method="post">
	<input type="hidden" name="action" value="addcar"/>
	<input type="hidden" name="clientid" value="${clientid}">
	<input type="hidden" name="clientguid" value="${clientguid}">
	<input type="hidden" name="clientlogin" value="${clientlogin}">
	<input type="hidden" name="clientsurname" value="${clientsurname}">
	<input type="hidden" name="clientname" value="${clientname}">
	<input type="hidden" name="clientpatronymic" value="${clientpatronymic}">
	<label for="carstatenumber">Input car state number:</label><br/>
	<input id="carstatenumber" type="text" name="carstatenumber" required="required"><br/>
	<label for="carmark">Input mark of car:</label><br/>
	<input id="carmark" type="text" name="carmark" required="required"><br/>
	<label for="carmodel">Input model of the car:</label><br/>
	<input id="carmodel" type="text" name="carmodel" required="required"><br/>
	<hr/>
	<input type="submit" value="Add">
	<a href="admin_client_cars?action=getclientcarspage&clientid=${clientid}&clientguid=${clientguid}&clientlogin=${clientlogin}&clientsurname=${clientsurname}&clientname=${clientname}&clientpatronymic=${clientpatronymic}">Cancel</a>
</form>
</body>
</html>