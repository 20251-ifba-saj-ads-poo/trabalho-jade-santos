package br.edu.ifba.saj.fwads.controller;

import br.edu.ifba.saj.fwads.model.SistemaAcademia;
import br.edu.ifba.saj.fwads.model.Aluno;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
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

    private SistemaAcademia sistema;

    public void initialize() {
        sistema = SistemaAcademia.getInstance();
        cbAulas.setItems(sistema.getAulas().stream().map(aula -> aula.getNomeAula()).collect(Collectors.toCollection(javafx.collections.FXCollections::observableArrayList)));
    }

    @FXML
    public void listarAlunos() {
        String aulaSelecionada = cbAulas.getSelectionModel().getSelectedItem();
        if (aulaSelecionada != null) {
            lvAlunos.setItems(sistema.listarAlunosPorAula(aulaSelecionada));
        }
    }
}