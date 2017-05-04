<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add admin</title>
</head>
<body>
<h3>Add admin</h3>
<div class="error-message">${errorMessage}</div>
<form action="admin_admins" method="post">
	<input type="hidden" name="action" value="addadmin"/>
	<label for="adminlogin">Input admin login:</label><br/>
	<input id="adminlogin" type="text" name="adminlogin" required="required"><br/>
	<label for="adminpassword">Input admin password:</label><br/>
	<input id="adminpassword" type="password" name="adminpassword" required="required"><br/>
	<input type="submit" value="Add"/>
	<a href="admin_admins?action=getalladmins">Cancel</a>
</form>
</body>
</html>