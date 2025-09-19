package br.edu.ifba.saj.fwads.controller;

import br.edu.ifba.saj.fwads.service.ProfessorService;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import br.edu.ifba.saj.fwads.model.Professor;

public class ListaProfessorController {

    @FXML private ListView<Professor> txListaProfessor;

    private ProfessorService professorService = ProfessorService.getInstance();

    public void initialize() {
        txListaProfessor.setItems(professorService.listarProfessores());
    }
}