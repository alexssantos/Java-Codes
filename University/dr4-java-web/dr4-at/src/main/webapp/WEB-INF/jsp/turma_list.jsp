<%--
  Created by IntelliJ IDEA.
  User: aarka
  Date: 10/2/2019
  Time: 1:24 AM
  To change this template use File | Settings | File Templates.
--%>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>Listagem de Turmas</title>

    <!-- Bootstrap core CSS -->
    <link rel="stylesheet" href="../../resources/css/bootstrap.min.css">
</head>
<body class="d-flex h-100 flex-column">

    <%@ include file="shared/navbar.jspf" %>

    <div class="container text-center">
        <h2 class="m-3">Turmas</h2>

        <table class="table table-dark text-center">
            <tr class="thead-dark">
                <th>#</th>
                <th>ID</th>
                <th>CÓDIGO</th>
                <th>SALA</th>
                <th>PROFESSOR</th>
                <th>DISCIPLINA</th>
            </tr>
            <c:forEach var="turma" items="${LIST}">
                <tr>
                    <td>${LIST.indexOf(turma)}</td>
                    <td>${turma.id}</td>
                    <td>${turma.codigo}</td>
                    <td>${turma.sala}</td>
                    <td>${turma.professor.usuario.nome}}</td>
                    <td>${turma.disciplina.codigo}</td>
                    <td>${turma.disciplina.nome}</td>
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
