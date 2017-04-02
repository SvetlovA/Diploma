<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Edit share part</title>
</head>
<body>
<h3>Edit share part</h3>
<form action="admin_shareparts" method="post">
	<input type="hidden" name="action" value="editsharepart"/>
	<input type="hidden" name="sharepartid" value="${sharepartid}"/>
	<input type="hidden" name="sharepartguid" value="${sharepartguid}"/>
	<label>Share part ID: ${sharepartid}</label><br/>
	<label>Share part guid: ${sharepartguid}</label><br/>
	<label for="sharepartname">Share part name:</label><br/>
	<input id="sharepartname" type="text" name="sharepartname" value="${sharepartname}" required="required"><br/>
	<label for="sharepartprice">Share part price</label><br/>
	<input id="sharepartprice" type="number" name="sharepartprice" value="${sharepartprice}" required="required"><br/>
	<label for="sharepartcount">Share part count:</label><br/>
	<input id="sharepartcount" type="number" name="sharepartcount" value="${sharepartcount}" required="required"><br/>
	<label for="sharepartdescription">Share part description:</label><br/>
	<textarea id="sharepartdescription" name="sharepartdescription">${sharepartdescription}</textarea>
	<hr/>
	<input type="submit" value="Update"/>
	<a href="admin_shareparts?action=getallshareparts">Cancel</a>
</form>
</body>
</html>