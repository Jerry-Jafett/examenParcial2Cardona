<%-- 
    Document   : addCliente
    Created on : 25/10/2016, 08:48:15 PM
    Author     : Gerardo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="paq.Cliente" %>

<jsp:useBean id="c" class="paq.Cliente" ></jsp:useBean>
<jsp:setProperty property="*" name="c"></jsp:setProperty>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Agregar Cliente</title>
    </head>
    <body>
        <h1>Agregar Cliente</h1>
        
        <form method="post" action="addCliente.jsp">
            ID: <input type="text" name="id_c"><br>
            Nombre: <input type="text" name="nom"><br>
            Saldo: <input type="text" name="saldo"><br>
            <input type="submit" name="submit">
        </form>
        
        
    </body>
</html>
