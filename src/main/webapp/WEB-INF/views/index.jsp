<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Coffee Shop</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootswatch/4.3.1/lux/bootstrap.min.css" />
<link rel="stylesheet" href="/stylecss">
</head>
<body>
	<h1>Welcome to Poop Town!</h1>
	
	<header>
		<span>
			Hello ${ preference.firstname }
		</span>
	</header>
	
	<div>
	<a href="/admin">Admin Page</a>
	</div>
	<div>
	<a href="/login">Log In!</a>
	</div>
	<table class="table">

			<thead>
				<tr>
				<th>Name</th><th>Description</th><th>Price</th>
				</tr>
			</thead>
			<tbody>
			<c:forEach var="Products" items="${list}">
				<tr>
					<td><a href="/index?id=${Products.id}">${Products.name}</a></td>
					<td>${Products.description}</td>
					<td>$${Products.price}</td>
				</tr>
			</c:forEach>
			</tbody>
		</table>
		
		<nav>
			<c:if test="${ empty username }">
				<a href="/login">Log in</a>
			</c:if>
			<c:if test="${ not empty username }">
				Welcome ${ user.username }
				<a href="/logout">Log out</a>
			</c:if>
		</nav>
		
		<p><a href="/register">Let's add those Bowels!</a></p>

</body>
</html>