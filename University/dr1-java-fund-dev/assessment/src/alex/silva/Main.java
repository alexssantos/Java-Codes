package alex.silva;

import java.util.ArrayList;
import java.util.Formatter;
import java.util.Scanner;

public class Main {

    public static void main(String[] args)
    {
        //Pegar o arquivo de Clientes.



        //Menu
        final int FIM = 0;
        final String NOME = "turma.txt";
        ArrayList<Cliente> clientes = new ArrayList<>();
        Arquivo arquivo = new Arquivo(NOME);
        int opcao;
        Scanner entrada;
        Formatter saida;

        entrada = arquivo.abreArquivo();
        if (entrada != null) {
            arquivo.leArquivo(entrada, clientes);
            arquivo.fechaArquivo(entrada);
        }
        opcao = menu();
        while (opcao != FIM) {
            switch (opcao) {
                case 1: incluir(turma);
                    break;
                case 2: alterar(turma);
                    break;
                case 3: excluir(turma);
                    break;
                case 4: listar(turma);
                    break;
            }
            opcao = menu();
        }
        saida = arquivo.abreArquivoGravar();
        if (saida != null) {
            arquivo.gravaArquivo(saida, turma);
            arquivo.fechaArquivo(saida);
        }


    }
}
