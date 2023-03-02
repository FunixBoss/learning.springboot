<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="s" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>Add Product</title>
	<link rel="stylesheet" href="//code.jquery.com/ui/1.13.2/themes/base/jquery-ui.css">
	<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
	<script src="https://code.jquery.com/ui/1.13.2/jquery-ui.js"></script>
	<script>
		$( function() {
			$( "#created" ).datepicker(
				{
					format: 'dd/mm/yy'
				}
			);
		} );
	</script>
</head>
<body>
	<h3>Edit A Product</h3>
	<a href="${pageContext.request.contextPath }/product/index">Back</a>
	
	<s:form action="${pageContext.request.contextPath}/product/edit" method="POST" 
			modelAttribute="product">
		<table>
			<s:hidden path="id"/>
			<tr>
				<td>Name</td>
				<td><s:input path="name"/></td>
			</tr>
			<tr>
				<td>Price</td>
				<td><s:input path="price"/></td>
			</tr>
			<tr>
				<td>Quantity</td>
				<td><s:input path="quantity"/></td>
			</tr>
			<tr>
				<td>Description</td>
				<td><s:textarea path="description" cols="20" rows="5"/></td>
			</tr>
			<tr>
				<td valign="top">Status</td>
				<td><s:checkbox path="status"/></td>
			</tr>
			<tr>
				<td valign="top">Created</td>
				<td>
					<s:input path="created" id="created"/>
				</td>
			</tr>
			<tr>
				<td>&nbsp;</td>
				<td><input type="submit" value="Register"></td>
			</tr>
		</table>
	</s:form> 
	
</body>
</html>