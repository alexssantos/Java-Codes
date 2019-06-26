package alex.silva;

import java.util.ArrayList;
import java.util.Formatter;
import java.util.List;
import java.util.Scanner;
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
        long telefone = leTelefone();
        if (telefone == 0)
            return;

        Cliente.ClientePlanoTipo plano = pegaPlano();
        if (plano == null)
            return;

        int creditos = leNumero("Quantidade de Creditos (ex: 7):");
        if (creditos == 0)
            return;

        Cliente cliente = new Cliente(telefone,nome,plano,creditos);
        clientesLista.add(cliente);

        terminouEscolha();
    }

    public static void excluir(List<Cliente> clientes)
    {
        listar(clientes);
        long numero = leTelefone();
        if (numero == 0) return;

        boolean removido = clientes.removeIf(x -> x.getNumeroCelular() == numero);

        if (!removido) {
            System.out.println("ERRO: nome não encontrado");
            return;
        }
        System.out.println("SUCESSO: cliente removido");
    }

    public static void alterar(List<Cliente> clientes)
    {
        if (clientes.isEmpty()) {
            System.out.println("Não há clientes cadastrados");
            return;
        }

        long telefone = leTelefone();
        if (telefone == 0) return;

        clientes.stream().filter(x -> (x.getNumeroCelular() == telefone));
        int pos = pesquisaCliente(clientes, telefone);
        if (pos == -1) {
            System.out.println("Erro: nome não encontrado");
            return;
        }

        String nome = leNome();
        Cliente.ClientePlanoTipo plano = pegaPlano();
        if (plano == null)
            return;

        int creditos = leNumero("Quantidade de Creditos (ex: 7):");
        if (creditos == 0)
            return;

        Cliente cliente = clientes.get(pos);
        cliente.setCreditos(creditos);
        cliente.setNomeCliente(nome);
        cliente.setPlanoCliente(plano);

        clientes.set(pos,cliente);
        System.out.println("SUCESSO: Cliente atualizado: \n"+cliente.toString());
    }

    public static int pesquisaCliente(List<Cliente> clientes, long telefone) {
        int pos = -1;

        for (int i = 0; i < clientes.size(); i++) {
            if (clientes.get(i).getNumeroCelular() == telefone) {
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

    public static Cliente.ClientePlanoTipo pegaPlano(){
        boolean ok = false;
        Scanner in = new Scanner(System.in);
        int tentativas = 3;

        do {
            System.out.print("[1] PosPage / [2] PrePago: ");
            String plano = in.nextLine();

            if (plano.equals("1")){
                return Cliente.ClientePlanoTipo.PosPago;
            }
            if (plano.equals("2")){
                return Cliente.ClientePlanoTipo.PrePago;
            }

            tentativas--;
            if (tentativas == 0) {
                ok = true;
            };

        } while (!ok);
        return null;
    }

    public static long leTelefone() {
        long num = 0;
        boolean ok = false;
        Scanner in = new Scanner(System.in);
        int tentativas = 3;

        do {
            try
            {
                if (tentativas == 0) {
                    System.out.println("Tentativas encerradas. Inicie novamente.\n");
                    break;
                };
                tentativas--;

                System.out.print("Entre com o Telefone (ex.: 988885555): ");
                String numero="";
                if (in.hasNextLine()){
                    numero = in.nextLine();
                }

                ok = validaTelefone(numero);

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

    public static boolean validaTelefone(String numero){
        String regex = "^9[1-9][0-9]{7}$";  // 1° = 9 // 2° = 1-9
        boolean validacao = Pattern.compile(regex).matcher(numero).matches();
        return validacao;
    }

    public static void terminouEscolha(){
        System.out.print("\nprecione alguma tecla...\n");
        Scanner in = new Scanner(System.in);
        in.nextLine();
    }
}
