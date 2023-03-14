<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Spring Data Jpa</title>
</head>
<body>
	<h3>Index</h3>
	<table border="1">
		<tr>
			<td>Id</td>
			<td>Name</td>
			<td>Price</td>
			<td>Quantity</td>
			<td>Status</td>
			<td>Created</td>
			<td>Description</td>
		</tr>
		<tr>
			<td>${product.id}</td>
			<td>${product.name}</td>
			<td>${product.price}</td>
			<td>${product.quantity}</td>
			<td>${product.status}</td>
			<td>
				<fmt:formatDate value="${product.created}" pattern="dd/MM/yyyy"/>	
			</td>
			<td>${product.description}</td>
		</tr>
	</table>
	
</body>
</html>