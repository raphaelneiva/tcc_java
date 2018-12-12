package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import modelo.AlunoDAO;
import modelo.Aluno;
import modelo.Funcionario;
import modelo.Menu;

public final class form_005falterar_005faluno_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList<String>(1);
    _jspx_dependants.add("/menu.jsp");
  }

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write(" \n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write(" \n");

   Aluno a = new Aluno();
   try{
      int id = Integer.parseInt(request.getParameter("id"));
      AlunoDAO aDAO = new AlunoDAO();
      a = aDAO.carregarPorId(id);
     
   }catch(Exception e){
       out.print("Erro: "+e);
   }
   

      out.write("\n");
      out.write(" \n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/style_index.css\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/buttons.css\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/forms.css\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/tables.css\">\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>NutriChef - Escola de Culinária</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <div class=\"principal\">\n");
      out.write("            <div class=\"imgcontainer\">\n");
      out.write("                <img src=\"img/logo.PNG\" alt=\"Avatar\" class=\"avatar\">\n");
      out.write("            </div>\n");
      out.write("            ");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<//img src=\"imagens/banner.jpg\" /><br/>\n");

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


      out.write("\n");
      out.write("            <h1 id=\"form\">Alterando Aluno</h1>\n");
      out.write("            <form class=\"form\" action=\"alterar_aluno.do\" method=\"post\">\n");
      out.write("                <input type=\"hidden\" name=\"id\" value=\"");
      out.print(a.getId() );
      out.write("\"/>\n");
      out.write("                    <label id=\"ver\">Nome:</label><br/><input id=\"for\" type=\"text\" name=\"nome\" value=\"");
      out.print(a.getNome() );
      out.write("\" size=\"60\" placeholder=\"Nome\" required/><br/><br/>\n");
      out.write("                    <label id=\"ver\">Email:</label><br/><input id=\"for\" type =\"email\" name =\"email\" value=\"");
      out.print(a.getEmail() );
      out.write("\" size=\"60\" placeholder=\"Email\" required/><br/><br/>\n");
      out.write("                    <label id=\"ver\">Telefone:</label><br/><input id=\"for\" type =\"text\" name =\"telefone\" value=\"");
      out.print(a.getTelefone()  );
      out.write("\" placeholder=\"Telefone\" size=\"60\" required/><br/><br/> \n");
      out.write("\n");
      out.write("                    <br/><label id=\"ver\">Status: </label><br/>\n");
      out.write("                    <select name = \"status\" size = \"1\" required>\n");
      out.write("                        <option value=\"\">Selecione...</option>\n");
      out.write("                        <option value=\"1 - Interesse geral\">1 - Interesse geral</option>\n");
      out.write("                        <option value=\"2 - Interesse específico\">2 - Interesse específico</option>\n");
      out.write("                        <option value=\"3 - Inscrição confirmada\">3 - Inscrição confirmada</option>\n");
      out.write("                        <option value=\"4 - Pagamento confirmado\">4 - Pagamento confirmado</option>\n");
      out.write("                        <option value=\"5 - Confirmar presença\">5 - Confirmar presença</option>\n");
      out.write("                        <option value=\"6 - Aluno compareceu a aula\">6 - Aluno compareceu a aula</option>\n");
      out.write("                        <option value=\"7 - Aluno com crédito\">7 - Aluno com crédito</option>\n");
      out.write("                        <option value=\"7.1 - Aluno crédito parcial\">7.1 - Aluno com crédito parcial</option>\n");
      out.write("                        <option value =\"8 - Devolução do dinheiro\">8 - Devolução do dinheiro</option>\n");
      out.write("                    </select>\n");
      out.write("                    <br/> <br/>\n");
      out.write("                    <br/>\n");
      out.write("                <input class=\"button\" type=\"submit\" value=\"Salvar\"/>\n");
      out.write("            </form>\n");
      out.write("        </div>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
