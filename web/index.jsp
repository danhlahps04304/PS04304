<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Welcome to Spring Web MVC project</title>
        <base href="${pageContext.servletContext.contextPath}/">
        <link href="css/index.css" rel="stylesheet" type="text/css"/>
        
    </head>
    <body>
        <center>
            <div class="content">
                <div class="welcomeUser">
                </div>
                <br/>
                <span>User:   ${USER}</span><br/><br/>
                <a href="login.jsp">>> Sign Out <<</a>
                <div class="account">
                    <a href="account/showall.htm"><input class="btn" type="submit" name="action" value="Account Management"/></a>
                </div>
                <div class="staff">
                    <a href="staff/showall.htm"><input class="btn" type="submit" name="action" value="Staff Management"/></a>
                </div>
                <div class="depart">
                    <input class="btn" type="submit" name="action" value="Depart Management"/>
                </div>
                <div class="record">
                    <input class="btn" type="submit" name="action" value="Archive Management"/>
                </div>
                <div class="face">
                    <input class="btn" type="submit" name="action" value="Employees Of The Month"/>
                </div>
            </div>
        </center>
    </body>
</html>
