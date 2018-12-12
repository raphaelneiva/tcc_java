package modelo;

import java.util.ArrayList;
public class Perfil {
    private int id;
    private String nome;
    private String descricao;
    private ArrayList<Menu> meusMenus;
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public ArrayList<Menu> getMeusMenus() {
        return meusMenus;
    }

    public void setMeusMenus(ArrayList<Menu> meusMenus) {
        this.meusMenus = meusMenus;
    }
    
}
