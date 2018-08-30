<%-- 
    Document   : grabar
    Created on : 29/08/2018, 09:41:49 PM
    Author     : Diana
--%>

<%@page import="clases.Gasto"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%

Gasto gasto=new Gasto();
gasto.setFecha(request.getParameter("fecha"));
gasto.setDetalle(request.getParameter("detalle"));
gasto.setValor(request.getParameter("valor"));
gasto.setUsuario(request.getParameter("usuario"));
gasto.grabar();

%>
