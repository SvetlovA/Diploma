<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cars</title>
</head>
<body>
<h3>${clientname} cars</h3>
<table>
	<tr>
		<th>Car ID</th>
		<th>Car Guid</th>
		<th>State number</th>
		<th>Mark</th>
		<th>Model</th>
	</tr>
	<c:forEach items="${clientcars}" var="car">
		<tr>
			<td>${car.getCarId()}</td>
			<td>${car.getCarGuid()}</td>
			<td>${car.getNumber()}</td>
			<td>${car.getMark()}</td>
			<td>${car.getModel()}</td>
			<td>
				<a href="admin_deletecar?action=getcardeletepage&carid=${car.getCarId()}&carguid=${car.getCarGuid()}&carnumber=${car.getNumber()}&carmark=${car.getMark()}&carmodel=${car.getModel()}&clientid=${clientid}&clientguid=${clientguid}&clientlogin=${clientlogin}&clientsurname=${clientsurname}&clientname=${clientname}&clientpatronymic=${clientpatronymic}">Delete</a>
			</td>
		</tr>
	</c:forEach>
</table>
<a href="admin_addcar?action=getcaraddpage&clientid=${clientid}&clientguid=${clientguid}&clientlogin=${clientlogin}&clientsurname=${clientsurname}&clientname=${clientname}&clientpatronymic=${clientpatronymic}">Add</a>
<a href="admin_clients?action=getallclients">Back</a>
</body>
</html>