<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Delete car</title>
</head>
<body>
<h3>Are you sure to delete car ${carmark} ${carmodel}</h3>
<div class="error-message">${errorMessage}</div>
<form action="admin_client_cars" method="post">
	<input type="hidden" name="action" value="deletecar"/>
	<input type="hidden" name="clientid" value="${clientid}">
	<input type="hidden" name="clientguid" value="${clientguid}">
	<input type="hidden" name="clientlogin" value="${clientlogin}">
	<input type="hidden" name="clientsurname" value="${clientsurname}">
	<input type="hidden" name="clientname" value="${clientname}">
	<input type="hidden" name="clientpatronymic" value="${clientpatronymic}">
	<input type="hidden" name="carid" value="${carid}"/>
	<input type="hidden" name="carguid" value="${carguid}"/>
	<input type="hidden" name="carnumber" value="${carnumber}"/>
	<input type="hidden" name="carmark" value="${carmark}"/>
	<input type="hidden" name="carmodel" value="${carmodel}"/>
	<label>Car id: ${carid}</label><br/>
	<label>Car guid: ${carguid}</label><br/>
	<label>State number: ${carnumber}</label><br/>
	<label>Car mark: ${carmark}</label><br/>
	<label>Car model: ${carmodel}</label><br/>
	<hr/>
	<input type="submit" value="Submit"/>
	<a href="admin_client_cars?action=getclientcarspage&clientid=${clientid}&clientguid=${clientguid}&clientlogin=${clientlogin}&clientsurname=${clientsurname}&clientname=${clientname}&clientpatronymic=${clientpatronymic}">Cancel</a>
</form>
</body>
</html>