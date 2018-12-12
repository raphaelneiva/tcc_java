<%@page import="modelo.PerfilDAO"%>
<%@page import="modelo.Perfil"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
  
Perfil p = new Perfil();

try{
    int id = Integer.parseInt(request.getParameter("id"));
    PerfilDAO pDAO = new PerfilDAO();
    p = pDAO.carregarPorId(id);
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
        <title>Alterar Perfil</title>
    </head>
    <body>
        <div class="principal">
            <div class="imgcontainer">
                <img src="img/logo.PNG" alt="Avatar" class="avatar">
            </div>
            <%@include file="menu.jsp" %> 
            <h1 id="form">Alterando Perfil</h1>
            <form class="form"  action="alterar_perfil.do" method="post">
                <input type="hidden" value="<%=p.getId() %>" name="id"/>
                <label id="ver">Nome:</label><br/><input id="for" type="text" value="<%=p.getNome() %>" name="nome" size="60" required/><br/><br/>
                <input class="button" type="submit" value="Salvar"/>
            </form>
        </div>
    </body>
</html>
