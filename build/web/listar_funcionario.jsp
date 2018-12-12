<%-- 
    Document   : listar_funcionario
    Created on : 14/11/2018, 20:31:06
    Author     : Raphael
--%>

<%@page import="modelo.FuncionarioDAO"%>
<%@page import="modelo.Funcionario"%>
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
                if(confirm("Tem certeza que deseja excluir o funcionário " + nome + " ?")){
                    window.open("excluir_funcionario.do?id="+id,"_parent");
                    
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
            <h1 id="func">Lista de Funcionários<a href="form_inserir_funcionario.jsp"> <img class="icon" src="img/mais.png"> </a></h1>
            <table id="func">
                <tr class="lp">
                    <td>NOME</td>
                    <td>PERFIL</td>
                    <td>OPÇÕES</td>
                </tr>
                <%
                ArrayList<Funcionario> lista = new ArrayList<Funcionario>();
                FuncionarioDAO fDAO = new FuncionarioDAO();
                try{
                   lista = fDAO.listar();
                }catch(Exception e){
                    out.print("Erro: "+e);
                }

                for(Funcionario f:lista){
                %>
                <tr>
                    <td><%=f.getNome() %></td>
                    <td><%=f.getPerfil().getNome() %></td>
                    <td><a href="form_alterar_funcionario.jsp?id=<%=f.getId() %>"><img class="icon" src="img/alterar.png"></a> <a href="#" onclick="excluir(<%=f.getId() %>,'<%=f.getNome() %>')"> <img class="icon" src="img/excluir.png"> </a> </td>
                </tr>            
                <%
                }
                %>
            </table>
        </div>        
    </body>
</html>
