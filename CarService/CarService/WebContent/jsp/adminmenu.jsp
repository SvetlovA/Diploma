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
<a href="admin_orders?action=getallorders">All orders</a> <br/>
<a href="admin_clients?action=getallclients">All clients</a> <br/>
<a href="admin_workers?action=getallworkers">All workers</a> <br/>
<a href="admin_shareparts?action=getallshareparts">All share parts</a> <br/>
<a href="admin_works?action=getallworks">All works</a> <br/>
<hr /> <br/>
<a href="login?action=logout">Logout</a>
</body>
</html>