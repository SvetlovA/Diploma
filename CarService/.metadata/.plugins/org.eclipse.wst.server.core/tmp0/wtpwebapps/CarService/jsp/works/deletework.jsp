<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Delete work</title>
</head>
<body>
<h3>Are you sure to delete work: ${workname}</h3>
<form action="admin_works" method="post">
	<input type="hidden" name="action" value="deletework"/>
	<input type="hidden" name="workid" value="${workid}">
	<input type="hidden" name="workguid" value="${workguid}"/>
	<input type="hidden" name="workname" value="${workname}">
	<input type="hidden" name="workprice" value="${workprice}">
	<input type="hidden" name="workdescription" value="${workdescription}">
	<label>Work ID: ${workid}</label><br/>
	<label>Work guid: ${workguid}</label><br/>
	<label>Work name: ${workname}</label><br/>
	<label>Price of work: ${workprice}</label><br/>
	<label>Description of work: ${workdescription}</label><br/>
	<hr/>
	<input type="submit" value="Submit"/>
	<a href="admin_works?action=getallworks">Cancel</a>
</form>
</body>
</html>