<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Delete order</title>
</head>
<body>
	<h3>Are you sure to delete order ${orderguid}</h3>
	<form action="admin_orders" method="post">
		<input type="hidden" name="action" value="deleteorder"/>
		<input type="hidden" name="orderid" value="${orderid}"/>
		<input type="hidden" name="orderguid" value="${orderguid}"/>
		<input type="hidden" name="ordertotalcost" value="${ordertotalcost}"/>
		<input type="hidden" name="orderworkstatus" value="${orderworkstatus}"/>
		<label> Order ID: ${orderid}</label><br>
		<label> Order GUID: ${orderguid}</label><br>
		<label> Order total cost: ${ordertotalcost}</label><br>
		<label> Order work status: ${orderworkstatus}</label><br>
		<hr>
		<input type="submit" value="Delete">
		<a href="admin_orders?action=getallorders">Cancel</a>
	</form>
</body>
</html>