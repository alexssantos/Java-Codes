<%--
  Created by IntelliJ IDEA.
  User: alex.silva
  Date: 20/08/2019
  Time: 08:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.time.LocalTime" %>
<%!
    LocalTime now = LocalTime.now();

String obtemMsgInicial(){

    String response = null;

    if (now.isAfter(LocalTime.parse("05:00")) && now.isBefore(LocalTime.parse("12:00"))){
        response = "Bom Dia!";
    }
    else if (now.isAfter(LocalTime.parse("12:00")) && now.isBefore(LocalTime.parse("18:00"))){
        response = "Boa Tarde!";
    }
    else {
        response = "Boa Noite!";
    }
    return response;
}

String obtemHora() {
    String hora = "" + now.getHour() + ":" + now.getMinute();
    return hora;
}
%>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>JSP Page</title>
</head>
<body>
    <%=obtemMsgInicial()%>  <%=request.getParameter("option")%> <%=request.getParameter("nome")%>
    <br>
    <%=obtemHora()%>
</body>
</html>