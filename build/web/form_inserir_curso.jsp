<%-- 
    Document   : form_inserir_curso
    Created on : 16/11/2018, 16:46:44
    Author     : Raphael
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="css/style_index.css">
        <link rel="stylesheet" href="css/buttons.css">
        <link rel="stylesheet" href="css/forms.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>NutriChef - Escola de Culinária</title>
    </head>
    <body>
        <div class="principal">
        <div class="imgcontainer">
            <img src="img/logo.PNG" alt="Avatar" class="avatar">
        </div>
        <%@include file="menu.jsp" %>
        <h1 id="form">Novo Curso</h1>
        <form class="form" action="inserir_curso.do" method="post">
            <label id="ver">Nome:</label><input id="for" type="text" name="nome" size="60" placeholder="Nome" required/><br/><br/>
            <label id="ver">Preço:</label><input id="for" type="text" name="preco" size="60" placeholder="Preço" required/><br/><br/>
            <input class="button" type="submit" value="Inserir"/>
        </form>
        </div>
    </body>
</html>
