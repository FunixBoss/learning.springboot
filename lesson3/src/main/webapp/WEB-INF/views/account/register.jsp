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
</head>
<body>
	<h3>Register Form  Á ớ ố ứ </h3>
	
	<s:form action="${pageContext.request.contextPath}/register" method="POST" modelAttribute="account" enctype="multipart/form-data">
		<table>
			<s:hidden path="id"/>
			<tr>
				<td>Username</td>
				<td><input type="text" name="username"/></td>
			</tr>
			<tr>
				<td>Password</td>
				<td><input type="password" name="password" id=""></td>
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
				<td valign="top">Languages</td>
				<td>
					<s:checkboxes items="${languages}" itemLabel="name" 
						itemValue="id" path="languages" dilimiter="<br/>"/>
				</td>
			</tr>
			<tr>
				<td valign="top">Gender</td>
				<td>
					<s:radiobutton path="gender" value="male"/> Male
					<s:radiobutton path="gender" value="female"/> Female
				</td>
			</tr>
			<tr>
				<td valign="top">Cert</td>
				<td>
					<s:radiobuttons items="${certs}" itemLabel="name" itemValue="id"
						path="cert" delimiter="<br/>"/>
				</td>
			</tr>
			<tr>
				<td valign="top">Role</td>
				<td>
					<!-- items=${role} -> láº¥y tá»« controller -->
					<s:select items="${roles}" itemLabel="name" itemValue="id" path="role">
					</s:select>
				</td>
			</tr>
			<tr>
				<td valign="top">Birthday</td>
				<td>
					<s:input path="birthday" id="birthday"/>  <!-- Đã tự động hiểu kiểu từ birthdate là Date nên display là Date -->
				</td>
			</tr>
			<tr>
				<td valign="top">Street</td>
				<td>
					<s:input path="address.street"/> <!--map zo th street cá»§a address-->
				</td>
			</tr>

			<tr>
				<td valign="top">Ward</td>
				<td>
					<s:input path="address.ward"/> <!--map zo th ward cá»§a address-->
				</td>
			</tr>
			<tr>
				<td valign="top">Photo</td>
				<td>
					<input type="file" name="photo"/> 
				</td>
			</tr>
			<tr>
				<td valign="top">Photos</td>
				<td>
					<input type="file" name="photos" multiple="multiple"/> 
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