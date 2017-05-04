<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Delete admin</title>
</head>
<body>
	<h3>Are you sure to delete client ${userlogin}</h3>
	<div class="error-message">${errorMessage}</div>
	<form action="admin_admins" method="post">
		<input type="hidden" name="action" value="deleteadmin"/>
		<input type="hidden" name="userid" value="${userid}"/>
		<input type="hidden" name="userguid" value="${userguid}"/>
		<input type="hidden" name="userlogin" value="${userlogin}"/>
		<label>Admin id: ${userid}</label><br/>
		<label>Admin guid: ${userguid}</label><br/>
		<label>Admin login: ${userlogin}</label><br/>
		<hr/>
		<input type="submit" value="Submit"/>
		<a href="admin_admins?action=getalladmins">Cancel</a>
	</form>
</body>
</html>