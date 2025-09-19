package br.edu.ifba.saj.fwads.controller;

import br.edu.ifba.saj.fwads.service.AulaService;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

public class CadAulaController {

    @FXML private TextField txNomeAula;
    @FXML private TextField txHoraAula;
    @FXML private TextField txProfessorAula;

    private AulaService aulaService = AulaService.getInstance();

    @FXML
    public void salvarAula() {
        String nomeAula = txNomeAula.getText();
        String horaAula = txHoraAula.getText();
        String nomeProfessor = txProfessorAula.getText();

        try {
            aulaService.cadastrarAula(nomeAula, horaAula, nomeProfessor);

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Cadastro de Aula");
            alert.setHeaderText(null);
            alert.setContentText("Aula cadastrada com sucesso!");
            alert.showAndWait();

            limparTela();
        } catch (IllegalArgumentException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erro");
            alert.setHeaderText(null);
            alert.setContentText(e.getMessage());
            alert.showAndWait();
        }
    }

    @FXML
    public void limparTela() {
        txNomeAula.setText("");
        txHoraAula.setText("");
        txProfessorAula.setText("");
    }
}