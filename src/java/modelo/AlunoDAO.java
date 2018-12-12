package modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class AlunoDAO extends DataSource{
    public void inserir(Aluno a) throws Exception{
        this.conectar();
        String sql = "INSERT INTO aluno (nome,email,telefone,status) VALUES(?,?,?,?)";
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setString(1, a.getNome());
        pstm.setString(2, a.getEmail());
        pstm.setString(3, a.getTelefone());
        pstm.setString(4, a.getStatus());
        pstm.execute();
        this.desconectar();
    }

    public void excluir(int id) throws Exception{
        this.conectar();
        String sql = "DELETE FROM aluno WHERE id=?";
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setInt(1, id);
        pstm.execute();
        this.desconectar();
    }
    
    public ArrayList<Aluno> listar() throws Exception{
        this.conectar();
        ArrayList<Aluno>lista = new ArrayList<Aluno>();
        String sql = "SELECT * FROM aluno";
        PreparedStatement pstm = conn.prepareStatement(sql);
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
    
    public Aluno carregarPorId(int id) throws Exception{
        this.conectar();
        Aluno a = new Aluno(); 
        String sql = "SELECT * FROM aluno WHERE id=?";
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setInt(1, id);
        ResultSet rs = pstm.executeQuery();
        if (rs.next()) {
          a.setId(rs.getInt("id"));
          a.setNome(rs.getString("nome"));
          a.setEmail(rs.getString("email"));
          a.setTelefone(rs.getString("telefone"));
          a.setStatus(rs.getString("status"));
        }
        this.desconectar();
        return a;
    }
    
    public void alterar(Aluno a) throws Exception{
        this.conectar();
        String sql = "UPDATE aluno SET nome=?,email=?,telefone=?,status=? WHERE id=?";
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setString(1, a.getNome());
        pstm.setString(2, a.getEmail());
        pstm.setString(3, a.getTelefone());
        pstm.setString(4, a.getStatus());
        pstm.setInt(5, a.getId());
        pstm.execute();
        this.desconectar();
    }
}
