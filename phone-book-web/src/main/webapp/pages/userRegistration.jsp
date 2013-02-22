<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<title>Phone Book :: User Registration</title>
	</head>
	<body>
		<form action="userRegistration" method="post">
			<fieldset>
				<legend>
					<b>Add User</b>
				</legend>
				<table>
					<tr>
						<td>Username</td>
						<td><input type="text" name="username"></td>
					</tr>
					<tr>
						<td>Password</td>
						<td><input type="password" name="password"></td>
					</tr>
					<tr>
						<td>Email</td>
						<td><input type="text" name="email"></td>
					</tr>
					<tr>
						<td>First Name</td>
						<td><input type="text" name="firstName"></td>
					</tr>
	
					<tr>
						<td>Last Name</td>
						<td><input type="text" name="lastName"></td>
					</tr>
					<tr>
						<td><input type="submit" value="registr"></td>
					</tr>
				</table>
			</fieldset>
		</form>
	</body>
</html>