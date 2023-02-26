<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Hello world! 2</h1>
	
	<a href="${pageContext.request.contextPath}/index">Back</a>
	
	id: ${id}
	<br>
	username: ${username}
	
	<br>
	Product: <br>
	id: ${product.id} <br>
	name: ${product.name } <br>
	price: ${product.price }
	
	<table>
    <thead>
        <tr>
            <th>Product ID</th>
            <th>Product Name</th>
            <th>Price</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach items="${products}" var="product">
            <tr>
                <td>${product.id}</td>
                <td>${product.name}</td>
                <td>${product.price}</td>
            </tr>
        </c:forEach>
    </tbody>
</table>
</body>
</html>