<%-- 
    Document   : listar_menu
    Created on : 14/11/2018, 23:22:43
    Author     : Raphael
--%>

<%@page import="modelo.MenuDAO"%>
<%@page import="modelo.Menu"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script type="text/javascript">
            function excluir(id,titulo){
                if(confirm("Tem certeza que deseja excluir o Menu "+titulo+"?")){
                    window.open("excluir_menu.do?id="+id,"_parent");
                }
            }
        </script>
        
        <title>Nutrichef</title>
    </head>
    
    <%@include file="menu.jsp" %>
    
    <body>
        <div class="principal">
            <h1>Lista de Menus (<a href="form_inserir_menu.jsp">Novo Menu</a>)</h1>
            <table border="1">
                <tr>
                    <td>ID</td>
                    <td>TÍTULO</td>
                    <td>LINK</td>
                    <td>OPÇÕES</td>
                </tr>
                <%
                ArrayList<Menu> lista = new ArrayList<Menu>();
                MenuDAO mDAO = new MenuDAO();
                try{
                   lista = mDAO.listar();
                }catch(Exception e){
                    out.print("Erro: "+e);
                }

                for(Menu m:lista){
                %>
                <tr>
                    <td><%=m.getId() %></td>
                    <td><%=m.getTitulo()%></td>
                    <td><%=m.getLink() %></td>
                    <td><a href="form_alterar_menu.jsp?id=<%=m.getId() %>"> Alterar </a> <a href="#" onclick="excluir(<%=m.getId() %>,'<%=m.getTitulo() %>')"> Excluir </a> </td>
                </tr>            
                <%
                }
                %>
            </table>
        </div>
    </body>
</html>
