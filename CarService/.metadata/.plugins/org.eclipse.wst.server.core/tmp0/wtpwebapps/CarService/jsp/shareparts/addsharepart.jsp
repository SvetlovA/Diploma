<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add share part</title>
</head>
<body>
<h3>Add share part</h3>
<form action="admin_shareparts" method="post">
	<input type="hidden" name="action" value="addsharepart"/>
	<label for="sharepartname">Input share part name:</label><br/>
	<input id="sharepartname" type="text" name="sharepartname"/><br/>
	<label for="sharepartprice">Input share part price</label><br/>
	<input id="sharepartprice" type="text" name="sharepartprice"/><br/>
	<label for="sharepartcount">Input share part count:</label><br/>
	<input id="sharepartcount" type="text" name="sharepartcount"/><br/>
	<label for="sharepartdescription">Input share part description:</label><br/>
	<textarea id="sharepartdescription" name="sharepartdescription"></textarea>
	<hr/>
	<input type="submit" value="Add"/>
	<a href="admin_shareparts?action=getallshareparts">Cancel</a>
</form>
</body>
</html>