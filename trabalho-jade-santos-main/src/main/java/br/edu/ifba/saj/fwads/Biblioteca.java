package br.edu.ifba.saj.fwads;

import br.edu.ifba.saj.fwads.model.Professor;
import br.edu.ifba.saj.fwads.model.Aluno;
import br.edu.ifba.saj.fwads.model.Aula;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Biblioteca {
    
    public static ObservableList<Professor> listaProfessores = FXCollections.observableArrayList();
    static{
        //listaAutores.add(new Autor("Jose","jose@seila.com","123.456.789.-11"));
    }

    public static ObservableList<Aluno> listaAlunos = FXCollections.observableArrayList();
    static{
        //listaAutores.add(new Autor("Jose","jose@seila.com","123.456.789.-11"));
    }

    public static ObservableList<Aula> listaAulas = FXCollections.observableArrayList();
    static{
        //listaAutores.add(new Autor("Jose","jose@seila.com","123.456.789.-11"));
    }
    
    
}
