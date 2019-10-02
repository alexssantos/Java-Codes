<%--
  Created by IntelliJ IDEA.
  User: aarka
  Date: 26/09/2019
  Time: 02:37
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">    
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>Index Page</title>

    <!-- Bootstrap core CSS -->
    <link rel="stylesheet" href="../../resources/css/bootstrap.min.css">
    <!-- Custom styles for this template -->
    <%-- <link rel="stylesheet" href="../../resources/css/home.css">  --%>
  </head>
  <body class="text-center">

    <div>
      <%@ include file="shared/navbar.jspf" %>

      <main role="main" class="inner cover h-100 mx-center">
          <h1 class="cover-heading">${name}, a vida é bela!</h1>
          <p class="lead">email: ${email}</p>
          <p class="lead">${msg}</p>
        </main>

        <footer class="mastfoot mt-auto">
          <div class="inner">
            <p>Cover template for <a href="https://getbootstrap.com/">Bootstrap</a>, by <a href="https://twitter.com/mdo">@mdo</a>.</p>
          </div>
        </footer>
    </div>

    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="../../resources/js/jquery-3.2.1.slim.min.js"></script>
    <script src="../../resources/js/popper.min.js"></script>
    <script src="../../resources/js/bootstrap.min.js"></script>
  </body>
</html>
