<%-- 
    Document   : verclientes
    Created on : 26/10/2016, 08:30:49 AM
    Author     : Gerardo
--%>

<%@page import="paq.Cliente,paq.ClienteDAO,java.util.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<% 
    List<Cliente> lista = ClienteDAO.getAllRecords();
    request.setAttribute("lista", lista);
%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Clientes Registrados</title>
    </head>
    <body>
        <h1>Lista de clientes registrados</h1>
        
        
        <table border="1" width="50%">
            <tr><th>ID</th><th>Nombre</th><th>Saldo</th></tr>
            
            <c:forEach items="${lista}" var="cl">
            <tr>
                <td>${cl.getId() }</td>            
                <td>${cl.getNombre() }</td>            
                <td>${cl.getSaldo() }</td>    
            </tr>
            </c:forEach>
            
        </table>
        
        
    </body>
</html>
