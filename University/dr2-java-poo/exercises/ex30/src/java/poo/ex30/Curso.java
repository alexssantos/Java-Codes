package java.poo.ex30;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Curso {

    private String nomeDoCurso;
    //private List<Aluno> alunosList;
    private Aluno[] alunosArray;
    private int qtdAlunos = 0;

    public Curso(String nomeDoCurso, int vagasTotal) {
        this.nomeDoCurso = nomeDoCurso;

        if (alunosArray == null){
            alunosArray = new Aluno[vagasTotal];
        }

        if (this.CursosList == null){
            CursosList = new ArrayList<Curso>();
        }
    }

    public boolean matricular(Aluno aluno){
        boolean isMatriculado= false;

        Aluno matriculado = Arrays.stream(alunosArray).filter(x -> x.matricula == aluno.matricula).findFirst().orElse(null);
        if (matriculado != null){
            return isMatriculado;
        }
        //TODO: add aluno na lista de matriculados

        //TODO: qtdAlunos ++

        return isMatriculado;
    }

    public boolean cancelarMatricula(int matricula){
        boolean isCanceled = false;

        for (int i =0; i < alunosArray.length; i++){
            if (alunosArray[i].getMatricula() == matricula){

            }
        }

        return  isCanceled;
    }

    public void imprimir(){
        System.out.println("Curso :" + nomeDoCurso);
        System.out.println("Matriculados :" + nomeDoCurso);
    }

    // Static Attributs
    public static List<Curso> CursosList;
}
