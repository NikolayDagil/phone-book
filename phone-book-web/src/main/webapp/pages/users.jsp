<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<title>Phone Book :: Users List</title>
	</head>
<body>
	<c:if test="${users.size() > 0}">
		<fieldset>
			<legend>
				<b>Users</b>
			</legend>
			<table>
				<thead>
					<tr>
						<th>#</th>
						<th>First Name</th>
						<th>Last Name</th>
						<th>Email</th>
						<th>Username</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="user" items="${users}">
						<tr>
							<td><a href="user?userId=${user.id}"><c:out
										value="${user.id}" /></a></td>
							<td><c:out value="${user.firstName}" /></td>
							<td><c:out value="${user.lastName}" /></td>
							<td><c:out value="${user.email}" /></td>
							<td><c:out value="${user.username}" /></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</fieldset>
	</c:if>
	<c:if test="${users.size() == 0}">
		<c:set var="errorMessage" value="Введите пользователя"></c:set>
		<c:out value="${errorMessage}" />
	</c:if>
	<form action="userRegistration" method="get">
		<table>
			<tr>
				<td style="visibility: hidden;"><input type="text"
					name="userId" value="<%=request.getAttribute("userId")%>"></td>
			</tr>
			<tr>
				<td><input type="submit" value="add user"></td>
			</tr>
		</table>
	</form>
</body>
</html>