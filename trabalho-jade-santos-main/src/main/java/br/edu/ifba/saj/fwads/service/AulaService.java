package br.edu.ifba.saj.fwads.service;

import br.edu.ifba.saj.fwads.model.Aula;
import br.edu.ifba.saj.fwads.model.Professor;
import br.edu.ifba.saj.fwads.repository.AulaRepository;
import br.edu.ifba.saj.fwads.repository.ProfessorRepository;
import javafx.collections.ObservableList;

public class AulaService {
    private static AulaService instance;
    private AulaRepository aulaRepository;
    private ProfessorRepository professorRepository;

    private AulaService() {
        this.aulaRepository = AulaRepository.getInstance();
        this.professorRepository = ProfessorRepository.getInstance();
    }

    public static AulaService getInstance() {
        if (instance == null) {
            instance = new AulaService();
        }
        return instance;
    }

    public ObservableList<Aula> listarAulas() {
        return aulaRepository.findAll();
    }

    public void cadastrarAula(String nomeAula, String horario, String nomeProfessor) {
        Professor professor = professorRepository.findByName(nomeProfessor);
        if (professor != null) {
            Aula novaAula = new Aula(nomeAula, horario, professor);
            aulaRepository.save(novaAula);
            professor.adicionarAula(novaAula);
        } else {
            throw new IllegalArgumentException("Professor não encontrado: " + nomeProfessor);
        }
    }
    
    public Professor getProfessorPorAula(String nomeAula) {
        Aula aula = aulaRepository.findByName(nomeAula);
        return aula != null ? aula.getProfessor() : null;
    }
}