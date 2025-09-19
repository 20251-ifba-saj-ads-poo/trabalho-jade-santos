package br.edu.ifba.saj.fwads.controller;

import br.edu.ifba.saj.fwads.service.AlunoService;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import br.edu.ifba.saj.fwads.model.Aluno;

public class ListaAlunoController {

    @FXML private ListView<Aluno> txListaAluno;

    private AlunoService alunoService = AlunoService.getInstance();

    public void initialize() {
        txListaAluno.setItems(alunoService.listarAlunos());
    }
}