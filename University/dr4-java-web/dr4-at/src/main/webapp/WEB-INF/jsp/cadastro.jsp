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
	<link rel="stylesheet" href="../../resources/css/login.css">
	<link rel="stylesheet" href="../../resources/css/bootstrap.min.css">
	<title>Cadastro</title>
</head>
<body>
	<div class="text-lg-center alert" style="color:red">${error}</div>

	<c:if test="${msg != null}">
		<div class="wrapper fadeInDown" style="color: red">${msg}</div> <br>
	</c:if>
	<%--	LOGIN BOOTSTRAP 4--%>
	<div class="wrapper fadeInDown">
		<div id="formContent">
			<!-- Tabs Titles -->

			<!-- Icon -->
			<div class="fadeIn first img-login">
				<img src="../../resources/img/man.svg" id="icon" alt="User Icon" />
			</div>

			<!-- Register Form -->
			<form:form action="/register" modelAttribute="registerForm" method="POST" cssClass="m-1">
				<div class="m-5">
					<input type="text" id="login1" class="fadeIn second" name="nome" placeholder="Nome">
					<input type="text" id="login2" class="fadeIn third" name="email" placeholder="Email">
					<input type="text" id="login3" class="fadeIn third" name="senha" placeholder="Senha">
				</div>
				<input type="submit" class="fadeIn fourth" value="Cadastro">
			</form:form>

			<!-- Login -->
			<div class="text-lg-center alert" style="color:red">${error}</div>
			<div id="formFooter">
				<a class="underlineHover" href="/login">Log in</a>
			</div>
		</div>
	</div>

	<script src="../../resources/js/jquery-3.2.1.slim.min.js"></script>
	<script src="../../resources/js/popper.min.js"></script>
	<script src="../../resources/js/bootstrap.min.js"></script>
</body>
</html>


<%--OLD
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
--%>