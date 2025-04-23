package com.juliogitdev.sistema_escolar.model;

import jakarta.persistence.*;

@Entity
@Table(name="turma")
public class Turma {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String nome;
    private int anoLetivo;
    private String turno;
    
    public Turma(){}
    
    //Método construtor com parametros
    public Turma(Long id, String nome, int anoLetivo, String turno){
        this.id = id;
        this.nome = nome;
        this.anoLetivo = anoLetivo;
        this.turno = turno;
    }

    //acessa e altera os dados da turma
    public Long getId(){
        return id;
    }
    
    public void setId(Long id){
        this.id = id;
    }
    
    public String getNome(){
        return nome;
    }
    
    public void setNome(String nome){
        this.nome = nome;
    }
    
    public int getAnoLetivo(){
        return anoLetivo;
    }
    
    public void setAnoLetivo(int anoLetivo){
        this.anoLetivo = anoLetivo;
    }
    
    public String getTurno(){
        return turno;
    }
    
    public void setTurno(String turno){
        this.turno = turno;
    }
    
    //representação em texto (testes)
    @Override
    public String toString(){
        return "Turma{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", anoLetivo=" + anoLetivo +
                ", turno='" + turno + '\'' +
                '}';
    }
    
}
