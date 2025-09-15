package br.edu.ifba.saj.fwads.controller;

import br.edu.ifba.saj.fwads.model.SistemaAcademia;
import br.edu.ifba.saj.fwads.model.Aula;
import br.edu.ifba.saj.fwads.model.Professor;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

public class CadAulaController {

    @FXML private TextField txNomeAula;
    @FXML private TextField txHoraAula;
    @FXML private TextField txProfessorAula; // Campo para o nome do professor

    @FXML
    public void salvarAula() {
        String nomeAula = txNomeAula.getText();
        String horaAula = txHoraAula.getText();
        String nomeProfessor = txProfessorAula.getText();

        // Encontrar o professor pelo nome. Em um sistema real, seria melhor usar um ID
        Professor professorResponsavel = SistemaAcademia.getInstance().getProfessores()
            .stream()
            .filter(p -> p.getNome().equalsIgnoreCase(nomeProfessor))
            .findFirst()
            .orElse(null);

        if (professorResponsavel != null) {
            Aula novaAula = new Aula(nomeAula, horaAula, professorResponsavel);
            SistemaAcademia.getInstance().getAulas().add(novaAula);
            professorResponsavel.adicionarAula(novaAula);

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Cadastro de Aula");
            alert.setHeaderText(null);
            alert.setContentText("Aula cadastrada com sucesso!");
            alert.showAndWait();

            limparTela();
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erro");
            alert.setHeaderText(null);
            alert.setContentText("Professor não encontrado. Por favor, cadastre o professor primeiro.");
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