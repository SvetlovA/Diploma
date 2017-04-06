<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Works</title>
</head>
<body>
	<table>
		<tr>
			<th>Work ID</th>
			<th>Work Guid</th>
			<th>Name</th>
			<th>Price</th>
			<th>Description</th>
		</tr>
		<c:forEach items="${works}" var="work">
			<tr>
				<td>${work.getWorkId()}</td>
				<td>${work.getWorkGuid()}</td>
				<td>${work.getName()}</td>
				<td>${work.getPrice()}</td>
				<td>${work.getDescription()}</td>
				<td>
					<a href="admin_deletework?action=getworkdeletepage&workid=${work.getWorkId()}&workguid=${work.getWorkGuid()}&workname=${work.getName()}&workprice=${work.getPrice()}&workdescription=${work.getDescription()}">Delete</a>
					<a href="admin_editwork?action=getworkeditpage&workid=${work.getWorkId()}&workguid=${work.getWorkGuid()}&workname=${work.getName()}&workprice=${work.getPrice()}&workdescription=${work.getDescription()}">Edit</a>
				</td>
			</tr>
		</c:forEach>
	</table>
	<a href="admin_addwork?action=getworkaddpage">Add</a><br/>
	<a href="menu?action=getadminmenu">Back menu</a>
</body>
</html>