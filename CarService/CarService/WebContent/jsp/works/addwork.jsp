<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add work</title>
</head>
<body>
<h3>Add work</h3>
<form action="works" method="post">
	<input type="hidden" name="action" value="addwork"/>
	<label for="workname">Input work name:</label><br/>
	<input id="workname" type="text" name="workname"/><br/>
	<label for="workprice">Input price of work:</label><br/>
	<input id="workprice" type="text" name="workprice"/><br/>
	<label for="workdescription">Input description of the work</label><br/>
	<textarea id="workdescription" name="workdescription"></textarea><br/>
	<hr/>
	<input type="submit" value="Add"/>
	<a href="works?action=getallworks">Cancel</a>
</form>
</body>
</html>