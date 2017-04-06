<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h3>Edit work</h3>
<form action="admin_works" method="post">
	<input type="hidden" name="action" value="editwork"/>
	<input type="hidden" name="workid" value="${workid}"/>
	<input type="hidden" name="workguid" value="${workguid}"/>
	<label>Work ID: ${workid}</label><br/>
	<label>Work guid: ${workguid}</label><br/>
	<label for="workname">Work name:</label><br/>
	<input id="workname" type="text" name="workname" value="${workname}" required="required"><br/>
	<label for="workprice">Price of work:</label><br/>
	<input id="workprice" type="number" name="workprice" value="${workprice}" required="required"><br/>
	<label for="workdescription">Description of the work</label><br/>
	<textarea id="workdescription" name="workdescription">${workdescription}</textarea><br/>
	<hr/>
	<input type="submit" value="Update"/>
	<a href="admin_works?action=getallworks">Cancel</a>
</form>
</body>
</html>