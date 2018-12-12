<%-- 
    Document   : form_inserir_etiqueta
    Created on : 30/11/2018, 23:43:49
    Author     : Raphael
--%>

<%@page import="modelo.CursoDAO"%>
<%@page import="modelo.Curso"%>
<%@page import="modelo.AlunoDAO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="modelo.Aluno"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>


<%
    ArrayList<Aluno> alunos = new ArrayList<Aluno>();
    try{
       AlunoDAO aDAO = new AlunoDAO();
       alunos = aDAO.listar();
    }catch(Exception e){
        out.print("Erro: "+e);
    }

%>
<%
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
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Nutrichef</title>
    </head>
    <body>
         <%@include file="menu.jsp" %>
            <h1>Inserindo Etiqueta</h1>
            <form action="inserir_etiqueta.do" method="post">
            Nome:<input type="text" name="nome" size="60" required/><br/>
                       
            Aluno:
            <select name="id_aluno" size="1" required>
                <option value="">Selecione...</option>
                <%
                    for(Aluno a:alunos){
                %>
                    <option value="<%=a.getId() %>"><%=a.getNome() %></option>
                    <%
                    }
                    %>
            </select>
            
            <br/>
               Curso:
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
            
            <br/>
            <input type="submit" value="Salvar"/>
        </form>

    </body>
</html>
