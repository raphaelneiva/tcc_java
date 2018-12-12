<%-- 
    Document   : menu
    Created on : 03/10/2018, 16:41:16
    Author     : Administrador
--%>

<%@page import="modelo.Funcionario"%>
<%@page import="modelo.Menu"%>
<//img src="imagens/banner.jpg" /><br/>
<%
  try{
  
      Funcionario fLogado = (Funcionario) session.getAttribute("funcionario");
      out.print("<div id='perfil'> Bem-vindo " +fLogado.getNome()+ "</div><br/><br/>");
      for(Menu mu:fLogado.getPerfil().getMeusMenus()){
          out.print("<div id='men'>"
                        + "<a id='menu' href='"+mu.getLink()+"'>"+mu.getTitulo()+"</a>"
                   + "</div>");
      }
      out.print(" <a id='sair' href='sair.jsp'> Sair </a> ");
  }catch(Exception e){
      response.sendRedirect("login.jsp");
  }  

%>