<%-- 
    Document   : form_alterar_turma
    Created on : 20/11/2018, 19:40:34
    Author     : Administrador
--%>

<%@page import="modelo.TurmaDAO"%>
<%@page import="modelo.Turma"%>
<%@page import="modelo.CursoDAO"%>
<%@page import="modelo.Curso"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%           
    ArrayList<Curso> cursos = new ArrayList<Curso>();
    Turma t = new Turma();
    
    try{
       
       int id = Integer.parseInt(request.getParameter("id")); 
       TurmaDAO tDAO = new TurmaDAO();
       t = tDAO.carregarPorId(id);
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
            <h1 id="turma1">Alterando Turma</h1>
            <form class='form' action="alterar_turma.do" method="post">
                <input type="hidden" name="id" value="<%=t.getId() %>"/>
                <label id="ver">Data:</label><br/>
                <input id="for1" type="date" name="data" value="<%=t.getData() %>" required/> <br/>

               <br/><br/><label id="ver">Curso:</label><br/>
                <select name="id_curso" size="1" required>
                    <option value="">Selecione...</option>
                    <%
                        String selecao3 = "";
                        for(Curso c:cursos ){
                            if(t.getCurso().getId()==t.getId()){
                                selecao3 = "selected";
                            }else{
                                selecao3 = "";
                            }
                    %>
                        <option value="<%=c.getId() %>" <%=selecao3 %>><%=c.getNome() %></option>
                        <%
                        }
                        %>
                </select>
                <br/>
                <br/>
                <input class="button" type="submit" value="Salvar"/>
            </form>
        </div>
    </body>
</html>
