<%--
  Created by IntelliJ IDEA.
  User: aarka
  Date: 10/2/2019
  Time: 1:24 AM
  To change this template use File | Settings | File Templates.
--%>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>Disciplina Listagem</title>

    <!-- Bootstrap core CSS -->
    <link rel="stylesheet" href="../../resources/css/bootstrap.min.css">
</head>
<body class="d-flex h-100 flex-column">

<%@ include file="shared/navbar.jspf" %>

<div class="container text-center">
    <h2 class="m-3">Disciplinas</h2>

    <table class="table text-center">
        <tr class="thead-dark">
            <th>#</th>
            <th>ID</th>
            <th>NOME</th>
            <th>CÓDIGO</th>
            <th>ID CURSO</th>
            <th>NOME CURSO</th>
        </tr>
        <c:forEach var="discip" items="${LIST}">
            <tr>
                <td>${LIST.indexOf(discip)}</td>
                <td>${discip.id}</td>
                <td>${discip.nome}</td>
                <td>${discip.codigo}</td>
                <td>${discip.curso.id}</td>
                <td>${discip.curso.nome}</td>                
            </tr>
        </c:forEach>
    </table>
</div>

<%@ include file="shared/footer.jspf" %>

<!-- Bootstrap 4 core JavaScript
================================================== -->
<script src="../../resources/js/jquery-3.2.1.slim.min.js"></script>
<script src="../../resources/js/popper.min.js"></script>
<script src="../../resources/js/bootstrap.min.js"></script>
</body>
</html>
