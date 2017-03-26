<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Share parts</title>
</head>
<body>
	<table>
		<tr>
			<th>Share part ID</th>
			<th>Share part Guid</th>
			<th>Name</th>
			<th>Price</th>
			<th>Count</th>
			<th>Description</th>
		</tr>
		<c:forEach items="${shareparts}" var="sharePart">
			<tr>
				<td>${sharePart.getSharePartId()}</td>
				<td>${sharePart.getSharePartGuid()}</td>
				<td>${sharePart.getName()}</td>
				<td>${sharePart.getPrice()}</td>
				<td>${sharePart.getCount()}</td>
				<td>${sharePart.getDescription()}</td>
				<td>
					<a href="admin_deletesharepart?action=getsharepartdeletepage&sharepartid=${sharePart.getSharePartId()}&sharepartguid=${sharePart.getSharePartGuid()}&sharepartname=${sharePart.getName()}&sharepartprice=${sharePart.getPrice()}&sharepartcount=${sharePart.getCount()}&sharepartdescription=${sharePart.getDescription()}">Delete</a>
					<a href="admin_editsharepart?action=getshareparteditpage&sharepartid=${sharePart.getSharePartId()}&sharepartguid=${sharePart.getSharePartGuid()}&sharepartname=${sharePart.getName()}&sharepartprice=${sharePart.getPrice()}&sharepartcount=${sharePart.getCount()}&sharepartdescription=${sharePart.getDescription()}">Edit</a>
				</td>
			</tr>
		</c:forEach>
	</table>
	<a href="admin_addsharepart?action=getsharepartaddpage">Add</a><br/>
	<a href="menu?action=getadminmenu">Back menu</a>
</body>
</html>