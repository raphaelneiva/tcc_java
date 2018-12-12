package modelo;
public class Aluno {
    private int id;
    private String nome;
    private String email;
    private String telefone;
    private String status;
    private Etiqueta tags;
    
    //

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Etiqueta getTags() {
        return tags;
    }

    public void setTags(Etiqueta tags) {
        this.tags = tags;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
    
    
    
    
}
