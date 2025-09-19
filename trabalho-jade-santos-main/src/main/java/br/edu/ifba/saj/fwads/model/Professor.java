package br.edu.ifba.saj.fwads.model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Professor {
    private String nome;
    private String email;
    private String CPF;
    private ObservableList<Aula> aulasMinistradas;

    public Professor(String nome, String email, String CPF) {
        this.nome = nome;
        this.email = email;
        this.CPF = CPF;
        this.aulasMinistradas = FXCollections.observableArrayList();
    }

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
    
    public String getCPF() {
        return CPF;
    }
    
    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    public ObservableList<Aula> getAulasMinistradas() {
        return aulasMinistradas;
    }

    public void adicionarAula(Aula aula) {
        if (!aulasMinistradas.contains(aula)) {
            this.aulasMinistradas.add(aula);
        }
    }

    @Override
    public String toString() {
        return "Professor: " + nome;
    }
}