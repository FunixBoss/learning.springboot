<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@taglib prefix="s" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>Register</title>
	<link rel="stylesheet" href="//code.jquery.com/ui/1.13.2/themes/base/jquery-ui.css">
	<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
	<script src="https://code.jquery.com/ui/1.13.2/jquery-ui.js"></script>
</head>
<body>
	<h3>Account Registering</h3>
	${msg}
	<s:form action="${pageContext.request.contextPath}/account/register" 
			method="POST" modelAttribute="account">
		<table>
			<tr>
				<td>Username</td>
				<td><s:input path="username"/></td>
			</tr>
			<tr>
				<td>Password</td>
				<td><s:input path="password"/></td>
			</tr>
			<tr>
				<td>Fullname</td>
				<td><s:input path="fullname"/></td>
			</tr>
			<tr>
				<td>Email</td>
				<td><s:input path="email"/></td>
			</tr>
			<tr>
				<td>&nbsp;</td>
				<td><input type="submit" value="Register"></td>
			</tr>
		</table>
		<a href="${pageContext.request.contextPath }/account/login">Sign In</a>
		<a href="${pageContext.request.contextPath }/account/forgetPassword">Forget Password?</a>
		
	</s:form> 
	
</body>
</html>