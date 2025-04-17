package com.juliogitdev.sistema_escolar.model;

import java.time.LocalDate;

public class Professor {
    private String matricula;
    private String nome;
    private String formacao;
    private String email;
    private String senha;
    private LocalDate data_admissao;
    
    //Metodo construtor
    public Professor(String matricula, String nome, String formacao, String email, String senha, LocalDate data_admissao){
        this.matricula = matricula;
        this.nome = nome;
        this.formacao = formacao;
        this.email = email;
        this.senha = senha;
        this.data_admissao = data_admissao;
    }
    
    //acessa e altera dados do professor
    public String getMatricula(){return matricula;}
    public void setMatricula(String matricula){ this.matricula = matricula;}
    
    public String getNome(){ return nome;}
    public void setNome(String nome){ this.nome = nome;}
    
    public String getFormacao(){ return formacao; }
    public void setFormacao(String formacao) { this.formacao = formacao; }
    
    public String getEmail(){ return email;}
    public void setEmail(String email) { this.email = email; }
    
    public void setSenha(String senha){ this.senha = senha; }
    
    public LocalDate getDataAdmissao() { return data_admissao; }
    
    @Override
    public String toString() {
        return "Professor{" +
            "matricula='" + matricula + '\'' +
            ", nome='" + nome + '\'' +
            ", formacao='" + formacao + '\'' +
            ", email='" + email + '\'' +
            ", dataAdmissao=" + data_admissao +
            '}';
    }
}
