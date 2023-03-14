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
	<h3>Index</h3> 	<!-- SessionFlash trong controller -->
	<h4>${msg}</h4>
	<a href="${pageContext.request.contextPath }/product/add">Add product</a>

	<table border="1">
		<tr>
			<td>Id</td>
			<td>Name</td>
			<td>Price</td>
			<td>Quantity</td>
			<td>Status</td>
			<td>Created</td>
			<td>Description</td>
			<td>Edit</td>
			<td>Delete</td>
			
		</tr>
		<c:forEach var="product" items="${products}">
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
			<td>
				<a href="${pageContext.request.contextPath }/product/edit/${product.id}">Edit</a>
			</td>
			<td>
				<a href="${pageContext.request.contextPath }/product/delete/${product.id}">Delete</a>
			</td>
		</tr>
	</c:forEach>
	</table>
	
</body>
</html>