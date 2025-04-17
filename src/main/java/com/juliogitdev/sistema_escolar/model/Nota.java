package com.juliogitdev.sistema_escolar.model;

public class Nota {
    private int id;
    private int matriculaId;  // FK para Matrícula
    private int disciplinaId; // FK para Disciplina
    private double nota;

    // Construtor
    public Nota(int id, int matriculaId, int disciplinaId, double nota) {
        this.id = id;
        this.matriculaId = matriculaId;
        this.disciplinaId = disciplinaId;
        this.nota = nota;
    }

    // Getters e Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMatriculaId() {
        return matriculaId;
    }

    public void setMatriculaId(int matriculaId) {
        this.matriculaId = matriculaId;
    }

    public int getDisciplinaId() {
        return disciplinaId;
    }

    public void setDisciplinaId(int disciplinaId) {
        this.disciplinaId = disciplinaId;
    }

    public double getNota() {
        return nota;
    }

    public void setNota(double nota) {
        this.nota = nota;
    }

    @Override
    public String toString() {
        return "Nota{" +
                "id=" + id +
                ", matriculaId=" + matriculaId +
                ", disciplinaId=" + disciplinaId +
                ", nota=" + nota +
                '}';
    }
}
