<%-- 
    Document   : form_alterar_etiqueta
    Created on : 30/11/2018, 23:57:51
    Author     : Raphael
--%>

<%@page import="modelo.CursoDAO"%>
<%@page import="modelo.Curso"%>
<%@page import="modelo.AlunoDAO"%>
<%@page import="modelo.EtiquetaDAO"%>
<%@page import="modelo.Etiqueta"%>
<%@page import="java.util.ArrayList"%>
<%@page import="modelo.Aluno"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
    ArrayList<Aluno> alunos = new ArrayList<Aluno>();
    Etiqueta etiqueta = new Etiqueta();
    try{
       int id = Integer.parseInt(request.getParameter("id"));
       EtiquetaDAO eDAO = new EtiquetaDAO();
       etiqueta = eDAO.carregarPorId(id);
       
       AlunoDAO aDAO = new AlunoDAO();
       alunos = aDAO.listar();
      
    }catch (Exception e){
        out.print("Erro: "+e);
    }
    
 %>
 
 
 <%
    ArrayList<Curso> cursos = new ArrayList<Curso>();
    Etiqueta etiqueta2 = new Etiqueta();
    try{
       int id = Integer.parseInt(request.getParameter("id"));
       EtiquetaDAO eDAO = new EtiquetaDAO();
       etiqueta2 = eDAO.carregarPorId(id);
       
     
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
        <h1>Editando TAG</h1>
        <form action="alterar_etiqueta.do" method="post">
            ID:<%=etiqueta.getId() %><br/>
            <input type="hidden" name="id" value="<%=etiqueta.getId() %>"/>
            Nome:<input type="text" name="nome" value="<%=etiqueta.getNome() %>" size="60" required/><br/>
            Aluno:
            <select name="id_aluno" size="1" required>
                <option value="">Selecione...</option>
                <%
                    String selecao = "";
                    for(Aluno a:alunos){
                        if(etiqueta.getAluno().getId()==a.getId()){
                            selecao = "selected";
                        }else{
                            selecao = "";
                        }
                    %>
                    <option value="<%=a.getId() %>" <%=selecao %>><%=a.getNome() %></option>
                    <%
                    }
                    %>
            </select>
            <br/>
            Curso:
            <select name="id_curso" size="1" required>
                <option value="">Selecione...</option>
                <%
                    String selecione = "";
                    for(Curso c:cursos){
                        if(etiqueta2.getCurso().getId()==c.getId()){
                            selecione = "selected";
                        }else{
                            selecione = "";
                        }
                    %>
                    <option value="<%=c.getId() %>" <%=selecione %>><%=c.getNome() %></option>
                    <%
                    }
                    %>
            </select>
            <br/>
            
            <input type="submit" value="Salvar"/>
        </form>
        
        
    </body>
</html>
