<%--
  Created by IntelliJ IDEA.
  User: alex.santos
  Date: 9/24/2019
  Time: 1:42 PM
  To change this template use File | Settings | File Templates.
--%>


<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Cadastro</title>
</head>
<body>
	<form:form action="/cadastro" name="cadastroForm" method="POST">
		<div align="center">
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
					<td>Email</td>
					<td><input type="text" name="email"/></td>
				</tr>
				<tr>
					<td></td>
					<td><input type="submit" value="SALVAR "/></td>
				</tr>
			</table>
			<div style="color: red">${error}</div>
		</div>
	</form:form>
	<div align="center">
		<form action="/login" method="GET" >
			<input type="submit" value="Go to LOGIN >>"/>
		</form> <br>
	</div>

<%--	--%>
	<div style="color: red" class="align-content-center">${error}</div>
	<c:if test="${msg != null}">
		<div style="color: red">${msg}</div> <br>
	</c:if>
	<%--	LOGIN BOOTSTRAP 4--%>
	<div class="wrapper fadeInDown">
		<div id="formContent">
			<!-- Tabs Titles -->

			<!-- Icon -->
			<div class="fadeIn first img-login">
				<img src="../../resources/img/man.svg" id="icon" alt="User Icon" />
			</div>

			<!-- Login Form -->
			<form:form action="/loginForm" name="loginForm" method="POST">
				<input type="text" id="login" class="fadeIn second" name="nome" placeholder="login">
				<input type="text" id="password" class="fadeIn third" name="senha" placeholder="password">
				<input type="submit" class="fadeIn fourth" value="Log In">
			</form:form>

			<!-- Remind Passowrd -->
			<div id="formFooter">
				<a class="underlineHover" href="#">Esqueceu a senha?</a>
			</div>
			<div style="color:red">${error}</div>
			<div id="formFooter">
				<a class="underlineHover" href="/home/register">Cadastro</a>
			</div>
		</div>
	</div>
</body>
</html>
