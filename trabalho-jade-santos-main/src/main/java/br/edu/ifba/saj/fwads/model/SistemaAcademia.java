package br.edu.ifba.saj.fwads.model;

import br.edu.ifba.saj.fwads.model.Aluno;
import br.edu.ifba.saj.fwads.model.Professor;
import br.edu.ifba.saj.fwads.model.Aula;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class SistemaAcademia {

    private static SistemaAcademia instance;
    private ObservableList<Aluno> alunos;
    private ObservableList<Professor> professores;
    private ObservableList<Aula> aulas;

    private SistemaAcademia() {
        alunos = FXCollections.observableArrayList();
        professores = FXCollections.observableArrayList();
        aulas = FXCollections.observableArrayList();

    }    
    
    public static SistemaAcademia getInstance() {
        if (instance == null) {
            instance = new SistemaAcademia();
        }
        return instance;
    }

    public ObservableList<Aluno> getAlunos() {
        return alunos;
    }

    public ObservableList<Professor> getProfessores() {
        return professores;
    }

    public ObservableList<Aula> getAulas() {
        return aulas;
    }
    
    public ObservableList<Aluno> listarAlunosPorAula(String nomeAula) {
        for (Aula aula : aulas) {
            if (aula.getNomeAula().equalsIgnoreCase(nomeAula)) {
                return aula.getAlunosInscritos();
            }
        }
        return FXCollections.observableArrayList();
    }
    
    public Professor getProfessorPorAula(String nomeAula) {
        for (Aula aula : aulas) {
            if (aula.getNomeAula().equalsIgnoreCase(nomeAula)) {
                return aula.getProfessor();
            }
        }
        return null;
    }
}