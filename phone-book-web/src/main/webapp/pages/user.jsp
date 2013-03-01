<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Phone Book :: User</title>
</head>
<body>
	<fieldset>
		<legend>
			<b>User</b>
		</legend>
		<table>
			<thead>
				<tr>
					<th>First Name</th>
					<th>Last Name</th>
					<th>Email</th>
					<th>Username</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td><c:out value="${user.firstName}" /></td>
					<td><c:out value="${user.lastName}" /></td>
					<td><c:out value="${user.email}" /></td>
					<td><c:out value="${user.username}" /></td>
					<td><c:out value="${user.password}" /></td>
				</tr>
			</tbody>
		</table>
	</fieldset>
	<c:if test="${user.phones.size() > 0}">
		<tbody>
		<c:forEach var="phone" items="${user.phones}">
				<tr>
					<td><c:out value="${phone.number}" /></td>
				</tr>
		</c:forEach>
		</tbody>
	</c:if>
	<a href="phoneRegistration?userId=${user.id}">add phone</a>
</body>
</html>