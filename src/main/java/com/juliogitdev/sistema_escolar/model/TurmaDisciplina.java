package com.juliogitdev.sistema_escolar.model;

public class TurmaDisciplina {
    private int turmaId;
    private int disciplinaId;

    // Construtor
    public TurmaDisciplina(int turmaId, int disciplinaId) {
        this.turmaId = turmaId;
        this.disciplinaId = disciplinaId;
    }

    // Getters e Setters
    public int getTurmaId() {
        return turmaId;
    }

    public void setTurmaId(int turmaId) {
        this.turmaId = turmaId;
    }

    public int getDisciplinaId() {
        return disciplinaId;
    }

    public void setDisciplinaId(int disciplinaId) {
        this.disciplinaId = disciplinaId;
    }

    // toString opcional, útil para debug
    @Override
    public String toString() {
        return "TurmaDisciplina{" +
                "turmaId=" + turmaId +
                ", disciplinaId=" + disciplinaId +
                '}';
    }
}
