<%-- 
    Document   : sair
    Created on : 03/10/2018, 16:59:08
    Author     : Administrador
--%>

<%

session.removeAttribute("funcionario");
response.sendRedirect("login.jsp");

%>