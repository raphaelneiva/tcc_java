package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import modelo.Menu;
import java.util.ArrayList;
import modelo.PerfilDAO;
import modelo.Perfil;
import modelo.Funcionario;
import modelo.Menu;

public final class form_005fgerenciar_005fmenu_005fperfil_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\n");
      out.write("\n");
      out.write("\n");

  
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


      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <script type=\"text/javascript\">\n");
      out.write("            function desvincular(id_perfil,id_menu,titulo){\n");
      out.write("                if(confirm(\"Tem certeza que deseja desvincular o menu: \"+titulo+\"?\")){\n");
      out.write("                    window.open(\"gerenciar_menu_perfil.do?id_perfil=\"+id_perfil+\"&id_menu=\"+id_menu+\"&op=desvincular\",\"_parent\");\n");
      out.write("                }\n");
      out.write("            }\n");
      out.write("        </script>\n");
      out.write("        <title> Nutrichef </title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        ");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<img src=\"imagens/banner.jpg\" /><br/>\n");

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
      out.write("        <h1>Gerenciando Menus de Perfil</h1>\n");
      out.write("        <form action=\"gerenciar_menu_perfil.do\" method=\"post\">\n");
      out.write("            ID:");
      out.print(p.getId() );
      out.write(" Nome:");
      out.print(p.getNome());
      out.write("\n");
      out.write("            <input type=\"hidden\" value=\"");
      out.print(p.getId() );
      out.write("\" name=\"id_perfil\"/>\n");
      out.write("            <input type=\"hidden\" value=\"vincular\" name=\"op\"/><br/>\n");
      out.write("            Menu:<select name=\"id_menu\" size=\"1\" required>\n");
      out.write("                <option value=\"\">Selecione...</option>\n");
      out.write("                ");

                for(Menu m:menusNaoPerfil){
                
      out.write("\n");
      out.write("                <option value=\"");
      out.print(m.getId() );
      out.write('"');
      out.write('>');
      out.print(m.getTitulo() );
      out.write("</option>\n");
      out.write("                ");

                }
                
      out.write("\n");
      out.write("            </select>\n");
      out.write("            <input type=\"submit\" value=\"+\"/>\n");
      out.write("        </form>\n");
      out.write("            <div algn=\"center\">\n");
      out.write("                <h2>Menus vinculados</h2>\n");
      out.write("                <table border=\"1\">\n");
      out.write("                    <tr>\n");
      out.write("                        <td>ID</td>\n");
      out.write("                        <td>TÍTULO</td>\n");
      out.write("                        <td>DESVINCULAR</td>\n");
      out.write("                    </tr>\n");
      out.write("                    ");

                    for(Menu m:p.getMeusMenus()){
                    
      out.write("\n");
      out.write("                    <tr>\n");
      out.write("                        <td>");
      out.print(m.getId() );
      out.write("</td>\n");
      out.write("                        <td>");
      out.print(m.getTitulo() );
      out.write("</td>\n");
      out.write("                        <td align=\"center\"><a href=\"#\" onclick=\"desvincular(");
      out.print(p.getId() );
      out.write(',');
      out.write('\'');
      out.print(m.getId() );
      out.write("','");
      out.print(m.getTitulo() );
      out.write("')\"><img src=\"imagens/excluir.png\"/></a> </td>\n");
      out.write("                    </tr>\n");
      out.write("                    ");

                    }
                    
      out.write("\n");
      out.write("                </table>\n");
      out.write("            </div>    \n");
      out.write("            \n");
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
