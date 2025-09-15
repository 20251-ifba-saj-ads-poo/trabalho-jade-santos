package br.edu.ifba.saj.fwads.controller;

import br.edu.ifba.saj.fwads.model.SistemaAcademia;
import br.edu.ifba.saj.fwads.model.Aluno;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

public class CadAlunoController {
    
    @FXML private TextField txNome;
    @FXML private TextField txEmail;
    @FXML private TextField txCPF;
    
    @FXML
    public void salvarAluno() {
        String nome = txNome.getText();
        String email = txEmail.getText();
        String cpf = txCPF.getText();
        
        Aluno novoAluno = new Aluno(nome, cpf, email);
        SistemaAcademia.getInstance().getAlunos().add(novoAluno);
        
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
}