<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@taglib prefix="s" uri="http://www.springframework.org/tags/form" %>
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
	<script>
		$( function() {
			$( "#birthday" ).datepicker(
				{
					format: 'dd/mm/yy'
				}
			);
		} );
	</script>
	<style>
		.error{
			color:red;
		}

	</style>
</head>
<body>
	<h3>Employee Register Form </h3>
	
	<s:form action="${pageContext.request.contextPath}/employee/register" method="POST" 
			modelAttribute="employee" enctype="multipart/form-data">
		<table>
			<tr>
				<td>Username</td>
				<td><s:input type="text" path="username"/></td>
				<td>
					<s:errors path="username" cssClass="error"></s:errors>
				</td>	
			</tr>
			
			<tr>
				<td>Password</td>
				<td><s:password path="password"/></td>
				<td>
					<s:errors path="password" cssClass="error"></s:errors>
				</td>	
			</tr>
			
			<tr>
				<td>Email</td>
				<td><s:input path="email"/></td>
				<td>
					<s:errors path="email" cssClass="error"></s:errors>
				</td>	
			</tr>
			
			<tr>
				<td>Website</td>
				<td><s:input path="website"/></td>
				<td>
					<s:errors path="website" cssClass="error"></s:errors>
				</td>	
			</tr>
			<tr>
				<td>Age</td>
				<td><s:input path="age"/></td>
				<td>
					<s:errors path="age" cssClass="error"></s:errors>
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