 <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h3>Search</h3>
	<form method="get" action="${pageContext.request.contextPath}/search">
		Keyword <input type="text" name="keyword"/>
		
		<br/>
		<input type="submit" value="search">
	</form>
	
	<br/>
	
	<h3>Login</h3>
	<form action="${pageContext.request.contextPath}/login" method="POST">
		Username: <input type="text" name="username"/>
		<br>
		Password: <input type="password" name="password"/>
		<br>
		<input type="submit" value="Login">
	</form>
	
	<h3>Update</h3>
	<form action="${pageContext.request.contextPath}/update" method="POST">
		Email 1: <input type="text" name="email"/>
		<br>
		Email 2: <input type="text" name="email"/>
		<br>
		Email 3: <input type="text" name="email"/>
		<br>
		Quantity 1: <input type="text" name="quantity"/>
		<br>
		Quantity 2: <input type="text" name="quantity"/>
		<br>
		Quantity 3: <input type="text" name="quantity"/>
		<input type="submit" value="Update">
	</form>
</body>
</html>