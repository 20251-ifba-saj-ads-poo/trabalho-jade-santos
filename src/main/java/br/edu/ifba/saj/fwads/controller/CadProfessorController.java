package br.edu.ifba.saj.fwads.controller;

import br.edu.ifba.saj.fwads.model.SistemaAcademia;
import br.edu.ifba.saj.fwads.model.Professor;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

public class CadProfessorController {

    @FXML private TextField txNome;
    @FXML private TextField txEmail;
    @FXML private TextField txCPF;

    @FXML
    public void salvarProfessor() {
        String nome = txNome.getText();
        String email = txEmail.getText();
        String cpf = txCPF.getText();

        Professor novoProfessor = new Professor(nome, email, cpf);
        SistemaAcademia.getInstance().getProfessores().add(novoProfessor);

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
}