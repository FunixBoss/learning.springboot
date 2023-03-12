<%@ tag language="java" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ attribute name="content" fragment="true" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/security/tags" %>
<html>
<head>
    <title>My Template</title>
</head>
<body>
    <table align="center" width="800" border="1">
		<tr>
			<td colspan="2">
				Welcome ${pageContext.request.userPrincipal.name}
				<a href="${pageContext.request.contextPath }/account/logout">Logout!</a>
			</td>
		</tr>
		<tr>
			<td width="300" valign="top">
				<ul>
					<s:authorize access="hasRole('ROLE_SUPER_ADMIN')" >
						<li>
							<a href="${pageContext.request.contextPath }/superadmin/invoice">Invoice</a>
						</li>
					</s:authorize>
					<s:authorize access="hasRole('ROLE_SUPER_ADMIN') or hasRole('ROLE_ADMIN')">
						<li>
							<a href="${pageContext.request.contextPath }/admin/category">Category</a>
						</li>
					</s:authorize>
					<s:authorize access="hasRole('ROLE_EMPLOYEE') or hasRole('ROLE_SUPER_ADMIN') or hasRole('ROLE_ADMIN')">
						<li>
						<a href="${pageContext.request.contextPath }/employee/product">Product</a>
					</li>
					</s:authorize>
					
				</ul>
			</td>
			<td width="500" valign="top">
				<jsp:invoke fragment="content"></jsp:invoke>
			</td>
		</tr>
		<tr>
			<td colspan="2">Copyright</td>
		</tr>
    </table>
</body>
</html>


