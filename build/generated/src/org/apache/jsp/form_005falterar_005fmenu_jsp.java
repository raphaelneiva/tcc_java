package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import modelo.MenuDAO;
import modelo.Menu;
import modelo.Funcionario;
import modelo.Menu;

public final class form_005falterar_005fmenu_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");

  
Menu m = new Menu();

try{
    int id = Integer.parseInt(request.getParameter("id"));
    MenuDAO mDAO = new MenuDAO();
    m = mDAO.carregarPorId(id);
}catch(Exception e){
    out.print("Erro:"+e);
}


      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Alterar Menu</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        ");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<//img src=\"imagens/banner.jpg\" /><br/>\n");

  try{
  
      Funcionario fLogado = (Funcionario) session.getAttribute("funcionario");
      
      for(Menu mu:fLogado.getPerfil().getMeusMenus()){
          out.print("<a href='"+mu.getLink()+"'>"+mu.getTitulo()+"</a> |");
      }
      out.print("  Bem-vindo "+fLogado.getNome()+"(<a href='sair.jsp'>Sair</a>)");
  }catch(Exception e){
      response.sendRedirect("login.jsp");
  }  


      out.write("\n");
      out.write("        <h1>Alterando Menu</h1>\n");
      out.write("        <form action=\"alterar_menu.do\" method=\"post\">\n");
      out.write("            ID:");
      out.print(m.getId() );
      out.write("<br/>\n");
      out.write("            <input type=\"hidden\" name=\"id\" value=\"");
      out.print(m.getId() );
      out.write("\"/>\n");
      out.write("            Título:<input type=\"text\" value=\"");
      out.print(m.getTitulo() );
      out.write("\" name=\"titulo\" size=\"50\" required/><br/>\n");
      out.write("            Link:<input type=\"text\" value=\"");
      out.print(m.getLink() );
      out.write("\" name=\"link\" size=\"50\" required/><br/>\n");
      out.write("            Ícone:<input type=\"text\" value=\"");
      out.print(m.getIcone() );
      out.write("\" name=\"icone\" size=\"50\"/><br/>\n");
      out.write("            <input type=\"submit\" value=\"Salvar\"/>\n");
      out.write("        </form>\n");
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
