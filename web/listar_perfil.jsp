<%@page import="modelo.PerfilDAO"%>
<%@page import="modelo.Perfil"%>
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
                if(confirm("Tem certeza que deseja excluir o perfil: "+nome+"?")){
                    window.open("excluir_perfil.do?id="+id,"_parent");
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
            <h1 id="perfil">Lista de Perfis <a href="form_inserir_perfil.jsp"><img class="icon" src="img/mais.png"></a></h1>
            <table id="perfil">
                <tr class="lp">
                    <td>NOME</td>
                    <td>OPÇÕES</td>
                </tr>
                <%
                ArrayList<Perfil> lista = new ArrayList<Perfil>();
                PerfilDAO pDAO = new PerfilDAO();
                try{
                   lista = pDAO.listar();
                }catch(Exception e){
                    out.print("Erro:"+e);
                }

                for(Perfil p:lista){
                %>
                <tr>
                    <td><%=p.getNome() %></td>
                    <td><a href="form_alterar_perfil.jsp?id=<%=p.getId() %>"><img class="icon" src="img/alterar.png"></a>
                        <a href="#" onclick="excluir(<%=p.getId() %>,'<%=p.getNome() %>')"><img class="icon" src="img/excluir.png"> </a> 
                        <a href="form_gerenciar_menu_perfil.jsp?id=<%=p.getId() %>"><img class="icon" src="img/lupa.png"></a> </td>
                </tr>            
                <%
                }
                %>
            </table>
        </div>
    </body>
</html>
