package modelo;

import java.sql.Date;
import java.util.ArrayList;

public class Turma {
    private int id;
    private Date data;
    private Curso curso;
    private ArrayList<Aluno> meusAlunos;

   
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }
    
    public ArrayList<Aluno> getMeusAlunos() {
        return meusAlunos;
    }

    public void setMeusAlunos(ArrayList<Aluno> meusAlunos) {
        this.meusAlunos = meusAlunos;
    }   
    

    
}
