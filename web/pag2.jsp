<%-- 
    Document   : pag2
    Created on : 25/10/2016, 10:22:22 AM
    Author     : Gerardo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page  import="paq.Hello" %>
<%@page import="paq.ClienteDAO" %>
<%@page import="paq.Cliente" %>
<%@page import="paq.ProductoDAO" %>
<%@page import="paq.Producto" %>

<jsp:useBean id="c" class="paq.Cliente"></jsp:useBean>
<jsp:setProperty property="*" name="c"></jsp:setProperty>

<jsp:useBean id="p" class="paq.Producto"></jsp:useBean>
<jsp:setProperty property="*" name="p"></jsp:setProperty>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>soy el mapa!</h1>
        <%= Hello.saludar()%>
        
        <!-- Testing de clase ClienteDAO -->
        
           
        <!-- Testing de clase ProductoDAO -->
        <% ProductoDAO.getAllRecords(); ProductoDAO.getRecordById(1); %>
        <% p.setId(1); p.setNombre("Galletas"); ProductoDAO.update(p); %>
        
                
    </body>
</html>
