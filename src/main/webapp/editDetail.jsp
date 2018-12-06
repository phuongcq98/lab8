<%-- 
    Document   : editDetail
    Created on : Dec 6, 2018, 6:10:00 AM
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
        <h1>Edit Detail!</h1>
        <form action=" <c:url value="/EditDetailController" /> " method="post">
            <input type="text" name="detailId" value="${de.detailId}" readonly/>
            <input type="text" name="userId" value="${de.employee.userId}" readonly/>
            <input type="text" name="addressName" value="${de.addressName}"/>
            <input type="text" name="phoneNumber" value="0${de.phoneNumber}"/>
            <button type="submit">Submit</button>
            <button type="reset">Reset</button>
            <a href="search.jsp">Back</a>
        </form>
    </body>
</html>
