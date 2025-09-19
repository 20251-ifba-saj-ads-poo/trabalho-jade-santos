package br.edu.ifba.saj.fwads.repository;

import br.edu.ifba.saj.fwads.model.Aluno;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class AlunoRepository {
    private static AlunoRepository instance;
    private ObservableList<Aluno> alunos;

    private AlunoRepository() {
        alunos = FXCollections.observableArrayList();
    }

    public static AlunoRepository getInstance() {
        if (instance == null) {
            instance = new AlunoRepository();
        }
        return instance;
    }

    public ObservableList<Aluno> findAll() {
        return alunos;
    }

    public void save(Aluno aluno) {
        alunos.add(aluno);
    }
    
    public Aluno findByCPF(String cpf) {
        return alunos.stream()
            .filter(aluno -> aluno.getCPF().equals(cpf))
            .findFirst()
            .orElse(null);
    }
}