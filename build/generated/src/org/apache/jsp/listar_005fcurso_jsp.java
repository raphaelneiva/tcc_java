package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import modelo.CursoDAO;
import modelo.Curso;
import java.util.ArrayList;
import modelo.Funcionario;
import modelo.Menu;

public final class listar_005fcurso_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("         <script type=\"text/javascript\">\n");
      out.write("            function excluir(id,nome){\n");
      out.write("                if(confirm(\"Tem certeza que deseja excluir o curso \"+nome+\"?\")){\n");
      out.write("                    window.open(\"excluir_curso.do?id=\"+id,\"_parent\");\n");
      out.write("                }\n");
      out.write("            }\n");
      out.write("        </script>\n");
      out.write("        \n");
      out.write("        <title>Nutrichef</title>\n");
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


      out.write(" \n");
      out.write("        <h1>Lista de Cursos (<a href=\"form_inserir_curso.jsp\">Adicionar</a>)</h1>\n");
      out.write("        <table border=\"1\">\n");
      out.write("            <tr>\n");
      out.write("                <td>ID</td>\n");
      out.write("                <td>NOME</td>\n");
      out.write("                <td>PREÇO</td>\n");
      out.write("                <td>OPÇÕES</td>\n");
      out.write("            </tr>\n");
      out.write("            ");

            ArrayList<Curso> lista = new ArrayList<Curso>();
            CursoDAO cDAO = new CursoDAO();
            try{
               lista = cDAO.listar();
            }catch(Exception e){
                out.print("Erro: "+e);
            }
            
            for(Curso c:lista){
            
      out.write("\n");
      out.write("            <tr>\n");
      out.write("                <td>");
      out.print(c.getId() );
      out.write("</td>\n");
      out.write("                <td>");
      out.print(c.getNome() );
      out.write("</td>\n");
      out.write("                <td>");
      out.print(c.getPreco() );
      out.write("</td>\n");
      out.write("                <td><a href=\"form_alterar_curso.jsp?id=");
      out.print(c.getId() );
      out.write("\"> Alterar <a href=\"#\" onclick=\"excluir(");
      out.print(c.getId() );
      out.write(',');
      out.write('\'');
      out.print(c.getNome() );
      out.write("' , ");
      out.print(c.getPreco() );
      out.write(")\"> Excluír </a>  </td>\n");
      out.write("            </tr>            \n");
      out.write("            ");

            }
            
      out.write("\n");
      out.write("        </table>\n");
      out.write("        \n");
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
