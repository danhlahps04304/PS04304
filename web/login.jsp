<%-- 
    Document   : login
    Created on : Feb 10, 2017, 12:02:05 AM
    Author     : L.A.H.D
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <base href="${pageContext.servletContext.contextPath}/">
        <link href="css/login.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <div class="login">
            <header class="header">
              <span class="text">LOGIN</span>
              <span class="loader"></span>
            </header>
            <form action="LoginController" class="form">  
              <input class="input" type="text" placeholder="Username" name="txtUser">
              <input class="input" type="password" placeholder="Password" name="txtPass">
              <button class="btn" type="submit" name="action" value="Login"></button>
            </form>
        </div>
        <div class="error">
            ${ERROR}
        </div>


</body>
</html>
