package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import modelo.TurmaDAO;
import modelo.Turma;
import modelo.CursoDAO;
import modelo.AlunoDAO;
import modelo.FuncionarioDAO;
import modelo.Curso;
import modelo.Aluno;
import java.util.ArrayList;
import modelo.Funcionario;
import modelo.Funcionario;
import modelo.Menu;

public final class form_005falterar_005fturma_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");

    ArrayList<Funcionario> funcionarios = new ArrayList<Funcionario>();
    
    ArrayList<Aluno> alunos = new ArrayList<Aluno>();
            
    ArrayList<Curso> cursos = new ArrayList<Curso>();
    Turma t = new Turma();
    
    try{
       
       int id = Integer.parseInt(request.getParameter("id")); 
       TurmaDAO tDAO = new TurmaDAO();
       t = tDAO.carregarPorId(id);
       
       FuncionarioDAO fDAO = new FuncionarioDAO();
       funcionarios = fDAO.listar();
       
       AlunoDAO aDAO = new AlunoDAO();
       alunos = aDAO.listar();
       
       CursoDAO cDAO = new CursoDAO();
       cursos = cDAO.listar();
       
       
    }catch(Exception e){
        out.print("Erro: "+e);
    }
    


      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Nutrichef</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        \n");
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
      out.write("        <h1>Editando Turma</h1>\n");
      out.write("        <form action=\"alterar_turma.do\" method=\"post\">\n");
      out.write("            ID:");
      out.print(t.getId() );
      out.write("<br/>\n");
      out.write("            <input type=\"hidden\" name=\"id\" value=\"");
      out.print(t.getId() );
      out.write("\"/>\n");
      out.write("            Nome:<input type=\"text\" name=\"nome\" value=\"");
      out.print(t.getNome() );
      out.write("\" size=\"60\" required/><br/>\n");
      out.write("            Data:<input type=\"date\" name=\"data\" value=\"");
      out.print(t.getData() );
      out.write("\" required/> <br/>\n");
      out.write("            \n");
      out.write("            Funcionario:\n");
      out.write("            <select name=\"id_funcionario\" size=\"1\" required>\n");
      out.write("                <option value=\"\">Selecione...</option>\n");
      out.write("                ");

                    String selecao = "";
                    for(Funcionario f:funcionarios){
                        if(t.getFuncionario().getId()==f.getId()){
                            selecao = "selected";
                        }else{
                            selecao = "";
                        }
                    
      out.write("\n");
      out.write("                    <option value=\"");
      out.print(f.getId() );
      out.write('"');
      out.write(' ');
      out.print(selecao );
      out.write('>');
      out.print(f.getNome() );
      out.write("</option>\n");
      out.write("                    ");

                    }
                    
      out.write("\n");
      out.write("            </select>\n");
      out.write("            \n");
      out.write("            Aluno:\n");
      out.write("            <select name=\"id_aluno\" size=\"1\" required>\n");
      out.write("                <option value=\"\">Selecione...</option>\n");
      out.write("                ");

                    String selecao2 = "";
                    for(Aluno a:alunos){
                        if(t.getAluno().getId()==a.getId()){
                            selecao2 = "selected";
                        }else{
                            selecao2 = "";
                        }
                    
      out.write("\n");
      out.write("                    <option value=\"");
      out.print(a.getId() );
      out.write('"');
      out.write(' ');
      out.print(selecao2 );
      out.write('>');
      out.print(a.getNome() );
      out.write("</option>\n");
      out.write("                    ");

                    }
                    
      out.write("\n");
      out.write("            </select>\n");
      out.write("            \n");
      out.write("            Curso:\n");
      out.write("            <select name=\"id_curso\" size=\"1\" required>\n");
      out.write("                <option value=\"\">Selecione...</option>\n");
      out.write("                ");

                    String selecao3 = "";
                    for(Curso c:cursos ){
                        if(t.getCurso().getId()==t.getId()){
                            selecao3 = "selected";
                        }else{
                            selecao3 = "";
                        }
                
      out.write("\n");
      out.write("                    <option value=\"");
      out.print(c.getId() );
      out.write('"');
      out.write(' ');
      out.print(selecao3 );
      out.write('>');
      out.print(c.getNome() );
      out.write("</option>\n");
      out.write("                    ");

                    }
                    
      out.write("\n");
      out.write("            </select>\n");
      out.write("            \n");
      out.write("            \n");
      out.write("            \n");
      out.write("            \n");
      out.write("            \n");
      out.write("            <br/>\n");
      out.write("            <input type=\"submit\" value=\"Salvar\"/>\n");
      out.write("        </form>\n");
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
