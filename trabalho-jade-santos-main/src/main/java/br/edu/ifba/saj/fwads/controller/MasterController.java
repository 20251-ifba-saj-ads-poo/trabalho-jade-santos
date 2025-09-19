package br.edu.ifba.saj.fwads.controller;

import br.edu.ifba.saj.fwads.App;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Circle;
import net.bytebuddy.jar.asm.Label;

import java.io.IOException;

import javax.swing.text.html.ImageView;

public class MasterController {

     @FXML
    private BorderPane masterPane;

    @FXML
    private VBox menu;

    @FXML
    private ImageView showHome;

    @FXML
    private Label userEmail;

    @FXML
    private Circle userPicture;

    @FXML
    void logOff(MouseEvent event) {

    }

    private void showFXMLFile(String fxmlPath) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/br/edu/ifba/saj/fwads/view/" + fxmlPath));
            Node content = loader.load();
            masterPane.setCenter(content);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void showHome(ActionEvent event) {
            limparBotoes(event.getSource());
        masterPane.setCenter(new Pane());
    }

    @FXML
    public void showProfessor(ActionEvent event) {
        limparBotoes(event.getSource());
        showFXMLFile("CadProfessor.fxml");
    }

    private void limparBotoes(Object source) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'limparBotoes'");
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