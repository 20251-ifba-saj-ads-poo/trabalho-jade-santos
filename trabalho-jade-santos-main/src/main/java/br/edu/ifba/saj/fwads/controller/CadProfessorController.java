package br.edu.ifba.saj.fwads.controller;

import br.edu.ifba.saj.fwads.service.ProfessorService;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

public class CadProfessorController {

    @FXML private TextField txNome;
    @FXML private TextField txEmail;
    @FXML private TextField txCPF;

    private ProfessorService professorService = ProfessorService.getInstance();

    @FXML
    public void salvarProfessor() {
        String nome = txNome.getText();
        String email = txEmail.getText();
        String cpf = txCPF.getText();

        professorService.cadastrarProfessor(nome, email, cpf);

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Cadastro de Professor");
        alert.setHeaderText(null);
        alert.setContentText("Professor cadastrado com sucesso!");
        alert.showAndWait();

        limparTela();
    }

    @FXML
    public void limparTela() {
        txNome.setText("");
        txEmail.setText("");
        txCPF.setText("");
    }

    public void setListProfessoresPorAulaController(
        ListaProfessoresPorAulaController listaProfessoresPorAulaController) {
    }
}