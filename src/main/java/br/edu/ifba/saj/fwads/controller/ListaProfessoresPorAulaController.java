package br.edu.ifba.saj.fwads.controller;

import br.edu.ifba.saj.fwads.model.SistemaAcademia;
import br.edu.ifba.saj.fwads.model.Aula;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;

public class ListaProfessoresPorAulaController {
    
    @FXML
    private ListView<String> lvProfessoresPorAula;

    private SistemaAcademia sistema;

    public void initialize() {
        sistema = SistemaAcademia.getInstance();
        
        for (Aula aula : sistema.getAulas()) {
            String item = aula.getNomeAula() + " - " + (aula.getProfessor() != null ? aula.getProfessor().getNome() : "Nenhum professor");
            lvProfessoresPorAula.getItems().add(item);
        }
    }
}