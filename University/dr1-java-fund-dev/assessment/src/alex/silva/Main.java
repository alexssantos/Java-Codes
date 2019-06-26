package alex.silva;

import java.util.ArrayList;
import java.util.Formatter;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args)
    {
        //Pegar o arquivo de Clientes
        final int FIM = 0;
        final String CLIENTES = "clientes_db.txt";
        final String LIGACOES = "ligacoes_db.txt";
        List<Cliente> clientesLista = new ArrayList<>();
        List<Ligacao> ligacoesLista = new ArrayList<>();


        // LÊ O ARQUIVO
        Arquivo arquivo = new Arquivo(CLIENTES);
        Scanner entrada = arquivo.abreArquivo();
        if (entrada != null) {
            arquivo.pegaCliente(entrada, clientesLista);
            arquivo.fechaLeitor(entrada);
        }

        arquivo = new Arquivo(LIGACOES);
        entrada = arquivo.abreArquivo();
        if (entrada != null) {
            arquivo.pegaLigacoes(entrada, ligacoesLista);
            arquivo.fechaLeitor(entrada);
        }



        /*MENUS:
        * 1. inclusão de cliente,
        * 2. alteração de cliente,
        * 3. exclusão de cliente,
        * 4. relatórios gerenciais
        * 0. saída do programa.
        */

        //MENU
        int opcao = menu();
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

        Formatter saida = arquivo.abreArquivoGravar();
        if (saida != null) {
            arquivo.gravaClientes(saida, clientesLista);
            arquivo.fechaGravador(saida);
        }
    }

    public static int menu() {
        //limpaTela();
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
    public static void incluir(List<Cliente> clientesLista)
    {
        String nome = leNome();
        int telefone = leTelefone("Entre com o Telefone (ex.: 988885555): ");



        //turma.add(new Cliente(nome, n1, n2));
    }

    public static void excluir(List<Cliente> clientes)
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

    public static void alterar(List<Cliente> clientes)
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

    public static int pesquisaNome(List<Cliente> clientes, String nome) {
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

    public static void listar(List<Cliente> clientes) {

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
        return nome;
    }

    public static int leNumero(String msg) {
        int num = 0;
        boolean ok = false;
        Scanner entrada = new Scanner(System.in);
        int tentativas = 3;

        do {
            try {
                if (tentativas == 0) {
                    break;
                };
                System.out.print(msg);
                num = entrada.nextInt();
                ok = true;

            }
            catch (Exception e) {
                System.out.println("Erro: número inválido");
                entrada.nextLine();
                tentativas--;
            }
        } while (!ok);
        return num;
    }

    public static int leTelefone(String msg) {
        int num = 0;
        boolean ok = false;
        Scanner in = new Scanner(System.in);
        int tentativas = 3;

        String regex = "^9[1-9][0-9]{7}$";  // 1° = 9 // 2° = 1-9
        do {
            try
            {
                if (tentativas == 0) {
                    break;
                };
                tentativas--;

                System.out.print(msg);
                String numero="";
                if (in.hasNextLine()){
                    numero = in.nextLine();
                }

                ok = Pattern.compile(regex).matcher(numero).matches();
                if (ok){
                    num = Integer.parseInt(numero);
                }
            }
            catch (Exception e) {
                System.out.println("Erro: número inválido");
                in.nextLine();
                tentativas--;
            }
        } while (!ok);
        return num;
    }
}
