package alex.silva;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.Scanner;

public class Arquivo {
    private String nomeArq;
    
    public Arquivo(String nome) {
        nomeArq = nome;
    }
    
    public Scanner abreArquivo() {
        Scanner entrada = null;
        
        try {
            entrada = new Scanner(new File(nomeArq));
        }
        catch (FileNotFoundException e) {
            System.out.println("Erro: abertura do arquivo");
        }
        return entrada;
    }
    
    public Formatter abreArquivoGravar() {
        Formatter saida = null;
        
        try {
            saida = new Formatter(new File(nomeArq));
        }
        catch (FileNotFoundException e) {
            System.out.println("Erro: abertura gravação");
        }
        return saida;
    }
    
    public void leArquivo(Scanner entrada, ArrayList<Aluno> turma) {
        
        String linha;
        String[] campos;
        try {
            while (entrada.hasNext()) {
                linha = entrada.nextLine();
                campos = linha.split(";");
                Aluno aluno = new Aluno(campos[0], Integer.parseInt(campos[1]), 
                        Integer.parseInt(campos[2]));
                turma.add(aluno);
            }
        }
        catch (Exception e) {
            System.out.println("Erro: na leitura do arquivo");
        }
    }
    
    public void gravaArquivo(Formatter saida, ArrayList<Aluno> turma) {
        
        for (Aluno aluno : turma) {
            try {
                saida.format("%s;%d;%d\n", aluno.getNome(), aluno.getN1(),
                        aluno.getN2());
            }
            catch (Exception e) {
                System.out.println("Erro: gravacao do arquivo");
            }
        }
    }
    
    public void fechaArquivo(Scanner entrada) {
        
        if (entrada != null) {
            entrada.close();
        }
    }
    
    public void fechaArquivo(Formatter saida) {
        
        if (saida != null) {
            saida.close();
        }
    }
}