package alex.silva;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.Scanner;

public class Arquivo
{
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

    public void leArquivo(Scanner entrada, ArrayList<Cliente> turma) {

        String linha;
        String[] campos;
        try {
            while (entrada.hasNext())
            {
                linha = entrada.nextLine();
                campos = linha.split(";");
//                Cliente cliente = new Cliente(
//                        campos[0],
//                        Integer.parseInt(campos[1]),
//                        Integer.parseInt(campos[2]));
//                turma.add(cliente);
            }
        }
        catch (Exception e) {
            System.out.println("Erro: na leitura do arquivo");
        }
    }

    public void gravaArquivo(Formatter saida, ArrayList<Cliente> clientes) {

        for (Cliente cliente : clientes) {
            try {
//                saida.format("%s;%d;%d\n", cliente.getNome(), cliente.getN1(),
//                        cliente.getN2());
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
