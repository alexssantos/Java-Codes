<%--
  Created by IntelliJ IDEA.
  User: alex.santos
  Date: 9/24/2019
  Time: 1:43 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta charset="utf-8">
<%--	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">--%>

	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
	<title>Spring Login Form</title>
</head>
<body>
	<%@ include file="/WEB-INF/jsp/shared/navbar.jspf" %>

	<form:form action="/login" name="loginForm" method="POST">
		<div align="center">
			<div style="color: red">${error}</div>
			<c:if test="${msg != null}">
				<div style="color: red">${msg}</div> <br>
			</c:if>
			<table>
				<tr>
					<td>User Name</td>
					<td><input type="text" name="nome" /></td>
				</tr>
				<tr>
					<td>Password</td>
					<td><input type="password" name="senha" /></td>
				</tr>
				<tr>
					<td></td>
					<td><input type="submit" value="Login" /></td>
				</tr>
			</table>
		</div>
	</form:form>



	<div align="center">
		<form action="/cadastro" method="GET" >
			<input type="submit" value="Go to REGISTER >>"/>
		</form> <br>
	</div>

	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
</body>
</html>