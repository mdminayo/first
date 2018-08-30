<%-- 
    Document   : actualizarGasto
    Created on : 29/08/2018, 09:34:48 PM
    Author     : Diana
--%>

<%@page import="clases.Gasto"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%

%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Formulario Gasto</h1>
        <form action="grabar.jsp" method="post" >
            <table>
                <tr>
                    <th>Fecha</th>
                    <th><input type="date" name="fecha"></th>
                </tr>
                <tr>
                    <th>Detalle</th>
                    <th><textarea name="detalle"></textarea></th>
                </tr>
                <tr>
                    <th>Valor</th>
                    <th><input type="number" name="valor"></th>
                </tr>
                <tr>
                    <th>Usuario</th>
                    <th><input type="text" name="usuario"></th>
                </tr>
            </table>
            <input type="submit" value="grabar">
        </form>
    </body>
</html>
