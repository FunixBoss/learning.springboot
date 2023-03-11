<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>Home</title>
	<link rel="stylesheet" href="//code.jquery.com/ui/1.13.2/themes/base/jquery-ui.css">
	<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
	<script src="https://code.jquery.com/ui/1.13.2/jquery-ui.js"></script>
</head>
<body>
	<h3>Login Page</h3>
	<!-- /account/processlogin ko cần phải khai báo trong controller mà trong SecurityConfiguration http.loginProcessUrl -->
	${msg}
	<form action="${pageContext.request.contextPath}/account/processLogin" method="post">
		Username <input type="text" name="username" id="">
		<br>
		Password <input type="password" name="password" id="">
		<br>
		<input type="submit" value="Login">
	</form>
	<a href="${pageContext.request.contextPath}/account/register">Register</a>
</body>
</html>