<%@ page language="java" %>
<%@ page contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ include file="/WEB-INF/jsp/includes.jsp" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User Management</title>
</head>
<body>
	<form action="user.do" method="post">
		<table>
			<tr><td>User ID:</td><td><input type="text" name="userID" value="${user.userID}" /></td></tr>
			<tr><td>User Name:</td><td><input type="text" name="userName" value="${user.userName}" /></td></tr>
			<tr><td>Display Name:</td><td><input type="text" name="displayName" value="${user.displayName}" /></td></tr>
			<tr><td>User Role:</td><td> 
				<select name="userRole">
					<c:forEach items="${roleList}" var="role" >
						<c:if test="${role.roleID == user.userRole}">
							<option value="${role.roleID}" selected>${role.roleName}</option>
						</c:if>
						<c:if test="${role.roleID != user.userRole}">
							<option value="${role.roleID}">${role.roleName}</option>
						</c:if>
					</c:forEach>
				</select></td>
			</tr>
			<tr>	
				<td colspan="2">
					<input type="submit" name="action" value="Add" />
					<input type="submit" name="action" value="edit" /> 
					<input type="submit" name="action" value="delete" /> 
					<input type="submit" name="action" value="search" />
				</td>
			</tr>  
		</table>
		<br /><br />
	</form>
	<table border="1">
		<tr>
			<th>User ID</th>
			<th>User Name</th>
			<th>Display Name</th>
			<th>User Role</th>
		</tr>
		<c:forEach items="${userList}" var="user">
			<tr>
				<td>${user.userID}</td>
				<td>${user.userName}</td>
				<td>${user.displayName}</td>
				<td>${user.userRole}</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>