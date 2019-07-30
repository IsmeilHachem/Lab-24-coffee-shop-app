<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Coffee Shop</title>
</head>
<body>
	<h1>Welcome to Poop Town!</h1>
	<table class="table">

			<thead>
				<tr>
				<th>Name</th><th>Description</th><th>Price</th>
				</tr>
			</thead>
			<tbody>
			<c:forEach var="Products" items="${products}">
				<tr>
					<td><a href="/index?id=${Products.id}">${Products.name}</a></td>
					<td>${Products.description}</td>
					<td>${Products.price}</td>
				</tr>
			</c:forEach>
			</tbody>
		</table>
		
		<p><a href="/register">Let's get those Bowels movin!</a></p>

</body>
</html>