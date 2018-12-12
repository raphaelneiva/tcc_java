package modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;


public class PerfilDAO extends DataSource{
    public void inserir(Perfil p) throws Exception{
        this.conectar();
        String sql = "INSERT INTO perfil (nome) VALUES(?)";
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setString(1, p.getNome());
        pstm.execute();
        this.desconectar();
    }
    
    public void excluir(int id) throws Exception{
        this.conectar();
        String sql = "DELETE FROM perfil WHERE id=?";
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setInt(1, id);
        pstm.execute();
        this.desconectar();
    }
    
    public ArrayList<Perfil> listar() throws Exception{
        this.conectar();
        ArrayList<Perfil> lista = new ArrayList<Perfil>();
        String sql = "SELECT * FROM perfil";
        PreparedStatement pstm = conn.prepareStatement(sql);
        ResultSet rs = pstm.executeQuery();
        while (rs.next()) {
            Perfil p = new Perfil();
            p.setId(rs.getInt("id"));
            p.setNome(rs.getString("nome"));
            lista.add(p);
        }
        this.desconectar();
        return lista;
    }
    
    public ArrayList<Perfil> listar(String nome) throws Exception{
        this.conectar();
        ArrayList<Perfil> lista = new ArrayList<Perfil>();
        String sql = "SELECT * FROM perfil WHERE nome like '%"+nome+"%'";
        PreparedStatement pstm = conn.prepareStatement(sql);
        ResultSet rs = pstm.executeQuery();
        while (rs.next()) {
            Perfil p = new Perfil();
            p.setId(rs.getInt("id"));
            p.setNome(rs.getString("nome"));
            lista.add(p);
        }
        this.desconectar();
        return lista;
    }
    
    public Perfil carregarPorId(int id) throws Exception{
        this.conectar();
        Perfil p = new Perfil();
        String sql = "SELECT * FROM perfil WHERE id=?";
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setInt(1, id);
        ResultSet rs = pstm.executeQuery();
        if (rs.next()) {
            p.setId(rs.getInt("id"));
            p.setNome(rs.getString("nome"));
            p.setMeusMenus(this.menusPerfil(id));
        }
        this.desconectar();
        return p;
    }
    
    public void alterar(Perfil p) throws Exception{
        this.conectar();
        String sql = "UPDATE perfil SET nome=? WHERE id=?";
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setString(1, p.getNome());
        pstm.setInt(2, p.getId());
        pstm.execute();
        this.desconectar();
    }
    
    public ArrayList<Menu> menusPerfil(int id_perfil) throws Exception{
        this.conectar();
        ArrayList<Menu> lista = new ArrayList<Menu>();
        String sql = "SELECT m.* FROM menu as m, perfil_menu as pm WHERE pm.id_menu=m.id AND pm.id_perfil=?";
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setInt(1, id_perfil);
        ResultSet rs = pstm.executeQuery();
        while (rs.next()) {
            Menu m = new Menu();
            m.setId(rs.getInt("id"));
            m.setTitulo(rs.getString("titulo"));
            m.setLink(rs.getString("link"));
            m.setIcone(rs.getString("icone"));
            lista.add(m);
        }
        this.desconectar();
        return lista;
    }
    
    public ArrayList<Menu> menusNaoPerfil(int id_perfil) throws Exception{
        this.conectar();
        ArrayList<Menu> lista = new ArrayList<Menu>();
        String sql = "SELECT * FROM menu WHERE id NOT IN(SELECT id_menu FROM perfil_menu as pm WHERE pm.id_perfil=?)";
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setInt(1, id_perfil);
        ResultSet rs = pstm.executeQuery();
        while (rs.next()) {
            Menu m = new Menu();
            m.setId(rs.getInt("id"));
            m.setTitulo(rs.getString("titulo"));
            m.setLink(rs.getString("link"));
            m.setIcone(rs.getString("icone"));
            lista.add(m);
        }
        this.desconectar();
        return lista;
    }
    
    public void vincular(int id_perfil, int id_menu) throws Exception{
        this.conectar();
        String sql = "INSERT INTO perfil_menu (id_perfil,id_menu) VALUES(?,?)";
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setInt(1, id_perfil);
        pstm.setInt(2, id_menu);
        pstm.execute();
        this.desconectar();
    }
    
    public void desvincular(int id_perfil, int id_menu) throws Exception{
        this.conectar();
        String sql = "DELETE FROM perfil_menu WHERE id_perfil=? AND id_menu=?";
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setInt(1, id_perfil);
        pstm.setInt(2, id_menu);
        pstm.execute();
        this.desconectar();
    }

}
