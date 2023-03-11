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
	<a href="${pageContext.request.contextPath }/account/welcome">Back</a>
 	<h3>Profile</h3>
	<s:form action="${pageContext.request.contextPath}/account/register" method="post" 
		modelAttribute="account">
		<s:hidden path="id"/>
		
		Username <s:input path="username" disabled="true"/>
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
			<c:set var="checked" value=""></c:set>
			<c:forEach var="roleA" items="${account.roles }">
				<c:if test="${role.id == roleA.id }">
					<c:set var="checked" value = "checked='checked'"></c:set>
				</c:if>
			</c:forEach>
			<input type="checkbox" name="roles" value="${role.id }" ${checked }> ${role.name }
		</c:forEach>
		<br>
		<input type="submit" value="Update">
	</s:form>
</body>
</html>