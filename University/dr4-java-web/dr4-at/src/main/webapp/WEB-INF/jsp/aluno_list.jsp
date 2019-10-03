<%--
  Created by IntelliJ IDEA.
  User: aarka
  Date: 10/2/2019
  Time: 11:35 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>Listagem de Alunos</title>

    <!-- Bootstrap core CSS -->
    <link rel="stylesheet" href="../../resources/css/bootstrap.min.css">
</head>
<body class="d-flex h-100 flex-column">

    <%@ include file="shared/navbar.jspf" %>

    <div class="container text-center">
        <h2 class="m-3">Alunos</h2>

        <table class="table text-center">
            <tr class="thead-dark">
                <th>#</th>
                <th>ID</th>
                <th>NOME</th>
                <th>NASCIMENTO</th>
                <th>CURSO</th>                
                <th>MATRICULA</th>                
                <th>EMAIL</th>
                <th>SENHA</th>                
            </tr>
            <c:forEach var="aluno" items="${LIST}">
                <tr>
                    <td>${LIST.indexOf(aluno)}</td>
                    <td>${aluno.id}</td>
                    <td>${aluno.usuario.nome}</td>
                    <td>${aluno.dataNasc}</td>                    
                    <td>${aluno.curso.nome}</td>                    
                    <td>${aluno.usuario.matricula}</td>                    
                    <td>${aluno.usuario.email}</td>                    
                    <td>${aluno.usuario.senha}</td>                    
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

