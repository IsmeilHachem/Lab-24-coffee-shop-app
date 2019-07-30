<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="/register" method="post">
		<p>firstName: <input type="text" name= "firstname" required/> </p>
		<p>lastName: <input type="text" name="lastname" required/></p>
		<p>userName: <input type="text" name= "username" required/> </p>
		<p>Password: <input type="password" name= "password" required/> </p>
		<p><input type="submit"/></p>
	</form>
</body>
</html>