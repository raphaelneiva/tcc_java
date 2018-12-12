package modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class EtiquetaDAO extends DataSource{

     public void inserir(Etiqueta e) throws Exception{
        this.conectar();
        String sql = "INSERT INTO etiqueta (nome,id_aluno,id_curso) VALUES(?,?,?)";
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setString(1, e.getNome());
        pstm.setInt(2, e.getAluno().getId());
        pstm.setInt(3, e.getCurso().getId());
        
        pstm.execute();
        this.desconectar();
    }
    
    public void excluir(int id) throws Exception{
        this.conectar();
        String sql = "DELETE FROM etiqueta WHERE id=?";
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setInt(1, id);
        pstm.execute();
        this.desconectar();
    }
    
    public ArrayList<Etiqueta> listar() throws Exception{
        this.conectar();
        ArrayList<Etiqueta> lista = new ArrayList<Etiqueta>();
        String sql = "SELECT * FROM etiqueta";
        PreparedStatement pstm = conn.prepareStatement(sql);
        ResultSet rs = pstm.executeQuery();
        while (rs.next()) {
            Etiqueta e = new Etiqueta();
            e.setId(rs.getInt("id"));
            e.setNome(rs.getString("nome"));
            AlunoDAO aDAO = new AlunoDAO();
            e.setAluno(aDAO.carregarPorId(rs.getInt("id_aluno")));
            CursoDAO cDAO = new CursoDAO();
            e.setCurso(cDAO.carregarPorId(rs.getInt("id_curso")));
            lista.add(e);
        }
        this.desconectar();
        return lista;
    }
    
    public Etiqueta carregarPorId(int id) throws Exception{
        this.conectar();
        Etiqueta e = new Etiqueta();
        String sql = "SELECT * FROM etiqueta WHERE id=?";
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setInt(1, id);
        ResultSet rs = pstm.executeQuery();
        if (rs.next()) {
            e.setId(rs.getInt("id"));
            e.setNome(rs.getString("nome"));
            AlunoDAO aDAO = new AlunoDAO();
            e.setAluno(aDAO.carregarPorId(rs.getInt("id_aluno")));
            CursoDAO cDAO = new CursoDAO();
            e.setCurso(cDAO.carregarPorId(rs.getInt("id_curso")));
        }
        this.desconectar();
        return e;
    }
    
    public void alterar(Etiqueta e) throws Exception{
        this.conectar();
        String sql = "UPDATE etiqueta SET nome=?,id_aluno=?,id_curso=? WHERE id=?";
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setString(1, e.getNome());
        pstm.setInt(2, e.getAluno().getId());
        pstm.setInt(3, e.getCurso().getId());
        pstm.setInt(4, e.getId());
        pstm.execute();
        this.desconectar();
    }   
    

    
    }


