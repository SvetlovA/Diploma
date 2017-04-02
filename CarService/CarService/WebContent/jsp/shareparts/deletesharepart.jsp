<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Delete share part</title>
</head>
<body>
<h3>Are you sure to delete share part: ${sharepartname}</h3>
<form action="admin_shareparts" method="post">
	<input type="hidden" name="action" value="deletesharepart"/>
	<input type="hidden" name="sharepartid" value="${sharepartid}">
	<input type="hidden" name="sharepartguid" value="${sharepartguid}"/>
	<input type="hidden" name="sharepartname" value="${sharepartname}">
	<input type="hidden" name="sharepartprice" value="${sharepartprice}">
	<input type="hidden" name="sharepartcount" value="${sharepartcount}">
	<input type="hidden" name="sharepartdescription" value="${sharepartdescription}">
	<label>Share part ID: ${sharepartid}</label><br/>
	<label>Share part guid: ${sharepartguid}</label><br/>
	<label>Share part name: ${sharepartname}</label><br/>
	<label>Price of share part: ${sharepartprice}</label><br/>
	<label>Share parts count: ${sharepartcount}</label><br/>
	<label>Description: ${sharepartdescription}</label><br/>
	<hr/>
	<input type="submit" value="Submit"/>
	<a href="admin_shareparts?action=getallshareparts">Cancel</a>
</form>
</body>
</html>