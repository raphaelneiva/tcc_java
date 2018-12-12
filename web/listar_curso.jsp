<%-- 
    Document   : listar_curso
    Created on : 16/11/2018, 16:29:48
    Author     : Raphael
--%>

<%@page import="modelo.CursoDAO"%>
<%@page import="modelo.Curso"%>
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
                if(confirm("Tem certeza que deseja excluir o curso "+nome+"?")){
                    window.open("excluir_curso.do?id="+id,"_parent");
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
            <h1 id="curso">Lista de Cursos <a href="form_inserir_curso.jsp"><img class="icon" src="img/mais.png"></a></h1>
            <table id="curso">
               <tr class="lp">
                    <td>NOME</td>
                    <td>PREÇO</td>
                    <td>ALTERAR</td>
                </tr>
                <%
                ArrayList<Curso> lista = new ArrayList<Curso>();
                CursoDAO cDAO = new CursoDAO();
                try{
                   lista = cDAO.listar();
                }catch(Exception e){
                    out.print("Erro: "+e);
                }

                for(Curso c:lista){
                %>
                <tr>               
                    <td><%=c.getNome() %></td>
                    <td>R$ <%=c.getPreco() %></td>
                    <td><a href="form_alterar_curso.jsp?id=<%=c.getId() %> "><img class="icon" src="img/alterar.png"></a> </td>
                </tr>            
                <%
                }
                %>
            </table>
        </div>
    </body>
</html>
