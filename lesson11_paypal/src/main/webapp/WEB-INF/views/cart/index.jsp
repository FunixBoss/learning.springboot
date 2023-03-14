<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html>
<head>
	<title>product</title>
</head>
<body>
	<h3>Cart</h3> <a href="${pageContext.request.contextPath }/product">Continue Shopping</a>
	<form action="${pageContext.request.contextPath}/cart/update" method="post">
		<table border="1">
			<thead>
				<tr>
					<th>Id</th>
					<th>Name</th>
					<th>Price</th>
					<th>Photo</th>
					<th>Quantity <input type="submit" value="update"></th>
					<th>Sub total</th>
					<th>Action</th>
				</tr>
			</thead>
			<tbody>
				<c:set var="total" value="0"/>
				<!-- varStatus -> iterator  -->
				<c:forEach var="item" items="${sessionScope.cart }" varStatus="i">
					<c:set var="total" value="${total + item.product.price * item.quantity }"/>
					<tr>
						<td>${item.product.id }</td>
						<td>${item.product.name }</td>
						<td>${item.product.price }</td>
						<td>
							<img src="${pageContext.request.contextPath }/resources/images/${item.product.photo}" width="200" height="150"/>
						</td>
						<td>
							<input type="number" name="quantities" min="1" value="${item.quantity }">
						</td>
						<td>
							${item.product.price * item.quantity}
						</td>
						<td><a href="${pageContext.request.contextPath }/cart/remove/${i.index}">Remove</a></td>
					</tr>
				</c:forEach>
				<tr>
					<td colspan="5" align="right">Total</td>
					<td>${total }</td>
				</tr>
			</tbody>
		</table>
	</form>
	

	<form action="${posturl}" method="post">
		<!-- cau hinh thanh toan paypal -->
		<input type="hidden" name="upload" value="1"/>	
		<input type="hidden" name="return" value="${returnurl}"/>	
		<input type="hidden" name="cmd" value="_cart"/>	
		<input type="hidden" name="business" value="${business }"/>
		
		<!-- danh sach san pham | nhung field nay do paypal quy dinh-->
	 	<c:forEach var="item" items="${sessionScope.cart}" varStatus="i">
	 	<input type="hidden" name="item_number_${i.index+1}" value="${item.product.id}"/> 
	 	<input type="hidden" name="item_name_${i.index+1}" value="${item.product.name}"/> 
	 	<input type="hidden" name="quantity_${i.index+1}" value="${item.quantity}"/> 
	 	<input type="hidden" name="amount_${i.index+1}" value="${item.product.price }"/>
		</c:forEach>
		<input type="submit" value="checkout"/>	
	</form>
</body>
</html>