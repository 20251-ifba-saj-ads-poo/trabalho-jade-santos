package br.edu.ifba.saj.fwads.controller;

import br.edu.ifba.saj.fwads.App;
import br.edu.ifba.saj.fwads.model.Usuario;
import javafx.css.PseudoClass;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
<<<<<<< HEAD:trabalho-jade-santos-main/src/main/java/br/edu/ifba/saj/fwads/controller/MasterController.java
import javafx.scene.Node;
import javafx.scene.control.Button;
=======
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.Alert.AlertType;
>>>>>>> 8ca9d1a9258ee634f8210b55542203c31b022a1a:src/main/java/br/edu/ifba/saj/fwads/controller/MasterController.java
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Circle;
import net.bytebuddy.jar.asm.Label;

import java.io.IOException;

import javax.swing.text.html.ImageView;

public class MasterController {

<<<<<<< HEAD:trabalho-jade-santos-main/src/main/java/br/edu/ifba/saj/fwads/controller/MasterController.java
     @FXML
=======
    @FXML
    private Button menuItemCadAutor;

    @FXML
    private Button menuItemCadLivro;

    @FXML
    private Button menuItemHome;

    @FXML
    private Button menuItemListAutor;

    @FXML
    private Button menuItemListLivro;

    @FXML
>>>>>>> 8ca9d1a9258ee634f8210b55542203c31b022a1a:src/main/java/br/edu/ifba/saj/fwads/controller/MasterController.java
    private BorderPane masterPane;

    @FXML
    private VBox menu;

    @FXML
    private ImageView showHome;

    @FXML
<<<<<<< HEAD:trabalho-jade-santos-main/src/main/java/br/edu/ifba/saj/fwads/controller/MasterController.java
    private Label userEmail;

    @FXML
=======
>>>>>>> 8ca9d1a9258ee634f8210b55542203c31b022a1a:src/main/java/br/edu/ifba/saj/fwads/controller/MasterController.java
    private Circle userPicture;

    private Usuario usuarioLogado;

    public void setUsuarioLogado(Usuario usuarioLogado) {
        this.usuarioLogado = usuarioLogado;
        setEmail(usuarioLogado.getEmail());
    }

    @FXML
    void logOff(MouseEvent event) {
<<<<<<< HEAD:trabalho-jade-santos-main/src/main/java/br/edu/ifba/saj/fwads/controller/MasterController.java

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

=======
        Alert alert = new Alert(AlertType.CONFIRMATION, "Deseja realmente sair??", ButtonType.YES, ButtonType.NO);
        alert.showAndWait()
                .filter(response -> response == ButtonType.YES)
                .ifPresent(response -> {
                    App.setRoot("controller/Login.fxml");
                });
    }

    @FXML
    void showHome(ActionEvent event) {
        limparBotoes(event.getSource());
        masterPane.setCenter(new Pane());

    }

    @FXML
    void showUsuarios(ActionEvent event) {
        limparBotoes(event.getSource());
        masterPane.setCenter(new Pane());
    }

    private void limparBotoes(Object source) {
        menu.getChildren().forEach((node) -> {
            if (node instanceof Button btn) {
                node.pseudoClassStateChanged(PseudoClass.getPseudoClass("selected"), false);
            }
        }

        );
        if (source instanceof Button btn) {
            btn.pseudoClassStateChanged(PseudoClass.getPseudoClass("selected"), true);
        }
    }

>>>>>>> 8ca9d1a9258ee634f8210b55542203c31b022a1a:src/main/java/br/edu/ifba/saj/fwads/controller/MasterController.java
    @FXML
    void showCadAutor(ActionEvent event) {
        limparBotoes(event.getSource());
        CadAutorController controller = (CadAutorController) showFXMLFile("CadAutor.fxml");
        controller.setMasterController(this);
    }

    private void limparBotoes(Object source) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'limparBotoes'");
    }

    @FXML
    void showListAutor(ActionEvent event) {
        limparBotoes(event.getSource());
        showFXMLFile("ListAutor.fxml");
    }

    @FXML
    void showListLivro(ActionEvent event) {
        limparBotoes(event.getSource());
        showFXMLFile("ListLivro.fxml");
    }

    @FXML
    void showCadLivro(ActionEvent event) {
        limparBotoes(event.getSource());
        showFXMLFile("CadLivro.fxml");
    }

    public Object showFXMLFile(String resourceName) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(resourceName));
            Pane fxmlCarregado = loader.load();
            masterPane.setCenter(fxmlCarregado);
            return loader.getController();

        } catch (Exception e) {
            new Alert(AlertType.ERROR, "Erro ao carregar o arquivo " + resourceName).showAndWait();
            e.printStackTrace();
        }
        return null;
    }

    private void setEmail(String email) {
        userEmail.setText(email);
    }
}
