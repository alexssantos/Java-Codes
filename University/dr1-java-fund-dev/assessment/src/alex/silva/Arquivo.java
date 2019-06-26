package alex.silva;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.List;
import java.util.Scanner;


public class Arquivo
{
    private String nomeArq;
    private final String SEPARADOR = " \\| ";

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

    public void pegaCliente(Scanner entrada, List<Cliente> clientes) {

        String linha;
        String[] campos;
        try {
            while (entrada.hasNext())
            {
                linha = entrada.nextLine();
                campos = linha.split(SEPARADOR);    //ex.: 88889999 | Alex | PrePago | 20

                long numero = Long.parseLong(campos[0]);
                String nome = campos[1];
                Cliente.ClientePlanoTipo plano = (Cliente.ClientePlanoTipo.PosPago.toString().equals(campos[2])) ? Cliente.ClientePlanoTipo.PosPago : Cliente.ClientePlanoTipo.PrePago;
                int creditos = Integer.parseInt(campos[3]);

                Cliente cliente = new Cliente(numero,nome,plano,creditos);
                clientes.add(cliente);
            }
        }
        catch (Exception e) {
            System.out.println("Erro: na leitura do arquivo: "+nomeArq);
        }
    }

    public void pegaLigacoes(Scanner entrada, List<Ligacao> ligacaos){
        String linha;
        String[] campos;
        try {
            while (entrada.hasNext())
            {
                linha = entrada.nextLine();
                campos = linha.split(SEPARADOR);    // ex.: 12345678 | 10:10 | 10:20

                long numero = Long.parseLong(campos[0]);
                String inicio = campos[1];
                String fim = campos[2];

                Ligacao ligacao = new Ligacao(numero,inicio,fim);
                ligacaos.add(ligacao);
            }
        }
        catch (Exception e) {
            System.out.println("Erro: na leitura do arquivo: "+nomeArq);
        }
    }

    public void gravaClientes(Formatter saida, List<Cliente> clientes) {

        for (Cliente cliente : clientes) {
            try {

                saida.format("%d | %s | %s | %s\n",
                        cliente.getNumeroCelular(),
                        cliente.getNomeCliente(),
                        cliente.getPlanoCliente().toString(),
                        cliente.getCreditos());
            }
            catch (Exception e) {
                System.out.println("Erro: gravacao do arquivo: "+nomeArq);
            }
        }
    }

    public void gravaLigacoes(Formatter saida, List<Ligacao> ligacoes) {

        for (Ligacao ligacao : ligacoes) {
            try {

                saida.format("%d | %s | %s\n",
                    ligacao.getNumero(),
                    ligacao.getInicio(),
                    ligacao.getFim()
                );
            }
            catch (Exception e) {
                System.out.println("Erro: gravacao do arquivo: "+nomeArq);
            }
        }
    }

    public void fechaLeitor(Scanner entrada) {

        if (entrada != null) {
            entrada.close();
        }
    }

    public void fechaGravador(Formatter saida) {

        if (saida != null) {
            saida.close();
        }
    }
}
