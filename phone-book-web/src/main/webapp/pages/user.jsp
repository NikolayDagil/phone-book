<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<title>Phone Book :: User</title>
	</head>
	<body>
		<form action="user?userId=${userId}" method="get">
			<fieldset>
				<legend>
					<b>User</b>
				</legend>
				<table>
					<c:forEach var="map_entry" items="${param}">
						<tr>
							<td><strong><c:out value="${map_entry.key}" /></strong>:</td>
							<td><c:out value="${map_entry.value}" /><br></td>
						</tr>
					</c:forEach>
				</table>
			</fieldset>
		</form>
		<form action="phoneRegistration" method="get">
			<table>
				<tr>
					<td style="visibility: hidden;"><input type="text"
						name="userId" value="<%=request.getAttribute("userId")%>"></td>
				</tr>
				<tr>
					<td><input type="submit" value="add phone"></td>
				</tr>
			</table>
		</form>
</body>
</html>