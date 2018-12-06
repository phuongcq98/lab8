<%-- 
    Document   : createEmp
    Created on : Dec 6, 2018, 7:46:27 AM
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
    <body align="center">
        <h1>Create Employee!</h1>
        <form action=" <c:url value="/CreateController" /> " method="post">
            <br>
            User Id: <input type="text" name="userId" value=""/>
            Name: <input type="text" name="name" value=""/>
            <br><br><br>
            <h3>Address 1:</h3><br><br>
            Detail Id: <input type="text" name="detailId1" value=""/>
            Address Name: <input type="text" name="addressName1" value=""/>
            Phone Number: <input type="text" name="phoneNumber1" value=""/> 
            <br><br><br>
            <h3>Address 2:</h3><br><br>
            Detail Id: <input type="text" name="detailId2" value=""/>
            Address Name: <input type="text" name="addressName2" value=""/>
            Phone Number: <input type="text" name="phoneNumber2" value=""/> 
            <br><br><br>
            <button type="submit">Submit</button>
            <button type="reset">Reset</button>
            <a href="search.jsp">Back</a>
        </form>
    </body>
</html>
