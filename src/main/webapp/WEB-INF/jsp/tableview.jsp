<%@ page language="java" %>
<%@ page contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ include file="/WEB-INF/jsp/includes.jsp" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Table Status</title>
</head>
<body>
	<form action="table.do" method="post">
		<table>
			<tr>
				<td>Table ID:</td>
				<td><input type="text" name="tableID" value="${table.tableID}"/></td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit" name="action" value="search" />
					<input type="submit" name="action" value="update" />
				</td>
			</tr>
			<tr></tr>
		</table>
	</form>
	<br />
	<table border="1">
		<tr>
			<th>TableID</th>
			<th>TableState</th>
			<th>TableStateName</th>
		</tr>
		<tr>
			<td>${table.tableID}</td>
			<td>${table.tableStateEntity.stateID}</td>
			<td>${table.tableStateEntity.stateDesc}</td>
		</tr>
	</table>
</body>
</html>