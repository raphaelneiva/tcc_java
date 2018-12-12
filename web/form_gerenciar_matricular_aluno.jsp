<%-- 
    Document   : form_gerenciar_matricular_aluno
    Created on : 24/11/2018, 16:52:41
    Author     : Raphael
--%>

<%@page import="modelo.AlunoDAO"%>
<%@page import="modelo.Aluno"%>
<%@page import="modelo.TurmaDAO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="modelo.Turma"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
  
Turma t = new Turma();
ArrayList<Aluno> naoMatriculados = new ArrayList<Aluno>();
try{
    int id = Integer.parseInt(request.getParameter("id"));    
    TurmaDAO tDAO = new TurmaDAO();
    t = tDAO.carregarPorId(id);
    naoMatriculados = tDAO.naoMatriculados(id);
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
        <script type="text/javascript">
            function desmatricular(id_turma,id_aluno,nome){
                if(confirm("Tem certeza que deseja desmatricular o aluno: "+nome+"?")){
                    window.open("gerenciar_matricular_aluno.do?id_aluno="+id_aluno+"&id_turma="+id_turma+"&op=desmatricular","_parent");
                }
            }
        </script>
        <title>NutriChef - Escola de Culinária</title>
    </head>
    <body>
        <div class="principal">
            <div class="imgcontainer">
                    <img src="img/logo.PNG" alt="Avatar" class="avatar">
            </div>
            <%@include file="menu.jsp" %>
            <h1 id="form">Turma:<br/>     <%=t.getData()%></h1>
            <h1 id="form">Curso:<br/> <%=t.getCurso().getNome()%></h1>
            <form class="form" action="gerenciar_matricular_aluno.do" method="post">
                <input type="hidden" value="<%=t.getId() %>" name="id_turma"/>
                <input type="hidden" value="matricular" name="op"/><br/>
                <label id="ver">Alunos:</label><select name="id_aluno" size="1" required>
                    <option value="">Selecione...</option>
                    <%
                    for(Aluno a:naoMatriculados){
                    %>
                    <option value="<%=a.getId() %>"><%=a.getNome()%></option>
                    <%
                    }
                    %>
                </select>
                <input class="button"type="submit" value="+"/>
            </form>
                <div align="center">
                    <h2>Alunos matriculados</h2>
                    <table id="matri">
                        <tr class="lp">
                            <td>NOME</td>
                            <td>DESMATRICULAR</td>
                        </tr>
                        <%
                        for(Aluno a: t.getMeusAlunos()){
                        %>
                        <tr>
                            <td><%=a.getNome() %></td>
                            <td align="center"><a href="#" onclick="desmatricular(<%=t.getId() %>,'<%=a.getId() %>','<%=a.getNome()%>')"><img class="icon" src="img/excluir.png"/></a> </td>
                        </tr>
                        <%
                        }
                        %>
                    </table>
                </div>   
        </div>
    </body>
</html>
