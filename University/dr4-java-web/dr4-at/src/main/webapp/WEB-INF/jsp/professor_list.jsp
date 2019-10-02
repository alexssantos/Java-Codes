<%--
  Created by IntelliJ IDEA.
  User: aarka
  Date: 10/2/2019
  Time: 3:33 PM
  To change this template use File | Settings | File Templates.
--%>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%-- <%@ page language="java" contentType="text/html; charset=UTF-8"%> --%>

<html>
<head>    
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>Listagem de Professores</title>

    <!-- Bootstrap core CSS -->
    <link rel="stylesheet" href="../../resources/css/bootstrap.min.css">
</head>
<body class="d-flex h-100 flex-column">

    <%@ include file="shared/navbar.jspf" %>

    <div class="container text-center">
        <h2 class="m-3">Professores</h2>

        <table class="table text-center">
            <tr class="thead-dark">
                <th>#</th>
                <th>ID</th>
                <th>TITULAÇÃO</th>
                <th>NOME</th>
                <th>MATRICULA</th>
                <th>EMAIL</th>
                <th>SENHA</th>
            </tr>
            <c:forEach var="prof" items="${PROFESSORES}">
                <tr>
                    <td>${PROFESSORES.indexOf(prof)}</td>
                    <td>${prof.id}</td>
                    <td>${prof.titulacao}</td>
                    <td>${prof.usuario.nome}</td>
                    <td>${prof.usuario.matricula}</td>
                    <td>${prof.usuario.email}</td>
                    <td>${prof.usuario.senha}</td>
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

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Listagem de Professores</title>
</head>
<body>

</body>
</html>
