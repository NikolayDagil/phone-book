<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<title>Phone Book :: Phone Registration</title>
	</head>
	<body>
		<form action="phoneRegistration?userId=${userId}" method="post">
			<fieldset>
				<legend>
					<b>Add Phone</b>
				</legend>
				<table>
					<tr>
						<td>Number</td>
						<td><input type="number" name="mobile"></td>
					</tr>
					<tr>
						<td>Type:</td>
						<td><input type="radio" name="type" value="home phone">
							Home phone <input type="radio" name="type" value="mobile" checked>
							Mobile</td>
					</tr>
				</table>
				<table>
					<tr>
						<td><input type="submit" value="add phone"></td>
					</tr>
				</table>
			</fieldset>
		</form>
	</body>
</html>