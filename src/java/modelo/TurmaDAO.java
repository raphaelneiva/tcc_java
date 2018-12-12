package modelo;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class TurmaDAO extends DataSource{
    public void inserir(Turma t) throws Exception{
        this.conectar();
        String sql = "INSERT INTO turma (data,id_curso) VALUES(?,?)";
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setDate(1, (Date) t.getData());
        pstm.setInt(2, t.getCurso().getId());
        pstm.execute();
        this.desconectar();
    }
    
     public void excluir(int id) throws Exception{
        this.conectar();
        String sql = "DELETE FROM turma WHERE id=?";
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setInt(1, id);
        pstm.execute();
        this.desconectar();
    }

    public ArrayList<Turma> listar() throws Exception{
        this.conectar();
        ArrayList<Turma> lista = new ArrayList<Turma>();
        String sql = "SELECT * FROM turma";
        PreparedStatement pstm = conn.prepareStatement(sql);
        ResultSet rs = pstm.executeQuery();
        while (rs.next()) {
            Turma t = new Turma();
            t.setId(rs.getInt("id"));
            t.setData(rs.getDate("data"));
            FuncionarioDAO fDAO = new FuncionarioDAO();
            
            CursoDAO cDAO = new CursoDAO();
            t.setCurso(cDAO.carregarPorId(rs.getInt("id_curso")));
            lista.add(t);
        }
        this.desconectar();
        return lista;
    }
    
    public Turma carregarPorId(int id) throws Exception{
        this.conectar();
        Turma t = new Turma();
        String sql = "SELECT * FROM turma WHERE id=?";
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setInt(1, id);
        ResultSet rs = pstm.executeQuery();
        if (rs.next()) {
            t.setId(rs.getInt("id"));
            t.setData(rs.getDate("data"));
            
            CursoDAO cDAO = new CursoDAO();
            t.setCurso(cDAO.carregarPorId(rs.getInt("id_curso")));
            t.setMeusAlunos(matriculados(id));
        }
        this.desconectar();
        return t;
    } 
     
    public void alterar(Turma t) throws Exception{
        this.conectar();
        String sql = "UPDATE turma SET data=?,id_curso=? WHERE id=?";
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setDate(1, t.getData());
        pstm.setInt(2, t.getCurso().getId());
        pstm.setInt(3, t.getId());
        pstm.execute();
        this.desconectar();
    }
    
     public ArrayList<Aluno> matriculados(int id_turma) throws Exception{
        this.conectar();
        ArrayList<Aluno> lista = new ArrayList<Aluno>();
        String sql = "SELECT a.* FROM aluno as a, matricularaluno as ma WHERE ma.id_aluno=a.id AND ma.id_turma=?";
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setInt(1, id_turma);
        ResultSet rs = pstm.executeQuery();
        while (rs.next()) {
            Aluno a = new Aluno();
            a.setId(rs.getInt("id"));
            a.setNome(rs.getString("nome"));
            a.setEmail(rs.getString("email"));
            a.setTelefone(rs.getString("telefone"));
            a.setStatus(rs.getString("status"));
            lista.add(a);
        }
        this.desconectar();
        return lista;
    }
    
     public ArrayList<Aluno> naoMatriculados(int id_turma) throws Exception{
        this.conectar();
        ArrayList<Aluno> lista = new ArrayList<Aluno>();
        String sql = "SELECT * FROM aluno WHERE id NOT IN(SELECT id_aluno from matricularaluno as ma WHERE ma.id_turma=?)";
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setInt(1, id_turma);
        ResultSet rs = pstm.executeQuery();
        while (rs.next()) {
            Aluno a = new Aluno();
            a.setId(rs.getInt("id"));
            a.setNome(rs.getString("nome"));
            a.setEmail(rs.getString("email"));
            a.setTelefone(rs.getString("telefone"));
            a.setStatus(rs.getString("status"));
            lista.add(a);
        }
        this.desconectar();
        return lista;
    }
    
    public void matricular(int id_aluno, int id_turma) throws Exception{
        this.conectar();
        String sql = "INSERT INTO matricularaluno (id_aluno,id_turma) VALUES (?,?)";
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setInt(1, id_aluno);
        pstm.setInt(2, id_turma);
        pstm.execute();
        this.desconectar();
    }
     
    public void desmatricular(int id_aluno, int id_turma) throws Exception{
        this.conectar();
        String sql = "DELETE FROM matricularaluno WHERE id_aluno=? AND id_turma=?";
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setInt(1, id_aluno);
        pstm.setInt(2, id_turma);
        pstm.execute();
        this.desconectar();
    }
     
     
    
    
    
}
