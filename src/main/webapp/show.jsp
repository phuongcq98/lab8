<%-- 
    Document   : show
    Created on : Dec 6, 2018, 2:03:52 AM
    Author     : huynq
--%>
<%@ page errorPage="error.jsp" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Show</title>
    </head>
    <body>
        <div align="center">
            
            <br><br>
            <h2>Employee</h2>
            <table border="1">
                <thead>
                    <tr>
                        <th>Employee ID</th>
                        <th>Name</th>            
                        <th>Update</th>
                        <th>Delete</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="list" items="${list}">
                        <tr>
                            <td>${list.employee.userId}</td>
                            <td>${sessionScope.USERS}</td>
                            <td><a href=" <c:url value="/EditEmployeeController?userId=${list.employee.userId}" /> ">Edit</a></td>
                            <td><a href=" <c:url value="/DeleteEmployeeController?userId=${list.employee.userId}" /> ">Delete</a></td>
                        </tr>
                    </c:forEach>
                </tbody>

            </table>

            <br><br>
            <h2>Detail</h2>
            <table border="1">
                <thead>
                    <tr>                        
                        <th>Detail ID</th>
                        <th>Dia chi</th>        
                        <th>So dien thoai</th>       
                        <th>Update</th>
                        <th>Delete</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="list" items="${list}">
                        <tr>
                            <td>${list.detailId}</td>
                            <td>${list.addressName}</td>
                            <td>0${list.phoneNumber}</td>
                            <td><a href=" <c:url value="/EditDetailController?detailId=${list.detailId}" /> ">Edit</a></td>
                            <td><a href=" <c:url value="/DeleteDetailController?detailId=${list.detailId}" /> ">Delete</a></td>
                        </tr>
                    </c:forEach>
                </tbody>

            </table>
            

        </div>
    </body>
</html>
