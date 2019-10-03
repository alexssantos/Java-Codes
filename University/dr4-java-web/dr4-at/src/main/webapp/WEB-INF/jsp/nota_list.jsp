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
    <title>Listagem de Notas</title>

    <!-- Bootstrap core CSS -->
    <link rel="stylesheet" href="../../resources/css/bootstrap.min.css">
</head>
<body class="d-flex h-100 flex-column">

    <%@ include file="shared/navbar.jspf" %>

    <div class="container text-center">
        <h2 class="m-3">Notas</h2>

        <table class="table text-center">
            <tr class="thead-dark">
                <th>#</th>
                <th>ID NOTA</th>
                <th>ALUNO</th>
                <th>NOTA AV1</th>
                <th>NOTA AV2</th>
                <th>TURMA</th>
                <th>DISCIPLINA</th>
                <th>PROFESSOR</th>
                <th>CURSO</th>
            </tr>
            <c:forEach var="nota" items="${LIST}">
                <tr>
                    <td>${LIST.indexOf(nota)}</td>
                    <td>${nota.id}</td>
                    <td>${nota.aluno.usuario.nome}</td>
                    <td>${nota.av1}</td>
                    <td>${nota.av2}</td>
                    <td>${nota.turma.nome}</td>
                    <td>${nota.turma.disciplina.nome}</td>
                    <td>${nota.turma.Professores.usuario.nome}</td>
                    <td>${nota.turma.disciplina.curso.nome}</td>
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
