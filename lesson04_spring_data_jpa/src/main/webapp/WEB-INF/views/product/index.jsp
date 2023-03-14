<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Spring Data Jpa</title>
	<!--  Autocomplete Query UI -->
	<!-- Ngoài ra còn xài của Select2.org -->
	<link rel="stylesheet" href="//code.jquery.com/ui/1.13.2/themes/base/jquery-ui.css"> 
	
	<script type="text/javascript" src="${pageContext.request.contextPath }/resources/js/jquery-3.6.3.min.js"></script>
	<script src="https://code.jquery.com/ui/1.13.2/jquery-ui.js"></script>
	
	<script type="text/javascript">
		$(document).ready(function(){
			$('#textBoxKeyword').autocomplete({
				source: '${pageContext.request.contextPath}/ajax/search'
			})
			
			$('#textBoxName').keyup(function(){
				var keyword = $(this).val();
				$.ajax({
					type: 'GET',
					data : {
						keyword: keyword
					},
					url: '${pageContext.request.contextPath}/ajax/search2',
					success: function(products){
						var s = '';
						for(var i = 0; i < products.length; i++){
							s += '<tr>';
							s += 	'<td>' + products[i].id + '</td>';
							s += 	'<td>' + products[i].name + '</td>'
							s += 	'<td>' + products[i].price + '</td>'
							s += 	'<td>' + products[i].quantity + '</td>'
							s += 	'<td>' + products[i].status + '</td>'
							s += 	'<td>'
							s += 		formatDate(products[i].created)
							s += 	'</td>'
							s += 	'<td>' + products[i].description + '</td>'
							s += 	'<td>'
							s +=		'<a href="/product/edit/' + products[i].id + '">Edit</a>'
							s += 	'</td>'
							s += 	'<td>'
							s += 		'<a href="/product/delete/' + products[i].id + '">Delete</a>'
							s += 	'</td>'
							s += '</tr>'
						}
						$('#tableProduct tbody').html(s);
					}
				}) 
			});
		});
		function formatDate(dateStr) {
	        var dateFormat = "dd/MM/yyyy";
	        var date = new Date(dateStr);
	        var formatter = new Intl.DateTimeFormat('en-GB', {
	            year: 'numeric',
	            month: '2-digit',
	            day: '2-digit'
	        });
	        var parts = formatter.formatToParts(date);
	        var formattedDate = "";
	        for (var i = 0; i < parts.length; i++) {
	            if (parts[i].type === "day") {
	                formattedDate += parts[i].value + "/";
	            }
	            else if (parts[i].type === "month") {
	                formattedDate += parts[i].value + "/";
	            }
	            else if (parts[i].type === "year") {
	                formattedDate += parts[i].value;
	            }
	        }
	        return formattedDate;
	    }
	</script>
</head>
<body>
	<input type="text" id="textBoxKeyword" placeholder="keyword...">

	<h3>Index</h3> 	<!-- SessionFlash trong controller -->
	<h4>${msg}</h4>
	<a href="${pageContext.request.contextPath }/product/add">Add product</a>

	<table border="1" id="tableProduct">
		<thead>
			<tr>
				<td>Id</td>
				<td>
					Name
					<input type="text" id="textBoxName" style="width:60px"/>
				</td>
				<td>Price</td>
				<td>Quantity</td>
				<td>Status</td>
				<td>Created</td>
				<td>Description</td>
				<td>Edit</td>
				<td>Delete</td>
			</tr>
		</thead>
		
		<tbody>
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
		</tbody>			
		
	</table>
	
</body>
</html>