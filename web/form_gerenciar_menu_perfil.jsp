<%-- 
    Document   : form_inserir_perfil
    Created on : 07/08/2018, 16:25:29
    Author     : Administrador
--%>

<%@page import="modelo.Menu"%>
<%@page import="java.util.ArrayList"%>
<%@page import="modelo.PerfilDAO"%>
<%@page import="modelo.Perfil"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
  
Perfil p = new Perfil();
ArrayList<Menu> menusNaoPerfil = new ArrayList<Menu>();
try{
    int id = Integer.parseInt(request.getParameter("id"));
    PerfilDAO pDAO = new PerfilDAO();
    p = pDAO.carregarPorId(id);
    menusNaoPerfil = pDAO.menusNaoPerfil(id);
}catch(Exception e){
    out.print("Erro:"+e);
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
            function desvincular(id_perfil,id_menu,titulo){
                if(confirm("Tem certeza que deseja desvincular o menu: "+titulo+"?")){
                    window.open("gerenciar_menu_perfil.do?id_perfil="+id_perfil+"&id_menu="+id_menu+"&op=desvincular","_parent");
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
            <h1 id="form">Gerenciando Menus do Perfil</h1>
            <form class="form" action="gerenciar_menu_perfil.do" method="post">
                <label id="ver">Nome:<br/></label><label id="per"><%=p.getNome()%></label><br/>
                <input type="hidden" value="<%=p.getId() %>" name="id_perfil"/>
                <input type="hidden" value="vincular" name="op"/><br/>
                <label id="ver">Menu:</label>
                <br/><select name="id_menu" size="1" required>
                    <option value="">Selecione...</option>
                    <%
                    for(Menu m:menusNaoPerfil){
                    %>
                    <option value="<%=m.getId() %>"><%=m.getTitulo() %></option>
                    <%
                    }
                    %>
                </select>
                <input class="button"type="submit" value="+"/>
            </form>
                <div algn="center">
                    <h2>Menus vinculados</h2>
                    <table id="perfil1">
                        <tr class="lp">
                            <td>TÍTULO</td>
                            <td>DESVINCULAR</td>
                        </tr>
                        <%
                        for(Menu m:p.getMeusMenus()){
                        %>
                        <tr>
                            <td><%=m.getTitulo() %></td>
                            <td align="center">
                                <a href="#" onclick="desvincular(<%=p.getId() %>,'<%=m.getId() %>','<%=m.getTitulo() %>')"><img class="icon" src="img/excluir.png"/></a>
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
