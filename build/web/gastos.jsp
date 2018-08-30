<%-- 
    Document   : gastos
    Created on : 29/08/2018, 08:45:00 PM
    Author     : Diana
--%>

<%@page import="clases.Gasto"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%

Gasto[] datos=Gasto.getDatosEnObjetos(null);
String lista="";
for (int i = 0; i < datos.length; i++) {
        Gasto gasto = datos[i];
        lista+="<tr>";
        lista+="<td>"+gasto.getId()+"</td>";
        lista+="<td>"+gasto.getFecha()+"</td>";
        lista+="<td>"+gasto.getDetalle()+"</td>";
        lista+="<td>"+gasto.getValor()+"</td>";
        lista+="<td>"+gasto.getUsuario()+"</td>";
        lista+="</tr>";
    }

%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Gastos</h1>
        <table border="3">
            <tr>
                <th>id</th>
                <th>fecha</th>
                <th>detalle</th>
                <th>Valor</th>
                <th>Usuario</th> 
                <th><a href="actualizarGasto.jsp">Adicionar</a></th> 
            </tr>
            <%=lista%>
        </table>
    </body>
</html>
