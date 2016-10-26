<%-- 
    Document   : pag2
    Created on : 25/10/2016, 10:22:22 AM
    Author     : Gerardo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page  import="paq.Hello" %>
<%@page import="paq.ClienteDAO" %>
<%@page import="paq.Cliente" %>
<jsp:useBean id="c" class="paq.Cliente"></jsp:useBean>
<jsp:setProperty property="*" name="c"></jsp:setProperty>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>soy el mapa!</h1>
        <%= Hello.saludar()%>
        <% ClienteDAO.getAllRecords();%>
        <% ClienteDAO.getRecordById(2);%>
        <% c.setId(3); c.setNombre("Jafett"); c.setSaldo(999); ClienteDAO.update(c);%>
           
        
    </body>
</html>
