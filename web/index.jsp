<%-- 
    Document   : index
    Created on : 29/08/2018, 06:38:04 PM
    Author     : Diana
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form method="post" action="validar.jsp" name="iniciar">
            <table>
                <tr>
                    <td>Inicio de Sesion</td>
                </tr>
                <tr>
                    <td>Usuario</td>
                    <td><input type="text" name="usuario"></td>
                </tr>
                <tr>
                    <td>Clave</td>
                    <td><input type="password" name="clave"></td>
                </tr>
            </table>
            <input type="submit" name="ingresar" value="Ingresar">
        </form>
    </body>
</html>
