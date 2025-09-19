package br.edu.ifba.saj.fwads.service;

import br.edu.ifba.saj.fwads.model.Aluno;
import br.edu.ifba.saj.fwads.model.Aula;
import br.edu.ifba.saj.fwads.repository.AlunoRepository;
import br.edu.ifba.saj.fwads.repository.AulaRepository;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class AlunoService {
    private static AlunoService instance;
    private AlunoRepository alunoRepository;
    private AulaRepository aulaRepository;

    private AlunoService() {
        this.alunoRepository = AlunoRepository.getInstance();
        this.aulaRepository = AulaRepository.getInstance();
    }

    public static AlunoService getInstance() {
        if (instance == null) {
            instance = new AlunoService();
        }
        return instance;
    }

    public ObservableList<Aluno> listarAlunos() {
        return alunoRepository.findAll();
    }

    public void cadastrarAluno(String nome, String cpf, String email) {
        Aluno novoAluno = new Aluno(nome, cpf, email);
        alunoRepository.save(novoAluno);
    }
    
    public void inscreverAlunoEmAula(Aluno aluno, String nomeAula) {
        Aula aula = aulaRepository.findByName(nomeAula);
        if (aula != null && aluno != null) {
            aluno.inscreverEmAula(aula);
        }
    }
    
    public ObservableList<Aluno> listarAlunosPorModalidade(String nomeAula) {
        Aula aula = aulaRepository.findByName(nomeAula);
        if (aula != null) {
            return aula.getAlunosInscritos();
        }
        return FXCollections.emptyObservableList();
    }
}