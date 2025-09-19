package br.edu.ifba.saj.fwads.repository;

import br.edu.ifba.saj.fwads.model.Aula;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class AulaRepository {
    private static AulaRepository instance;
    private ObservableList<Aula> aulas;

    private AulaRepository() {
        aulas = FXCollections.observableArrayList();
    }

    public static AulaRepository getInstance() {
        if (instance == null) {
            instance = new AulaRepository();
        }
        return instance;
    }

    public ObservableList<Aula> findAll() {
        return aulas;
    }

    public void save(Aula aula) {
        aulas.add(aula);
    }
    
    public Aula findByName(String name) {
        return aulas.stream()
            .filter(aula -> aula.getNomeAula().equalsIgnoreCase(name))
            .findFirst()
            .orElse(null);
    }
}