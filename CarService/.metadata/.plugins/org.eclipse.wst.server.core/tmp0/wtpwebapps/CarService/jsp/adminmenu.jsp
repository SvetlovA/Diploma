<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Menu</title>
<link rel="stylesheet" href="styles/CarServiceMenuStyle.css">
</head>
<body>
	<h3>Hello ${login}</h3>
	<div class="item error-message">${errorMessage}</div>
	<ul class="menu">
		<li class="menu-item"><a href="admin_orders?action=getallorders">All orders</a></li>
		<li class="menu-item"><a href="admin_clients?action=getallclients">All clients</a></li>
		<li class="menu-item"><a href="admin_workers?action=getallworkers">All workers</a></li>
		<li class="menu-item"><a href="admin_shareparts?action=getallshareparts">All share parts</a></li>
		<li class="menu-item"><a href="admin_works?action=getallworks">All works</a></li>
	</ul>
	<hr />
	<a href="login?action=logout">Logout</a>
</body>
</html>