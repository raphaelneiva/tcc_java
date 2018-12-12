<%-- 
    Document   : form_alterar_funcionario
    Created on : 14/11/2018, 20:18:35
    Author     : Raphael
--%>

<%@page import="modelo.PerfilDAO"%>
<%@page import="modelo.FuncionarioDAO"%>
<%@page import="modelo.Funcionario"%>
<%@page import="java.util.ArrayList"%>
<%@page import="modelo.Perfil"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
    ArrayList<Perfil> perfis = new ArrayList<Perfil>();
    Funcionario f = new Funcionario();
    try{
       int id = Integer.parseInt(request.getParameter("id"));
       FuncionarioDAO fDAO = new FuncionarioDAO();
       f = fDAO.carregarPorId(id);
       
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
            <h1 id="form">Alterando Funcionário</h1>
            <form class="form"action="alterar_funcionario.do" method="post">
                <input type="hidden" name="id" value="<%=f.getId() %>"/>
                <label id="ver">Nome:</label><br/><input id="for" type="text" name="nome" value="<%=f.getNome() %>" size="60" required/><br/><br/>
                <label id="ver">Endereço:</label><br/><input id="for" type ="text" name ="endereco" value="<%=f.getEndereco() %>" size="60" required/><br/><br/>
                <label id="ver">Telefone</label><br/><input id="for" type ="text" name ="telefone" value="<%=f.getTelefone()  %>" size="60" required/><br/><br/> 
                <label id="ver">Login:</label><br/><input id="for" type="text" name="login"  value="<%=f.getLogin() %>" size="60" required/><br/><br/>
                <label id="ver">Senha:</label><br/><input id="for" type="password" name="senha"  value="<%=f.getSenha() %>" size="60" required/><br/><br/>

                <label id="ver">Perfil:</label><br/>
                <select name="id_perfil" size="1" required>
                    <option value="">Selecione...</option>
                    <%
                        String selecao = "";
                        for(Perfil p:perfis){
                            if(f.getPerfil().getId()==p.getId()){
                                selecao = "selected";
                            }else{
                                selecao = "";
                            }
                        %>
                        <option value="<%=p.getId() %>" <%=selecao %>><%=p.getNome() %></option>
                        <%
                        }
                        %>
                </select>
                <br/><br/>
                <input class="button" type="submit" value="Salvar"/>
            </form>
        </div>
    </body>
</html>
