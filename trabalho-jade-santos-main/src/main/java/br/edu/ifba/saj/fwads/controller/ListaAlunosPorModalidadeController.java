package br.edu.ifba.saj.fwads.controller;

import br.edu.ifba.saj.fwads.App;
import br.edu.ifba.saj.fwads.model.Aluno;
import br.edu.ifba.saj.fwads.service.AlunoService;
import br.edu.ifba.saj.fwads.service.AulaService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import java.util.stream.Collectors;

public class ListaAlunosPorModalidadeController {

    @FXML
    private ComboBox<String> cbAulas;

    @FXML
    private ListView<Aluno> lvAlunos;

    @FXML
    private Label lbAlunos;

    private AlunoService alunoService = AlunoService.getInstance();
    private AulaService aulaService = AulaService.getInstance();

    public void initialize() {
        cbAulas.setItems(aulaService.listarAulas().stream().map(aula -> aula.getNomeAula()).collect(Collectors.toCollection(javafx.collections.FXCollections::observableArrayList)));
    }

    @FXML
    public void listarAlunos() {
        String aulaSelecionada = cbAulas.getSelectionModel().getSelectedItem();
        if (aulaSelecionada != null) {
            lvAlunos.setItems(alunoService.listarAlunosPorModalidade(aulaSelecionada));
        }
    }

    @FXML
    void showNovoLivro(ActionEvent event) {

        Stage stage = new Stage();
        Scene scene = new Scene(App.loadFXML("controller/CadAluno.fxml"), 800, 600);
        stage.setScene(scene);
        stage.initModality(Modality.APPLICATION_MODAL);
        CadAlunoController controller = (CadAlunoController) App.getController();
        controller.setAlunosPorModalidadeController(this);

        stage.showAndWait();

    }
}