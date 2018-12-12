package controle;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Aluno;
import modelo.Curso;
import modelo.Funcionario;
import modelo.FuncionarioDAO;
import modelo.Perfil;
import modelo.Turma;
import modelo.TurmaDAO;

/**
 *
 * @author Administrador
 */
public class AlterarTurma extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet AlterarTurma</title>");            
            out.println("</head>");
            out.println("<body>");

            try {
                int id = Integer.parseInt(request.getParameter("id"));
                String nome = request.getParameter("nome");
                Date data = Date.valueOf(request.getParameter("data"));
                
  
                int id_curso = Integer.parseInt(request.getParameter("id_curso"));
                Curso c = new Curso();
                
                Turma t = new Turma();
                t.setId(id);
                t.setData(data);
                
              
                c.setId(id_curso);
                t.setCurso(c);
                
                TurmaDAO tDAO = new TurmaDAO();
                tDAO.alterar(t);
                response.sendRedirect("listar_turma.jsp");
                
                
                
            } catch (Exception e) {
                out.printf("Erro :"+e);
            }

            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
