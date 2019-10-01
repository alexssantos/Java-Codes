<%--
  Created by IntelliJ IDEA.
  User: aarka
  Date: 26/09/2019
  Time: 02:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Login page</title>
<%--    <link rel="stylesheet" href="../../resources/css/bootstrap.min.css">--%>
    <link rel="stylesheet" href="../../resources/css/login.css">
    <link rel="stylesheet" href="../../resources/css/bootstrap.min.css">
</head>
<body>

    <c:if test="${msg != null}">
        <%-- <span class="text-lg-center alert">${msg}</span> <br> --%>
        <div class="modal fade success-popup" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
            <div class="modal-dialog modal-sm" role="document">
                <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">×</span></button>
                    <h4 class="modal-title" id="myModalLabel">Thank You !</h4>
                </div>  
            <div class="modal-body text-center">
                <img src="http://osmhotels.com//assets/check-true.jpg">
                <p class="lead">Contact form successfully submitted. Thank you, We will get back to you soon!</p>
                <a href="index.php" class="rd_more btn btn-default">Go to Home</a>
            </div>            
        </div>    
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
            <form:form action="/login" modelAttribute="loginForm" method="POST">
                <input type="text" id="login" class="fadeIn second" name="nome" placeholder="login">
                <input type="text" id="password" class="fadeIn third" name="senha" placeholder="password">
                <input type="submit" class="fadeIn fourth" value="Entrar">
            </form:form>
            <div style="color:red">${error}</div>

            <!-- Remind Passowrd -->
            <div id="formFooter">
                <a class="underlineHover" href="#">Esqueceu a senha?</a>
            </div>
            <div id="formFooter">
                <a class="underlineHover" href="/register">Cadastro</a>
            </div>
        </div>
    </div>


    <script src="../../resources/js/jquery-3.2.1.slim.min.js"></script>
    <script src="../../resources/js/popper.min.js"></script>
    <script src="../../resources/js/bootstrap.min.js"></script>
</body>
</html>
