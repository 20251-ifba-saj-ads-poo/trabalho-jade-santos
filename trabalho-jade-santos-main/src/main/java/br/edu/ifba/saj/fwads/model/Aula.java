package br.edu.ifba.saj.fwads.model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Aula {
    private String nomeAula;
    private String horario;
    private Professor professor;
    private ObservableList<Aluno> alunosInscritos;

    public Aula(String nomeAula, String horario, Professor professor) {
        this.nomeAula = nomeAula;
        this.horario = horario;
        this.professor = professor;
        this.alunosInscritos = FXCollections.observableArrayList();
    }

    public String getNomeAula() {
        return nomeAula;
    }

    public void setNomeAula(String nomeAula) {
        this.nomeAula = nomeAula;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }
    
    public ObservableList<Aluno> getAlunosInscritos() {
        return alunosInscritos;
    }
    
    public void adicionarAluno(Aluno aluno) {
        if (!alunosInscritos.contains(aluno)) {
            this.alunosInscritos.add(aluno);
        }
    }

    @Override
    public String toString() {
        return nomeAula + " (" + horario + ") - Professor: " + professor.getNome();
    }
}