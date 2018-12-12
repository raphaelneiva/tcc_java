<%-- 
    Document   : listar_turma
    Created on : 20/11/2018, 15:55:27
    Author     : Raphael
--%>

<%@page import="modelo.TurmaDAO"%>
<%@page import="modelo.Turma"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="css/style_index.css">
        <link rel="stylesheet" href="css/tables.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script type="text/javascript">
            function excluir(id,nome){
                if(confirm("Tem certeza que deseja excluir a turma "+nome+"?")){
                    window.open("excluir_turma.do?id="+id,"_parent");
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
            <h1 id="turma">Lista de Turmas <a href="form_inserir_turma.jsp"> <img class="icon" src="img/mais.png"></a></h1>
            <table id="turma">
                <tr class="lp">
                    <td>DATA/TURMA</td>
                    <td>CURSO</td>
                    <td>ALTERAR</td>
                    <td>MATRICULAR ALUNO</td>
                </tr>
                <%
                ArrayList<Turma> lista = new ArrayList<Turma>();
                TurmaDAO tDAO = new TurmaDAO();
                try{
                   lista = tDAO.listar();
                }catch(Exception e){
                    out.print("Erro: "+e);
                }

                for(Turma t:lista){
                %>
                <tr>
                    <td><%=t.getData()%></td>
                    <td><%=t.getCurso().getNome()%></td>
                    <td>
                        <a href="form_alterar_turma.jsp?id=<%=t.getId() %> "><img class="icon" src="img/alterar.png"></a> 
                    </td>
                    <td><a href="form_gerenciar_matricular_aluno.jsp?id=<%=t.getId() %> "><img class="icon" src="img/soma.png"></a></td>
                </tr>            
                <%
                }
                %>
            </table>
        </div>
    </body>
</html>
