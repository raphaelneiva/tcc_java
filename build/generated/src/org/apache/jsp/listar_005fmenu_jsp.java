package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import modelo.MenuDAO;
import modelo.Menu;
import java.util.ArrayList;

public final class listar_005fmenu_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

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
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <script type=\"text/javascript\">\n");
      out.write("            function excluir(id,titulo){\n");
      out.write("                if(confirm(\"Tem certeza que deseja excluir o Menu \"+titulo+\"?\")){\n");
      out.write("                    window.open(\"excluir_menu.do?id=\"+id,\"_parent\");\n");
      out.write("                }\n");
      out.write("            }\n");
      out.write("        </script>\n");
      out.write("        \n");
      out.write("        <title>Nutrichef</title>\n");
      out.write("    </head>\n");
      out.write("    \n");
      out.write("    ");
//@include file="menu.jsp" 
      out.write("\n");
      out.write("    \n");
      out.write("    <body>\n");
      out.write("        <h1>Lista de Menus (<a href=\"form_inserir_menu.jsp\">Novo Menu</a>)</h1>\n");
      out.write("        <table border=\"1\">\n");
      out.write("            <tr>\n");
      out.write("                <td>ID</td>\n");
      out.write("                <td>TÍTULO</td>\n");
      out.write("                <td>LINK</td>\n");
      out.write("                <td>OPÇÕES</td>\n");
      out.write("            </tr>\n");
      out.write("            ");

            ArrayList<Menu> lista = new ArrayList<Menu>();
            MenuDAO mDAO = new MenuDAO();
            try{
               lista = mDAO.listar();
            }catch(Exception e){
                out.print("Erro: "+e);
            }
            
            for(Menu m:lista){
            
      out.write("\n");
      out.write("            <tr>\n");
      out.write("                <td>");
      out.print(m.getId() );
      out.write("</td>\n");
      out.write("                <td>");
      out.print(m.getTitulo());
      out.write("</td>\n");
      out.write("                <td>");
      out.print(m.getLink() );
      out.write("</td>\n");
      out.write("                <td><a href=\"form_alterar_menu.jsp?id=");
      out.print(m.getId() );
      out.write("\"> Alterar </a> <a href=\"#\" onclick=\"excluir(");
      out.print(m.getId() );
      out.write(',');
      out.write('\'');
      out.print(m.getTitulo() );
      out.write("')\"> Excluir </a> </td>\n");
      out.write("            </tr>            \n");
      out.write("            ");

            }
            
      out.write("\n");
      out.write("        </table>\n");
      out.write("        \n");
      out.write("        \n");
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
