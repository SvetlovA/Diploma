<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Admins</title>
<link rel="stylesheet" href="styles/TableStyle.css">
<link rel="stylesheet" href="styles/IndicatorStyle.css">
</head>
<body>
	<div class="error-message">${errorMessage}</div>
	<table class="table">
		<tr class="table-row">
			<th class="table-header-cell">Admin Guid</th>
			<th class="table-header-cell">Login</th>
			<th class="table-header-cell">Status</th>
			<th class="table-header-cell action"></th>
		</tr>
		<c:forEach items="${users}" var="admin">
			<c:if test="${login != admin.getLogin()}">
				<tr class="table-row">
					<td class="table-cell">${admin.getUserGuid()}</td>
					<td class="table-cell">${admin.getLogin()}</td>
					<td class="table-cell">
						${admin.getStatus()}
						<div class="indicator"></div>
					</td>
					<td class="table-cell action">
						<a href="admin_deleteadmin?action=getadmindeletepage&userid=${admin.getUserId()}&userguid=${admin.getUserGuid()}&userlogin=${admin.getLogin()}">Delete</a>
					</td>
				</tr>
			</c:if>
		</c:forEach>
	</table>
	<hr>
	<a href="admin_addadmin?action=getadminaddpage">Add</a>
	<a href="menu?action=getadminmenu">Back menu</a>
	<script src="scripts/IndicatorChecker.js"></script>
</body>
</html>