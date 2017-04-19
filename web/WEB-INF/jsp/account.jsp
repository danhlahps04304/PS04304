<%-- 
    Document   : account
    Created on : Feb 13, 2017, 2:21:10 AM
    Author     : L.A.H.D
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <base href="${pageContext.servletContext.contextPath}/">
    </head>
    <body
        <jsp:include page="../menu.jsp"/>     
        <h1>Account Management</h1>
        
        <form:form action="account.htm" modelAttribute="user">
            <div>Username</div>
            <form:input path="Username"/>
            <div>Password</div>
            <form:input path="Password"/>

            <div>Full name</div>
            <form:input path="Fullname"/>
            <div>
                <button name="btnInsert">Thêm tài khoản</button>
                <button name="btnUpdate">Cập nhật</button>         
            </div>
        </form:form>
        <br/>
        
        <table border="1">
            <tr>
                <td>Username</td>
                <td>Password</td>
                <td>Full name</td>
            </tr>
            <c:forEach var="rows" items="${listUser}">
            <form action="account/delete.htm">
            <tr>
                <td>${rows.username}</td>
                <td>${rows.password}</td>
                <td>${rows.fullname}</td>
                <c:url var="del" value="account/edit.htm">
                    <c:param name="txtUsername" value="${rows.username}"/>
                    <c:param name="txtPassword" value="${rows.password}"/>
                    <c:param name="txtFN" value="${rows.fullname}"/>
                </c:url>
                <td><a href="${del}">Edit</td>
                <td>
                    <input type="hidden" name="txtUsername" value="${rows.username}"/>
                    <input type="submit" name="action" value="Delete"/>
                </td>
            </tr>
            </form>
        </c:forEach>
        </table>
    </body>
</html>
