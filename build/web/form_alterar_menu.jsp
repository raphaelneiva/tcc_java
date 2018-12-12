<%-- 
    Document   : form_inserir_menu
    Created on : 14/08/2018, 16:12:33
    Author     : Administrador
--%>

<%@page import="modelo.MenuDAO"%>
<%@page import="modelo.Menu"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
  
Menu m = new Menu();

try{
    int id = Integer.parseInt(request.getParameter("id"));
    MenuDAO mDAO = new MenuDAO();
    m = mDAO.carregarPorId(id);
}catch(Exception e){
    out.print("Erro:"+e);
}

%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Alterar Menu</title>
    </head>
    <body>
        <%@include file="menu.jsp" %>
        <h1>Alterando Menu</h1>
        <form action="alterar_menu.do" method="post">
            ID:<%=m.getId() %><br/>
            <input type="hidden" name="id" value="<%=m.getId() %>"/>
            Título:<input type="text" value="<%=m.getTitulo() %>" name="titulo" size="50" required/><br/>
            Link:<input type="text" value="<%=m.getLink() %>" name="link" size="50" required/><br/>
            Ícone:<input type="text" value="<%=m.getIcone() %>" name="icone" size="50"/><br/>
            <input type="submit" value="Salvar"/>
        </form>
    </body>
</html>
