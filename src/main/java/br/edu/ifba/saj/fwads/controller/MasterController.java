package br.edu.ifba.saj.fwads.controller;

import java.io.IOException;

import br.edu.ifba.saj.fwads.App;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Circle;

public class MasterController {

    @FXML
    private BorderPane masterPane;

    @FXML
    private VBox menu;

    @FXML
    private Label userEmail;

    @FXML
    private ImageView showHome;

    @FXML
    private Circle userPicture;

    @FXML
    void logOff(MouseEvent event) {
        Alert alert = new Alert(AlertType.CONFIRMATION, "Deseja realmente sair??", ButtonType.YES, ButtonType.NO);
        alert.showAndWait()
            .filter(response -> response == ButtonType.YES)
            .ifPresent(response -> {
                App.setRoot("controller/Login.fxml");
            });
    }

    private void showFXMLFile(String fxmlPath) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/br/edu/ifba/saj/fwads/view/" + fxmlPath));
            Node content = loader.load();
            masterPane.setCenter(content);
        } catch (IOException e) {
            e.printStackTrace();
            // Handle the error appropriately, maybe show an alert
        }
    }

    @FXML
    public void showHome(ActionEvent event) {
        limparBotoes(event.getSource());
        masterPane.setCenter(new Pane());
    }

    private void limparBotoes(Object source) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'limparBotoes'");
    }

    @FXML
    public void showProfessor(ActionEvent event) {
        limparBotoes(event.getSource());
        showFXMLFile("CadProfessor.fxml");
    }

    @FXML
    public void showAlunos(ActionEvent event) {
        limparBotoes(event.getSource());
        showFXMLFile("CadAluno.fxml");
    }

    @FXML
    public void showAula(ActionEvent event) {
        limparBotoes(event.getSource());
        showFXMLFile("CadAula.fxml");
    }

    
    @FXML
    public void showListaAlunosPorModalidade(ActionEvent event) {
        limparBotoes(event.getSource());
        showFXMLFile("ListaAlunosPorModalidade.fxml");
    }
    
    @FXML
    public void showListaProfessoresPorAula(ActionEvent event) {
        limparBotoes(event.getSource());
        showFXMLFile("ListaProfessoresPorAula.fxml");
    }
}