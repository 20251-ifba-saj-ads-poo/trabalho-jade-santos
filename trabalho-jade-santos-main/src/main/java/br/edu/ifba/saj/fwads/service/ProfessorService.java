package br.edu.ifba.saj.fwads.service;

import br.edu.ifba.saj.fwads.model.Professor;
import br.edu.ifba.saj.fwads.repository.ProfessorRepository;
import javafx.collections.ObservableList;

public class ProfessorService {
    private static ProfessorService instance;
    private ProfessorRepository professorRepository;

    private ProfessorService() {
        this.professorRepository = ProfessorRepository.getInstance();
    }

    public static ProfessorService getInstance() {
        if (instance == null) {
            instance = new ProfessorService();
        }
        return instance;
    }

    public ObservableList<Professor> listarProfessores() {
        return professorRepository.findAll();
    }

    public void cadastrarProfessor(String nome, String email, String cpf) {
        Professor novoProfessor = new Professor(nome, email, cpf);
        professorRepository.save(novoProfessor);
    }
    
    public Professor buscarProfessorPorNome(String nome) {
        return professorRepository.findByName(nome);
    }
}