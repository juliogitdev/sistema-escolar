package com.juliogitdev.sistema_escolar.model;

import java.time.LocalDate;

public class Aluno {
    
    private String matricula;
    private String nome;
    private LocalDate dataNascimento;
    private String email;
    private String senha;
    private String situacao;
    private Turma turma;
    
    //Metodo construtor
    
    public Aluno(String matricula, String nome, LocalDate dataNascimento, String email, String senha, String situacao, Turma turma){
        this.matricula = matricula;
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.email = email;
        this.senha = senha;
        this.situacao = situacao;
        this.turma = turma;
    }
    
    //acessa e altera os dados do aluno
    public String getMatricula(){return matricula;}
    public void setMatricula(String matricula){this.matricula = matricula;}
    
    public LocalDate getDataNascimento(){ return dataNascimento;}
    public void setDataNascimento(LocalDate dataNascimento){this.dataNascimento = dataNascimento;}
    
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getSenha() { return senha; }
    public void setSenha(String senha) { this.senha = senha; }
    
    public String getSituacao(){ return situacao;}
    public void setSituacao(String situacao) { this.situacao = situacao;}

    public Turma getTurma() { return turma; }
    public void setTurma(Turma turma) { this.turma = turma; }
    
    @Override
    public String toString() {
        return "Aluno{" +
            "matricula='" + matricula + '\'' +
            ", nome='" + nome + '\'' +
            ", dataNascimento='" + dataNascimento + '\'' +
            ", email='" + email + '\'' +
            ", situacao='" + situacao + '\'' +
            ", turma=" + turma +
            '}';
    }
}
