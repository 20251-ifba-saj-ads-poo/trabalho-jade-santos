package br.edu.ifba.saj.fwads.controller;

import br.edu.ifba.saj.fwads.App;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.event.ActionEvent;

public class LoginController {

    @FXML private TextField txUsuario;
    @FXML private PasswordField txSenha;

    @FXML
    public void entrar(ActionEvent event) {
        String usuario = txUsuario.getText();
        String senha = txSenha.getText();

        if (usuario.equals("admin") && senha.equals("admin")) {
            try {
                App.setRoot("Master");
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erro");
            alert.setHeaderText("Usuário ou senha inválidos");
            alert.setContentText("Tente novamente.");
            alert.showAndWait();
        }
    }

    @FXML
    public void limparCampos() {
        txUsuario.setText("");
        txSenha.setText("");
    }
}