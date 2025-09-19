package br.edu.ifba.saj.fwads.model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Aluno {
    private String nome;
    private String CPF;
    private String email;
    private ObservableList<Aula> aulasInscritas;

    public Aluno(String nome, String CPF, String email) {
        this.nome = nome;
        this.CPF = CPF;
        this.email = email;
        this.aulasInscritas = FXCollections.observableArrayList();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public ObservableList<Aula> getAulasInscritas() {
        return aulasInscritas;
    }
    
    public void inscreverEmAula(Aula aula) {
        if (!aulasInscritas.contains(aula)) {
            this.aulasInscritas.add(aula);
            aula.adicionarAluno(this);
        }
    }

    @Override
    public String toString() {
        return "Aluno: " + nome + " (CPF: " + CPF + ")";
    }
}