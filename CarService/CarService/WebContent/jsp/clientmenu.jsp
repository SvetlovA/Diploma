<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Menu</title>
</head>
<body>
	<h3>Hello ${login}</h3>
	<a href="client_addorder?action=getaddorderpage">Add order</a><br>
	<a href="client_orders?action=getclientorders">Orders</a><br>
	<hr>
	<a href="login?action=logout">Logout</a>
</body>
</html>