package alex.silva;

import java.util.ArrayList;
import java.util.Formatter;
import java.util.Scanner;

public class Main {

    public static void main(String[] args)
    {
        //Pegar o arquivo de Clientes
        final int FIM = 0;
        final String NOME = "clientes_db.txt";
        ArrayList<Cliente> clientesLista = new ArrayList<>();
        Arquivo arquivo = new Arquivo(NOME);
        int opcao;
        Scanner entrada;
        Formatter saida;

        // LÊ O ARQUIVO
        entrada = arquivo.abreArquivo();
        if (entrada != null) {
            arquivo.leArquivo(entrada, clientesLista);
            arquivo.fechaArquivo(entrada);
        }

        /*MENUS:
        * 1. inclusão de cliente,
        * 2. alteração de cliente,
        * 3. exclusão de cliente,
        * 4. relatórios gerenciais
        * 0. saída do programa.
        */

        //MENU
        opcao = menu();
        while (opcao != FIM) {
            limpaTela();
            switch (opcao) {
                case 1: incluir(clientesLista);
                    break;
                case 2: alterar(clientesLista);
                    break;
                case 3: excluir(clientesLista);
                    break;
                case 4: listar(clientesLista);   //RELATORIO
                    break;
            }
            opcao = menu();
        }
        saida = arquivo.abreArquivoGravar();
        if (saida != null) {
            arquivo.gravaArquivo(saida, clientesLista);
            arquivo.fechaArquivo(saida);
        }
    }

    public static int menu() {
        limpaTela();
        int opcao;
        Scanner entrada = new Scanner(System.in);

        do {
            System.out.println("[1] - Incluir Cliente");
            System.out.println("[2] - Alterar Cliente");
            System.out.println("[3] - Excluir Cliente");
            System.out.println("[4] - Relatório de Ligações");
            System.out.println("[0] - Sair");
            opcao = leNumero("Entre com uma opção: ");
            if ((opcao < 0) || (opcao > 4)) {
                System.out.println("Erro: opcao inválida");
            }
        } while ((opcao < 0) || (opcao > 4));
        return opcao;
    }


    // CRUD
    public static void incluir(ArrayList<Cliente> clientesLista)
    {
        String nome;
        int telefone;

        nome = leNome();
        telefone = leNumero("Entre com o Telefone (ex.: 2222-5555): ");
        //validaTelefone()


        //turma.add(new Cliente(nome, n1, n2));
    }

    public static void excluir(ArrayList<Cliente> clientes)
    {
        if (clientes.isEmpty()) {
            System.out.println("Turma vazia");
            return;
        }
        listar(clientes);
        String nome = leNome();
        int pos = pesquisaNome(clientes, nome);
        if (pos == -1) {
            System.out.println("Erro: nome não encontrado");
            return;
        }
        clientes.remove(pos);
    }

    public static void alterar(ArrayList<Cliente> clientes)
    {
        if (clientes.isEmpty()) {
            System.out.println("Turma vazia");
            return;
        }

        String nome = leNome();
        int pos = pesquisaNome(clientes, nome);
        if (pos == -1) {
            System.out.println("Erro: nome não encontrado");
            return;
        }
        int n1 = leNumero("Entre com o Telefone (ex.: 2222-5555): ");
        int n2 = leNumero("Entre com a nota: ");
        //turma.get(pos).setN1(n1);
        //turma.get(pos).setN2(n2);
    }

    public static int pesquisaNome(ArrayList<Cliente> clientes, String nome) {
        int pos = -1;

        nome = nome.toLowerCase();
        for (int i = 0; i < clientes.size(); i++) {
            if (clientes.get(i).getNomeCliente().toLowerCase().equals(nome)) {
                pos = i;
                break;
            }
        }
        return pos;
    }

    public static void listar(ArrayList<Cliente> clientes) {

        if (clientes.isEmpty()) {
            System.out.println("Não há clientes!");
            return;
        }
        System.out.println("---------------");
        for (Cliente cliente: clientes) {
            System.out.println(cliente);
        }
        System.out.println("---------------");
    }


    // METODOS
    public static void limpaTela(){
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static String leNome() {
        String nome;
        Scanner entrada = new Scanner(System.in);

        System.out.print("Entre com o nome: ");
        nome = entrada.nextLine();
        entrada.close();
        return nome;
    }

    public static int leNumero(String msg) {
        int num = 0;
        boolean ok = false;
        Scanner entrada = new Scanner(System.in);

        do {
            try {
                System.out.print(msg);
                num = entrada.nextInt();
                ok = true;
            }
            catch (Exception e) {
                System.out.println("Erro: número inválido");
                entrada.nextLine();
            }
        } while (!ok);
        return num;
    }
}
