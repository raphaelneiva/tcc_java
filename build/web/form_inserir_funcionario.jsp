<%-- 
    Document   : form_inserir_funcionario
    Created on : 14/11/2018, 20:04:09
    Author     : Raphael
--%>

<%@page import="modelo.PerfilDAO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="modelo.Perfil"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
    ArrayList<Perfil> perfis = new ArrayList<Perfil>();
    try{
       PerfilDAO pDAO = new PerfilDAO();
       perfis = pDAO.listar();
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
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>NutriChef - Escola de Culinária</title>
    </head>
    <body>
        <div class="principal">
        <div class="imgcontainer">
            <img src="img/logo.PNG" alt="Avatar" class="avatar">
        </div>
         <%@include file="menu.jsp" %>
            <h1 id="form">Novo Funcionário</h1>
            <form class="form" action="inserir_funcionario.do" method="post">
            <label id="ver">Nome:</label><br/><input id="for" type="text" name="nome" placeholder="Nome" size="60" required/><br/><br/>
            <label id="ver">Endereço:</label><br/><input id="for" type="text" name="endereco" placeholder="Enderço" size = "60" required/><br/><br/>
            <label id="ver">Telefone</label><br/><input id="for" type="text" name ="telefone" placeholder="Telefone" size ="60" required/><br/><br/>
            <label id="ver">Login:</label><br/><input id="for" type="text" name="login" placeholder="Login" size="60" required/><br/><br/>
            <label id="ver">Senha:</label><br/><input id="for" type="password" name="senha" placeholder="Senha" size="60" required/><br/><br/>
            
            
            <label id="ver">Perfil:</label><br/>
            <select name="id_perfil" size="1" required>
                <option value="">Selecione...</option>
                <%
                    for(Perfil p:perfis){
                %>
                    <option value="<%=p.getId() %>"><%=p.getNome() %></option>
                    <%
                    }
                    %>
            </select>
            
            <br/><br/>
            <input class="button" type="submit" value="Inserir"/>
        </form>
         
        </div>
    </body>
</html>
