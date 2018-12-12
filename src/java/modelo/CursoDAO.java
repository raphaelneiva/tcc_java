package modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class CursoDAO extends DataSource{
    public void inserir(Curso c) throws Exception{
        this.conectar();
        String sql = "INSERT INTO curso (nome,preco) VALUES(?,?)";
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setString(1, c.getNome());
        pstm.setDouble(2, c.getPreco());
        pstm.execute();
        this.desconectar();
    }
    
    public void excluir(int id) throws Exception{
        this.conectar();
        String sql = "DELETE FROM curso WHERE id=?";
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setInt(1, id);
        pstm.execute();
        this.desconectar();
    }
    
    public ArrayList<Curso> listar() throws Exception{
        this.conectar();
        ArrayList<Curso>lista = new ArrayList<Curso>();
        String sql = "SELECT * FROM curso";
        PreparedStatement pstm = conn.prepareStatement(sql);
        ResultSet rs = pstm.executeQuery();
        while (rs.next()) {
            Curso c = new Curso();
            c.setId(rs.getInt("id"));
            c.setNome(rs.getString("nome"));
            c.setPreco(rs.getDouble("preco"));
         
            lista.add(c);
        }
        this.desconectar();
        return lista;
    }
    
    public Curso carregarPorId(int id) throws Exception{
        this.conectar();
        Curso c = new Curso(); 
        String sql = "SELECT * FROM curso WHERE id=?";
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setInt(1, id);
        ResultSet rs = pstm.executeQuery();
        if (rs.next()) {
            c.setId(rs.getInt("id"));
            c.setNome(rs.getString("nome"));
            c.setPreco(rs.getDouble("preco"));
           
        }
        this.desconectar();
        return c;
    }

    public void alterar(Curso c) throws Exception{
        this.conectar();
        String sql = "UPDATE curso SET nome=?,preco=? WHERE id=?";
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setString(1, c.getNome());
        pstm.setDouble(2, c.getPreco());
        pstm.setInt(3, c.getId());
        pstm.execute();
        this.desconectar();
    }
    
    
    
}
