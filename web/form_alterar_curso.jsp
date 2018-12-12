<%-- 
    Document   : form_alterar_curso
    Created on : 16/11/2018, 16:53:30
    Author     : Raphael
--%>

<%@page import="modelo.CursoDAO"%>
<%@page import="modelo.Curso"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
  
Curso c = new Curso();

try{
    int id = Integer.parseInt(request.getParameter("id"));
    CursoDAO cDAO = new CursoDAO();
    c = cDAO.carregarPorId(id);
}catch(Exception e){
    out.print("Erro: "+e);
}

%>

<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="css/style_index.css">
        <link rel="stylesheet" href="css/buttons.css">
        <link rel="stylesheet" href="css/forms.css">
        <link rel="stylesheet" href="css/tables.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>NutriChef - Escola de Culinária</title>
    </head>
    <body>
        <div class="principal">
            <div class="imgcontainer">
                <img src="img/logo.PNG" alt="Avatar" class="avatar">
            </div>
            <%@include file="menu.jsp" %> 
            <h1 id="form">Alterando Cursos</h1>
            <form class="form" action="alterar_curso.do" method="post">
                <input type="hidden" value="<%=c.getId() %>" name="id"/>
                <label id="ver">Nome:</label><br/><input id="for" type="text" value="<%=c.getNome() %>" name="nome" size="60" placeholder="Nome" required/><br/><br/>
                <label id="ver">Preço:</label><br/><input id="for" type="text" value="<%=c.getPreco() %>" name="preco" size="60" placeholder="Preço" required/><br/><br/>
                <input class="button" type="submit" value="Salvar"/>
            </form>
        </div>
    </body>
</html>
