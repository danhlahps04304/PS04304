<%-- 
    Document   : staff
    Created on : Feb 27, 2017, 4:06:33 PM
    Author     : L.A.H.D
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="f" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Staff</title>
        <base href="${pageContext.servletContext.contextPath}/">
    </head>
    <body>
        <jsp:include page="../menu.jsp"/>
        <h1>Staff Management</h1>
        
        <form:form action="staff.htm" modelAttribute="staff">
            <div>Mã nhân viên</div>
            <form:input path="ID" />
            <div>Hình ảnh</div>
            <form:input path="Photo"/>
            <div>Họ và tên</div>
            <form:input path="Name"/>
            <div>Giới tính</div>
            <form:select path="Gender">
                <form:option value="true">Nam</form:option>
                <form:option value="false">Nữ</form:option>
            </form:select>
            <div>Ngày sinh</div>
            <form:input path="Date"/>
            
            <div>Email</div>
            <form:input path="Email"/>
            <div>Số điện thoại</div>
            <form:input path="Phone"/>
            <div>Lương</div>
            <form:input path="Salary"/>
            <div>Ghi chú</div>
            <form:input path="Note"/>
            <div>Phòng ban</div>
            <form:input path="DepartId"/>
            
            <div>
                <button name="btnInsert">Thêm nhân viên</button>
                <button name="btnUpdate">Cập nhật thông tin</button>         
            </div>
        </form:form>
    
        <table border="1">
            <tr>
                <td>ID</td>
                <td>Name</td>
                <td>Gender</td>
                <td>Date</td>
                <td>Photo</td>
                <td>Email</td>
                <td>Phone</td>
                <td>Salary</td>
                <td>Note</td>
                <td>Depart ID</td>
            </tr>
            <c:forEach var="rows" items="${listStaff}">
                <form action="staff/delete.htm">
                <tr>
                    <td>${rows.ID}</td>
                    <td>${rows.name}</td>
                    <td>${rows.gender?'Nam':'Nữ'}</td>
                    <td>
                        <f:parseDate value="${rows.date}" pattern="yyyy-MM-dd" var="fmtdate"/>
                        <f:formatDate value="${fmtdate}" pattern="dd-MM-yyyy" />
                    </td>
                    <td>${rows.photo}</td>
                    <td>${rows.email}</td>
                    <td>${rows.phone}</td>
                    <td>
                        <f:formatNumber value="${rows.salary}" type="currency"/>
                    </td>
                    <td>${rows.note}</td>
                    <td>${rows.departId}</td>
                    <td><a href="${del}">Sửa</a></td>
                            <td>
                                <input type="hidden" name="txtMaNV" value="${rows.ID}"/>
                                <input type="submit" name="action" value="Xóa"
                            </td>
                </tr>
                </form>
            </c:forEach>
        </table>
    </body>
</html>
