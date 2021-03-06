<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Edit client</title>
</head>
<body>
<h3>Edit client</h3>
<div class="error-message">${errorMessage}</div>
<form action="admin_clients" method="post">
	<input type="hidden" name="action" value="editclient">
	<input type="hidden" name="clientid" value="${clientid}"/>
	<input type="hidden" name="clientguid" value="${clientguid}"/>
	<input type="hidden" name="clientlogin" value="${clientlogin}"/>
	<label>Client id: ${clientid}</label><br/>
	<label>Client guid: ${clientguid}</label><br/>
	<label>Client login: ${clientlogin}</label><br/>
	<label for="clientsurname">Client surname:</label><br/>
	<input id="clientsurname" type="text" name="clientsurname" value="${clientsurname}" required="required"><br/>
	<label for="clientname">Client name:</label><br/>
	<input id="clientname" type="text" name="clientname" value="${clientname}" required="required"><br/>
	<label for="clientpatronymic">Client patronymic:</label><br/>
	<input type="text" name="clientpatronymic" value="${clientpatronymic}" required="required"><br/>
	<hr/>
	<input type="submit" value="Update"/>
	<a href="admin_clients?action=getallclients">Cancel</a>
</form>
</body>
</html>