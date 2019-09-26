<%--
  Created by IntelliJ IDEA.
  User: alex.santos
  Date: 9/24/2019
  Time: 1:50 PM
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
	<title>Home Page</title>
</head>
<body>
    <c:if test="${msg != null}">
        <div style="color: green">${msg}</div> <br>
    </c:if>

    <h2>Bem vindo, ${name}</h2><br>

    <form action="/logout" method="GET" >
        <input type="submit" value="LOGOUT"/>
    </form> <br>

</body>
</html>