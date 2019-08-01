<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootswatch/4.3.1/lux/bootstrap.min.css" />
</head>
<body>
<h1>ADMIN PAGE</h1>

	<header>
		<span>
			Hello ${ preference.firstname }
		</span>
	</header>

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
					<td>$${Products.price}</td>
					<td><a href= "/delete?id=${Products.id} ">Remove </a></td>
				</tr>
			</c:forEach>
			</tbody>
		</table>
		
		<a href="/add">Add Item to Menu</a>
		<br/>
		<a href="/">Home</a>
		
</body>
</html>