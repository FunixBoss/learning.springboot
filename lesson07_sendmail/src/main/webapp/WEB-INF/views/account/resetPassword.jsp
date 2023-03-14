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
	<title>Login</title>
	<link rel="stylesheet" href="//code.jquery.com/ui/1.13.2/themes/base/jquery-ui.css">
	<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
	<script src="https://code.jquery.com/ui/1.13.2/jquery-ui.js"></script>
</head>
<body>
	<h3>Reset Password</h3>
	${msg }
	<s:form action="${pageContext.request.contextPath}/account/resetPassword" method="POST">
		<input type="hidden" name="email" value="${tempAccount.email}">
  		<input type="hidden" name="securityCode" value="${tempAccount.securityCode}">
		<table>
			<tr>
				<td>New Password</td>
				<td><input type="password" name="password"/></td>
			</tr>
			<tr>
				<td>&nbsp;</td>
				<td><input type="submit" value="Send"></td>
			</tr>
		</table>
	</s:form> 
	
</body>
</html>