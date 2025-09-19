package br.edu.ifba.saj.fwads.controller;

import br.edu.ifba.saj.fwads.service.AlunoService;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

public class CadAlunoController {
    
    @FXML private TextField txNome;
    @FXML private TextField txEmail;
    @FXML private TextField txCPF;

    private AlunoService alunoService = AlunoService.getInstance();
    
    @FXML
    public void salvarAluno() {
        String nome = txNome.getText();
        String email = txEmail.getText();
        String cpf = txCPF.getText();
        
        alunoService.cadastrarAluno(nome, cpf, email);
        
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Cadastro de Aluno");
        alert.setHeaderText(null);
        alert.setContentText("Aluno cadastrado com sucesso!");
        alert.showAndWait();
        
        limparTela();
    }
    
    @FXML
    public void limparTela() {
        txNome.setText("");
        txEmail.setText("");
        txCPF.setText("");
    }

    public void setAlunosPorModalidadeController(
        ListaAlunosPorModalidadeController listaAlunosPorModalidadeController) {
      }
}