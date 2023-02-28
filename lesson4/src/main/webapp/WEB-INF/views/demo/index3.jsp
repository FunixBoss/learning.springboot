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
	Count products: ${countDefault } 
	<br>
	--------------------------
	<br>
	Status: ${status }
	<br>
	Count product with status ({$status}): {countByStatus}
	<br>
	Sum quantity of product: ${sum1}
	<br>
	Sum (price * quantity) or all products: ${sum2 }
	<br>
	Min price: ${minPrice }
	<br>
	Max price: ${maxPrice }
	<br>
	Avg price: ${avgPrice }
</body>
</html>