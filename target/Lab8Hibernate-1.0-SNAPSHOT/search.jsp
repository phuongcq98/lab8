<%-- 
    Document   : search
    Created on : Dec 6, 2018, 2:02:43 
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Search</title>
    </head>
    <body>
        <div align="center">
            <h1>Search</h1>
            
            <form action="SearchController" method="GET">
                <b>Nhap ten: </b>
                <input type="text" name="search" size="30" value=""/>
                <input type="submit" size="2" value="Search"/>
            </form>
            <a href="createEmp.jsp">Tao tai khoan</a>
        </div>
    </body>
</html>
