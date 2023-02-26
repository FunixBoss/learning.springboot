<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Insert title here</title>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css">
	<script src="${pageContext.request.contextPath}/resources/js/mylib.js"></script>
</head>
<body>
	<h1>Hello world!</h1>
	<!-- ${pageContext.request.contextPath} ==> Về đường dẫn gốc views -->
	<a href="${pageContext.request.contextPath}/index2">Menu 1</a>
	<a href="${pageContext.request.contextPath}/index4?id=123&name=abc">Menu 2</a>
	<a href="${pageContext.request.contextPath}/index5?id=5&name=zxvc">Menu 1</a>
	<br/>
	<br/>
	<!-- resouces/ -> hiểu là static vì đã định nghĩa static-pattern trong properties -->
	<image src="${pageContext.request.contextPath}/resources/images/gaixinh1.jpg" onclick="clickMe()"/>
</body>
</html>