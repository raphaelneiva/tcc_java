<%-- 
    Document   : form_inserir_turma
    Created on : 20/11/2018, 19:12:29
    Author     : Administrador
--%>

<%@page import="modelo.CursoDAO"%>
<%@page import="modelo.AlunoDAO"%>
<%@page import="modelo.Curso"%>
<%@page import="modelo.Aluno"%>
<%@page import="modelo.FuncionarioDAO"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
    ArrayList<Funcionario> funcionarios = new ArrayList<Funcionario>();
            
    ArrayList<Curso> cursos = new ArrayList<Curso>();
    
    try{
       CursoDAO cDAO = new CursoDAO();
       cursos = cDAO.listar();
       
       
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
            <h1 id="turma1">Nova Turma</h1>
            <form class='form' action="inserir_turma.do" method="post">
            <label id="ver">Data:</label> <br/><input id="for1" type="date" name="data" required/><br/>
            
              <br/><label id="ver">Curso:</label><br/>
            <select name="id_curso" size="1" required>
                <option value="">Selecione...</option>
                <%
                    for(Curso c:cursos){
                %>
                    <option value="<%=c.getId() %>"><%=c.getNome() %></option>
                    <%
                    }
                    %>
            </select>
             <br/><br/><input class="button" type="submit" value="Inserir"/>
        </form>
        </div>
    </body>
</html>
