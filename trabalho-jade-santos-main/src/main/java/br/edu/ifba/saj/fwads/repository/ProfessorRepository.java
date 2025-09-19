package br.edu.ifba.saj.fwads.repository;

import br.edu.ifba.saj.fwads.model.Professor;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class ProfessorRepository {
    private static ProfessorRepository instance;
    private ObservableList<Professor> professores;

    private ProfessorRepository() {
        professores = FXCollections.observableArrayList();
    }

    public static ProfessorRepository getInstance() {
        if (instance == null) {
            instance = new ProfessorRepository();
        }
        return instance;
    }

    public ObservableList<Professor> findAll() {
        return professores;
    }

    public void save(Professor professor) {
        professores.add(professor);
    }
    
    public Professor findByName(String name) {
        return professores.stream()
            .filter(professor -> professor.getNome().equalsIgnoreCase(name))
            .findFirst()
            .orElse(null);
    }
}
