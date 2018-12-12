<%-- 
    Document   : listar_aluno
    Created on : 20/11/2018, 17:07:20
    Author     : Raphael
--%>

<%@page import="modelo.AlunoDAO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="modelo.Aluno"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="css/style_index.css">
        <link rel="stylesheet" href="css/tables.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script type="text/javascript">
            function excluir(id,nome){
                if(confirm("Tem certeza que deseja excluir o aluno " + nome + " ?")){
                    window.open("excluir_aluno.do?id="+id,"_parent");
                    
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
            <h1 id="text">Lista de Alunos <a href="form_inserir_aluno.jsp"> <img class="icon" src="img/mais.png"> </a></h1>
            <div id="tabelas">    
                <table>
                    <tr class="lp">
                        <td>NOME</td>
                        <td>EMAIL</td>
                        <td>TELEFONE</td>
                        <td>STATUS</td>
                        <td>ALTERAR</td>
                    </tr>
                    <%
                    ArrayList<Aluno> lista = new ArrayList<Aluno>();
                    AlunoDAO aDAO = new AlunoDAO();
                    try{
                       lista = aDAO.listar();
                    }catch(Exception e){
                        out.print("Erro: "+e);
                    }

                    for(Aluno a:lista){
                    %>
                    <tr>
                        <td><%=a.getNome() %></td>
                        <td><%=a.getEmail() %></td>
                        <td><%=a.getTelefone()%></td>
                        <td><%=a.getStatus() %></td>
                        <td>
                            <a href="form_alterar_aluno.jsp?id=<%=a.getId() %> "><img class="icon" src="img/alterar.png"></a> 
                        </td>
                    </tr>            
                    <%
                    }
                    %>
                </table>
            </div>
        </div>
    </body>
</html>
