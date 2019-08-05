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
	<h1>Welcome Back</h1>
	
	<c:if test="${ not empty message }">
		<p class="message">${ message }</p>
	</c:if>
	
	<form action="/login" method="post" autocomplete="off" >
	<p>
		<label>userName</label> <input name="username" />
	</p>
	<p>
		<label>Password</label> <input type="password" name="password" required />
	</p>
	<p>
		<button type="submit">Submit</button>
	</p>
	</form>
	<a href="/">Home</a>
</body>
</html>