<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add client</title>
</head>
<body>
<h3>Add client</h3>
<form action="admin_clients" method="post">
	<input type="hidden" name="action" value="addclient"/>
	<label for="clientlogin">Input client login:</label><br/>
	<input id="clientlogin" type="text" name="clientlogin"/><br/>
	<label for="cientpassword">Input client password:</label><br/>
	<input id="clientpassword" type="password" name="clientpassword"/><br/>
	<label for="clientsurname">Input client surname:</label><br/>
	<input id="clientsurname" type="text" name="clientsurname"/><br/>
	<label for="clientname"> Input client name:</label><br/>
	<input id="clientname" type="text" name="clientname"/><br/>
	<label for="clientpatronymic">Input client patronymic:</label><br/>
	<input id="clientpatronymic" type="text" name="clientpatronymic"/><br/>
	<input type="submit" value="Add"/>
	<a href="admin_clients?action=getallclients">Cancel</a>
</form>
</body>
</html>