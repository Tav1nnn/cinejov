package br.com.cinejov.entities;
public class Cliente {
    private String nome;
    private String email;
    private String senha;
    private int id;

    public Cliente() {
    }

    
    
    //tudo
    public Cliente(String nome, String email, String senha, int id) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.id = id;
    }
    
    //sem id
    public Cliente(String nome, String email, String senha) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
    }
    
    //get set
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

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
      
}
