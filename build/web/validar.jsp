<%-- 
    Document   : validar
    Created on : 29/08/2018, 06:45:22 PM
    Author     : Diana
--%>

<%@page import="clases.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
String usuario=request.getParameter("usuario");
String clave=request.getParameter("clave");

Usuario datos=new Usuario("'"+usuario+"'","'"+clave+"'");
if (datos.getUsuario()!=null) {
        response.sendRedirect("principal.jsp");
}else{
    response.sendRedirect("index.jsp");
}

%>