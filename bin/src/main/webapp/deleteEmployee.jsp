<%-- 
    Document   : deleteEmployee
    Created on : Dec 6, 2018, 6:08:55 AM
    Author     : huynq
--%>
<%@ page errorPage="error.jsp" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Delete Employee!</h1>
        <form action=" <c:url value="/DeleteEmployeeController" /> " method="post">
            <input type="text" name="userId" value="${emp.userId}" readonly/>
            <input type="text" name="name" value="${emp.name}" readonly/>
            <button type="submit">Submit</button>
            <a href="search.jsp">Back</a>
        </form>
    </body>
</html>
