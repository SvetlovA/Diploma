<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Delete client</title>
</head>
<body>
<h3>Are you sure to delete client ${clientname}</h3>
<form action="admin_clients" method="post">
	<input type="hidden" name="action" value="deleteclient"/>
	<input type="hidden" name="clientid" value="${clientid}"/>
	<input type="hidden" name="clientguid" value="${clientguid}"/>
	<input type="hidden" name="clientlogin" value="${clientlogin}"/>
	<input type="hidden" name="clientsurname" value="${clientsurname}"/>
	<input type="hidden" name="clientname" value="${clientname}"/>
	<input type="hidden" name="clientpatronymic" value="${clientpatronymic}"/>
	<label>Client id: ${clientid}</label><br/>
	<label>Client guid: ${clientguid}</label><br/>
	<label>Client login: ${clientlogin}</label><br/>
	<label>Client surname: ${clientsurname}</label><br/>
	<label>Client name: ${clientsurname}</label><br/>
	<label>Client patronymic: ${clientpatronymic}</label><br/>
	<hr/>
	<input type="submit" value="Submit"/>
	<a href="admin_clients?action=getallclients">Cancel</a>
</form>
</body>
</html>