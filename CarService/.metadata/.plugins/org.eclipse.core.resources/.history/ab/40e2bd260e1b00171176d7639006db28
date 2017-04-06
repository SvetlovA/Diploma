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
<form action="admin_cars" method="post">
	<input type="hidden" name="action" value="addcar"/>
	<label for="carstatenumber">Input car state number:</label><br/>
	<input id="carstatenumber" type="text" name="carstatenumber" required="required"><br/>
	<label for="carmark">Input mark of car:</label><br/>
	<input id="carmark" type="text" name="carmark" required="required"><br/>
	<label for="carmodel">Input model of the car:</label><br/>
	<input id="carmodel" type="text" name="carmodel" required="required"><br/>
	<hr/>
	<input type="submit" value="Add">
	<a href="admin_cars?action=getclientcarspage&clientid=${clientid}&clientguid=${clientguid}&clientlogin=${clientlogin}&clientsurname=${clientsurname}&clientname=${clientname}&clientpatronymic=${clientpatronymic}">Cancel</a>
</form>
</body>
</html>