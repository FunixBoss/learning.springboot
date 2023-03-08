<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>Form Handling</title>
	<link rel="stylesheet" href="//code.jquery.com/ui/1.13.2/themes/base/jquery-ui.css">
	<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
	<script src="https://code.jquery.com/ui/1.13.2/jquery-ui.js"></script>
</head>
<body>
	<h3>Index - Msg: <s:message code="msg"></s:message></h3>
	<!--  phải dùng Session để lưu trữ lại ngôn ngữ khi chuyển qua các trang -->
	<a href="${pageContext.request.contextPath}/demo?lang=vi_VN">
		<img src="${pageContext.request.contextPath}/resources/images/vietnam.jpg" width="50px" height="50px" alt="">
	</a>
	<a href="${pageContext.request.contextPath}/demo?lang=ja_JP">
		<img src="${pageContext.request.contextPath}/resources/images/japan.jpg" width="50px" height="50px" alt="">
	</a>
	<a href="${pageContext.request.contextPath}/demo?lang=de_DE">
		<img src="${pageContext.request.contextPath}/resources/images/duc.jpg" width="50px" height="50px" alt="">
	</a>
	<br>
	<!--  Đặt biến save -->
	<s:message code="save" var="save"></s:message>
	<input type="button" value="${save }">
	<br>
	<s:message code="msg2" arguments="123,456" argumentSeparator=","></s:message>
	<br>
	Date: <fmt:formatDate value="${today }" dateStyle="full" />
	<br>
	<!-- thẻ này dùng cho 3 việc: tiền tệ, số, %  -->
	Price: <fmt:formatNumber value="${currency }" type="currency"/>
	<br>
	Number: <fmt:formatNumber value="${number }" type="number"/>
	<br>
	Percent: <fmt:formatNumber value="${percent }" type="percent"/>
</body>
</html>