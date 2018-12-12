<%-- 
    Document   : form_inserir_menu
    Created on : 14/08/2018, 16:12:33
    Author     : Administrador
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Novo Menu</title>
    </head>
    <body>
        <%@include file="menu.jsp" %>
        <h1>Novo Menu</h1>
        <form action="inserir_menu.do" method="post">
            Título:<input type="text" name="titulo" size="50" required/><br/>
            Link:<input type="text" name="link" size="50" required/><br/>
            Ícone:<input type="text" name="icone" size="50"/><br/>
            <input type="submit" value="Salvar"/>
        </form>
    </body>
</html>
