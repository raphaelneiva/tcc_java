package modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class FuncionarioDAO extends DataSource{
    public void inserir(Funcionario f) throws Exception{
        this.conectar();
        String sql = "INSERT INTO funcionario (nome,login,senha,endereco,telefone,id_perfil) VALUES(?,?,?,?,?,?)";
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setString(1, f.getNome());
        pstm.setString(2, f.getLogin());
        pstm.setString(3, f.getSenha());
        pstm.setString(4, f.getEndereco());
        pstm.setString(5, f.getTelefone());
        pstm.setInt(6, f.getPerfil().getId());
        pstm.execute();
        this.desconectar();
    }
    
    public void excluir(int id) throws Exception{
        this.conectar();
        String sql = "DELETE FROM funcionario WHERE id=?";
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setInt(1, id);
        pstm.execute();
        this.desconectar();
    }
    
    public ArrayList<Funcionario> listar() throws Exception{
        this.conectar();
        ArrayList<Funcionario> lista = new ArrayList<Funcionario>();
        String sql = "SELECT * FROM funcionario";
        PreparedStatement pstm = conn.prepareStatement(sql);
        ResultSet rs = pstm.executeQuery();
        while (rs.next()) {
            Funcionario f = new Funcionario();
            f.setId(rs.getInt("id"));
            f.setNome(rs.getString("nome"));
            f.setLogin(rs.getString("login"));
            f.setSenha(rs.getString("senha"));
            f.setEndereco(rs.getString("endereco"));
            f.setTelefone(rs.getString("telefone"));
            PerfilDAO pDAO = new PerfilDAO();
            f.setPerfil(pDAO.carregarPorId(rs.getInt("id_perfil")));
            lista.add(f);
        }
        this.desconectar();
        return lista;
    }
    
    public Funcionario carregarPorId(int id) throws Exception{
        this.conectar();
        Funcionario f = new Funcionario();
        String sql = "SELECT * FROM funcionario WHERE id=?";
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setInt(1, id);
        ResultSet rs = pstm.executeQuery();
        if (rs.next()) {
            f.setId(rs.getInt("id"));
            f.setNome(rs.getString("nome"));
            f.setLogin(rs.getString("login"));
            f.setSenha(rs.getString("senha"));
            f.setEndereco(rs.getString("endereco"));
            f.setTelefone(rs.getString("telefone"));
            PerfilDAO pDAO = new PerfilDAO();
            f.setPerfil(pDAO.carregarPorId(rs.getInt("id_perfil")));
        }
        this.desconectar();
        return f;
    }
    
    public void alterar(Funcionario f) throws Exception{
        this.conectar();
        String sql = "UPDATE funcionario SET nome=?,login=?,senha=?,endereco=?,telefone=?,id_perfil=? WHERE id=?";
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setString(1, f.getNome());
        pstm.setString(2, f.getLogin());
        pstm.setString(3, f.getSenha());
        pstm.setString(4, f.getEndereco());
        pstm.setString(5, f.getTelefone());
        pstm.setInt(6, f.getPerfil().getId());
        pstm.setInt(7, f.getId());
        pstm.execute();
        this.desconectar();
    }
    
    public boolean loginExiste(int id,String login) throws Exception{
        this.conectar();
        String sql = "SELECT * FROM funcionario WHERE login=?";
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setString(1, login);
        ResultSet rs = pstm.executeQuery();
        if (rs.next()) {
            if(rs.getInt("id")==id){
                return false;
            }else{
                return true;
            }
        }
        this.desconectar();
        return false;
    }
    
    public Funcionario logar(String login,String senha) throws Exception{
        this.conectar();
        Funcionario f = new Funcionario();
        String sql = "SELECT * FROM funcionario WHERE login=?";
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setString(1, login);
        ResultSet rs = pstm.executeQuery();
        if (rs.next()) {
            if(senha.equals(rs.getString("senha"))){
                f.setId(rs.getInt("id"));
                f.setNome(rs.getString("nome"));
                f.setLogin(rs.getString("login"));
                f.setSenha(rs.getString("senha"));
                f.setEndereco(rs.getString("endereco"));
                f.setTelefone(rs.getString("telefone"));
                PerfilDAO pDAO = new PerfilDAO();
                f.setPerfil(pDAO.carregarPorId(rs.getInt("id_perfil")));
            }
        }
        this.desconectar();
        return f;
    }
    
    
}