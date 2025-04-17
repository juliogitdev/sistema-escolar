package com.juliogitdev.sistema_escolar.model;

public class Disciplina {
    private int id;
    private String nome;
    private int cargaHoraria;
    private Professor professorResponsavel;
    
    //metodo construtor
    public Disciplina(int id, String nome, int cargaHoraria, Professor professorResponsavel){
        this.id = id;
        this.nome = nome;
        this.cargaHoraria = cargaHoraria;
        this.professorResponsavel = professorResponsavel;
    }
    
    //acessar e alterar dados da disciplina
    
    public int getId(){ return id;}
    public void setId(int id){this.id = id;}
    
    public String getNome(){ return nome; }
    public void setNome(String nome) { this.nome = nome; }
    
    public int getCargaHoraria(){ return cargaHoraria; }
    public void setCargaHoraria(int cargaHoraria) { this.cargaHoraria = cargaHoraria;}
    
    public Professor getProfessorResponsavel(){ return professorResponsavel; }
    public void setProfessorResponsavel(Professor professorResponsavel) { this.professorResponsavel = professorResponsavel; }
    
    @Override
    public String toString() {
        return "Disciplina{" +
            "id='" + id + '\'' +
            ", nome='" + nome + '\'' +
            ", cargaHoraria='" + cargaHoraria + '\'' +
            ", professorResponsavel='" + professorResponsavel + '\'' +
            '}';
    }
}
