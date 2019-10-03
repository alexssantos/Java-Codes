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

    <div class="container">
        <h2 class="m-3">Alunos</h2>

        <%-- modelAttribute="cadastroAlunoForm"  --%>
        <form:form action="/aluno/create" method="POST">
            <div class="form-group row">
                <label for="nome">Nome: </label>
                <input type="text" class="form-control" id="nome" placeholder="Nome">                
            </div>
            <div class="form-group row">
                <label for="matricula">matricula: </label>
                <input type="text" class="form-control" id="matricula" placeholder="Digite a Matricula">                
            </div>
            <div class="form-group row">
                <label for="dataNasc" class="col-1 col-form-label">Date</label>
                <div class="col-2">
                    <input class="form-control" type="date" value="2011-08-19" id="dataNasc">
                </div>
            </div>
            <%-- https://eonasdan.github.io/bootstrap-datetimepicker/ --%>            
            <div class="form-group">
                <label for="email">Email: </label>
                <input type="email" class="form-control" id="email" aria-describedby="emailHelp" placeholder="Digite o email">
                <small id="emailHelp" class="form-text text-muted">We'll never share your email with anyoneelse.</small>
            </div>
            <div class="form-group">
                <label for="senha">Senha: </label>
                <input type="password" class="form-control" id="senha" placeholder="Senha">
            </div>            

            <%-- <div class="form-group">
                <label for="curso">Curso: </label>
                <form:select path="nome" id="curso" class="form-control">
                    <form:options items="${CURSO_LIST}" itemLabel="nome" itemValue="nome"/>
                </form:select>
            </div> --%>

            <button type="submit" class="btn btn-primary">Submit</button>
        </form:form>
    </div>

    <%@ include file="shared/footer.jspf" %>

    <!-- Bootstrap 4 core JavaScript
    ================================================== -->
    <script src="../../resources/js/jquery-3.2.1.slim.min.js"></script>
    <script src="../../resources/js/popper.min.js"></script>
    <script src="../../resources/js/bootstrap.min.js"></script>
</body>

</html>



<%-- 
    Form Select
    https://www.mkyong.com/spring-mvc/spring-mvc-dropdown-box-example/ 
--%>