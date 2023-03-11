<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@taglib prefix="s" uri="http://www.springframework.org/tags/form" %>
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
	<h3>Register Page</h3>
	<s:form action="${pageContext.request.contextPath}/account/register" method="post" 
		modelAttribute="account">
		Username <s:input path="username"/>
		<br>
		Password <s:password path="password"/>
		<br>
		Fullname <s:input path="fullName"/>
		<br>
		Birthday <s:input path="birthday"/>
		<br>
		Gender <s:radiobutton path="gender" value="male"/>Male
				<s:radiobutton path="gender" value="female"/>Female
		<br>
		Roles
		<br>
		<c:forEach var="role" items="${roles }">
			<input type="checkbox" name="roles" value="${role.id }"> ${role.name }
		</c:forEach>
		<br>
		<input type="submit" value="Register">
	</s:form>
	<a href="${pageContext.request.contextPath}/account/login">Login</a>
</body>
</html>