package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import modelo.AlunoDAO;
import java.util.ArrayList;
import modelo.Aluno;
import modelo.Funcionario;
import modelo.Menu;

public final class listar_005faluno_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("    <head>\r\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n");
      out.write("        <script type=\"text/javascript\">\r\n");
      out.write("            function excluir(id,nome){\r\n");
      out.write("                if(confirm(\"Tem certeza que deseja excluir o aluno \" + nome + \" ?\")){\r\n");
      out.write("                    window.open(\"excluir_aluno.do?id=\"+id,\"_parent\");\r\n");
      out.write("                    \r\n");
      out.write("                }\r\n");
      out.write("            }\r\n");
      out.write("                \r\n");
      out.write("        </script>\r\n");
      out.write("        <title>Nutrichef</title>\r\n");
      out.write("    </head>\r\n");
      out.write("    <body>\r\n");
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


      out.write("\r\n");
      out.write("        <h1>Lista de Alunos(<a href=\"form_inserir_aluno.jsp\"> Adicionar </a>)</h1>\r\n");
      out.write("        <table border=\"1\">\r\n");
      out.write("            <tr>\r\n");
      out.write("                <td>ID</td>\r\n");
      out.write("                <td>NOME</td>\r\n");
      out.write("                <td>EMAIL</td>\r\n");
      out.write("                <td>TELEFONE</td>\r\n");
      out.write("                <td>STATUS</td>\r\n");
      out.write("                <td>OPÇÕES</td>\r\n");
      out.write("            </tr>\r\n");
      out.write("            ");

            ArrayList<Aluno> lista = new ArrayList<Aluno>();
            AlunoDAO aDAO = new AlunoDAO();
            try{
               lista = aDAO.listar();
            }catch(Exception e){
                out.print("Erro: "+e);
            }
            
            for(Aluno a:lista){
            
      out.write("\r\n");
      out.write("            <tr>\r\n");
      out.write("                <td>");
      out.print(a.getId() );
      out.write("</td>\r\n");
      out.write("                <td>");
      out.print(a.getNome() );
      out.write("</td>\r\n");
      out.write("                <td>");
      out.print(a.getEmail() );
      out.write("</td>\r\n");
      out.write("                <td>");
      out.print(a.getTelefone());
      out.write("</td>\r\n");
      out.write("                <td>");
      out.print(a.getStatus() );
      out.write("</td>\r\n");
      out.write("                <td><a href=\"form_alterar_aluno.jsp?id=");
      out.print(a.getId() );
      out.write("\">Alterar</a> <a href=\"#\" onclick=\"excluir(");
      out.print(a.getId() );
      out.write(',');
      out.write('\'');
      out.print(a.getNome() );
      out.write("')\"> Excluir </a> </td>\r\n");
      out.write("            </tr>            \r\n");
      out.write("            ");

            }
            
      out.write("\r\n");
      out.write("        </table>\r\n");
      out.write("        \r\n");
      out.write("        \r\n");
      out.write("        \r\n");
      out.write("        \r\n");
      out.write("    </body>\r\n");
      out.write("</html>\r\n");
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
