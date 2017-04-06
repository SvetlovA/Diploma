<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add work</title>
</head>
<body>
<h3>Add work</h3>
<form action="admin_works" method="post">
	<input type="hidden" name="action" value="addwork"/>
	<label for="workname">Input work name:</label><br/>
	<input id="workname" type="text" name="workname" required="required"><br/>
	<label for="workprice">Input price of work:</label><br/>
	<input id="workprice" type="number" name="workprice" required="required"><br/>
	<label for="workdescription">Input description of the work</label><br/>
	<textarea id="workdescription" name="workdescription"></textarea><br/>
	<hr/>
	<input type="submit" value="Add"/>
	<a href="admin_works?action=getallworks">Cancel</a>
</form>
</body>
</html>