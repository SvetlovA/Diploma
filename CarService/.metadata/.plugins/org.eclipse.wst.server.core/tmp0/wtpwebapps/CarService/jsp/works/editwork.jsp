<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h3>Edit work</h3>
<form action="works" method="post">
	<input type="hidden" name="action" value="editwork"/>
	<input type="hidden" name="workid" value="${workid}"/>
	<input type="hidden" name="workguid" value="${workguid}"/>
	<label>Work ID: ${workid}</label><br/>
	<label>Work guid: ${workguid}</label><br/>
	<label for="workname">Work name:</label><br/>
	<input id="workname" type="text" name="workname" value="${workname}"/><br/>
	<label for="workprice">Price of work:</label><br/>
	<input id="workprice" type="text" name="workprice" value="${workprice}"/><br/>
	<label for="workdescription">Description of the work</label><br/>
	<textarea id="workdescription" name="workdescription">${workdescription}</textarea><br/>
	<hr/>
	<input type="submit" value="Update"/>
	<a href="works?action=getallworks">Cancel</a>
</form>
</body>
</html>