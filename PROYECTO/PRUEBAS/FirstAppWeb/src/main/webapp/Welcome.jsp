<%-- 
    Document   : Welcome
    Created on : 1 ene 2024, 19:04:40
    Author     : TerciodeMarte
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Welcome  <%= request.getSession().getAttribute("nombre") %>
        </h1>
    </body>
</html>
