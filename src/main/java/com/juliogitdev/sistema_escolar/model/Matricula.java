package com.juliogitdev.sistema_escolar.model;

import java.time.LocalDate;

public class Matricula {
    private int id;
    private String alunoId;  // FK para Aluno
    private int turmaId;     // FK para Turma
    private LocalDate dataMatricula;

    // Construtor
    public Matricula(int id, String alunoId, int turmaId, LocalDate dataMatricula) {
        this.id = id;
        this.alunoId = alunoId;
        this.turmaId = turmaId;
        this.dataMatricula = dataMatricula;
    }

    // Getters e Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAlunoId() {
        return alunoId;
    }

    public void setAlunoId(String alunoId) {
        this.alunoId = alunoId;
    }

    public int getTurmaId() {
        return turmaId;
    }

    public void setTurmaId(int turmaId) {
        this.turmaId = turmaId;
    }

    public LocalDate getDataMatricula() {
        return dataMatricula;
    }

    public void setDataMatricula(LocalDate dataMatricula) {
        this.dataMatricula = dataMatricula;
    }

    @Override
    public String toString() {
        return "Matricula{" +
                "id=" + id +
                ", alunoId='" + alunoId + '\'' +
                ", turmaId=" + turmaId +
                ", dataMatricula=" + dataMatricula +
                '}';
    }
}
