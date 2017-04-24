<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Share parts</title>
<link rel="stylesheet" href="styles/TableStyle.css">
</head>
<body>
	<table class="table">
		<tr class="table-row">
			<th class="table-header-cell">Share part Guid</th>
			<th class="table-header-cell">Name</th>
			<th class="table-header-cell">Price</th>
			<th class="table-header-cell">Count</th>
			<th class="table-header-cell">Description</th>
			<th class="table-header-cell action"></th>
		</tr>
		<c:forEach items="${shareparts}" var="sharePart">
		<tr class="table-row">
			<td class="table-cell">${sharePart.getSharePartGuid()}</td>
			<td class="table-cell">${sharePart.getName()}</td>
			<td class="table-cell">${sharePart.getPrice()}</td>
			<td class="table-cell">${sharePart.getCount()}</td>
			<td class="table-cell">${sharePart.getDescription()}</td>
			<td class="table-cell action">
				<a href="admin_deletesharepart?action=getsharepartdeletepage&sharepartid=${sharePart.getSharePartId()}&sharepartguid=${sharePart.getSharePartGuid()}&sharepartname=${sharePart.getName()}&sharepartprice=${sharePart.getPrice()}&sharepartcount=${sharePart.getCount()}&sharepartdescription=${sharePart.getDescription()}">Delete</a>
				<a href="admin_editsharepart?action=getshareparteditpage&sharepartid=${sharePart.getSharePartId()}&sharepartguid=${sharePart.getSharePartGuid()}&sharepartname=${sharePart.getName()}&sharepartprice=${sharePart.getPrice()}&sharepartcount=${sharePart.getCount()}&sharepartdescription=${sharePart.getDescription()}">Edit</a>
			</td>
		</tr>
		</c:forEach>
	</table>
	<hr>
	<a href="admin_addsharepart?action=getsharepartaddpage">Add</a>
	<a href="menu?action=getadminmenu">Back menu</a>
</body>
</html>