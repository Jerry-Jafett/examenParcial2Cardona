<%-- 
    Document   : pag2
    Created on : 25/10/2016, 10:22:22 AM
    Author     : Gerardo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="paq.Hello" %>
<%@page import="paq.ClienteDAO" %>
<%@page import="paq.Cliente" %>
<%@page import="paq.ProductoDAO" %>
<%@page import="paq.Producto, paq.MovimientoDAO, paq.Movimiento, java.util.*" %>

<jsp:useBean id="c" class="paq.Cliente"></jsp:useBean>
<jsp:setProperty property="*" name="c"></jsp:setProperty>

<jsp:useBean id="p" class="paq.Producto"></jsp:useBean>
<jsp:setProperty property="*" name="p"></jsp:setProperty>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%
    List<Movimiento> lista = MovimientoDAO.getAllRecords();
    request.setAttribute("lista", lista);
%>

<jsp:useBean id="mov" class="paq.Movimiento"></jsp:useBean>
    
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>soy el mapa!</h1>
        Impresion de movimientos
        
        
        
        <c:forEach items="${lista}" var="m">
            ${m}
        </c:forEach>
        
        <br>por id!
    <%= MovimientoDAO.getRecordById(2) %>
                
    </body>
</html>
