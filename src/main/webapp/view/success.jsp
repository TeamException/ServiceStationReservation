<%-- 
    Document   : sucess
    Created on : Dec 21, 2016, 10:03:23 PM
    Author     : Tharindu Jayathilake
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <% String msg = (String)request.getAttribute("msg"); %>
        <h1><% out.print(msg); %></h1>
    </body>
</html>
