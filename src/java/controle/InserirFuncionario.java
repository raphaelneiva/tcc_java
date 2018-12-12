/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Funcionario;
import modelo.FuncionarioDAO;
import modelo.Perfil;

/**
 *
 * @author Raphael
 */
public class InserirFuncionario extends HttpServlet {

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
            out.println("<title>Servlet InserirFuncionario</title>");            
            out.println("</head>");
            out.println("<body>");

            try {
                String nome = request.getParameter("nome");
                String login = request.getParameter("login");
                String senha = request.getParameter("senha");
                String endereco = request.getParameter("endereco");
                String telefone = request.getParameter("telefone");
                
                int id_perfil = Integer.parseInt(request.getParameter("id_perfil"));
                Funcionario f = new Funcionario();
                f.setNome(nome);
                f.setLogin(login);
                f.setSenha(senha);
                f.setEndereco(endereco);
                f.setTelefone(telefone);
                
                
                Perfil p = new Perfil();
                p.setId(id_perfil);
                f.setPerfil(p);
                FuncionarioDAO fDAO = new FuncionarioDAO();
                if(fDAO.loginExiste(0, login)){
                    out.print("<script type='text/javascript'>");
                    out.print("alert('Já existe um funcionário com este login!');");
                    out.print("history.back();");
                    out.print("</script>");
                }else{
                    fDAO.inserir(f);
                    response.sendRedirect("listar_funcionario.jsp");
                }
                
                
            } catch (Exception e) {
                out.printf("Erro: "+e);
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
