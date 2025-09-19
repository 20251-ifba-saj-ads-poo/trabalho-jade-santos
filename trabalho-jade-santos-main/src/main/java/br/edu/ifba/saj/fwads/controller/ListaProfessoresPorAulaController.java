package br.edu.ifba.saj.fwads.controller;

import br.edu.ifba.saj.fwads.App;
import br.edu.ifba.saj.fwads.model.Aula;
import br.edu.ifba.saj.fwads.service.AulaService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class ListaProfessoresPorAulaController {
    
    @FXML
    private ListView<String> lvProfessoresPorAula;

    private AulaService aulaService = AulaService.getInstance();

    public void initialize() {
        for (Aula aula : aulaService.listarAulas()) {
            String item = aula.getNomeAula() + " - " + (aula.getProfessor() != null ? aula.getProfessor().getNome() : "Nenhum professor");
            lvProfessoresPorAula.getItems().add(item);
        }
    }

    @FXML
    void showProfessor(ActionEvent event) {

        Stage stage = new Stage();
        Scene scene = new Scene(App.loadFXML("controller/CadProfessor.fxml"), 800, 600);
        stage.setScene(scene);
        stage.initModality(Modality.APPLICATION_MODAL);
        CadProfessorController controller = (CadProfessorController) App.getController();
        controller.setListProfessoresPorAulaController(this);

        stage.showAndWait();

    }
}