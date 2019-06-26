package alex.silva;

import java.util.ArrayList;
import java.util.Formatter;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Main {

    public static  List<Cliente> clientesLista;

    public static void main(String[] args)
    {
        //Pegar o arquivo de Clientes
        final int FIM = 0;
        final String CLIENTES = "clientes_db.txt";
        final String LIGACOES = "ligacoes_db.txt";
        clientesLista = new ArrayList<>();
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
                case 1:
                    incluir(clientesLista);
                    break;
                case 2:
                    alterar(clientesLista);
                    break;
                case 3:
                    excluir(clientesLista);
                    break;
                case 4:
                    subMenu(clientesLista);   //RELATORIO
                    break;
                case 5:
                    //fazerLigacao();
                    break;
                case 6:
                    //gerarBoletoCliente(clientesLista);   //RELATORIO
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
            System.out.println("[5] - Fazer Ligação");
            System.out.println("[6] - Gerar boleto do cliente");
            System.out.println("[0] - Sair");
            opcao = leNumero("Entre com uma opção: ");
            if ((opcao < 0) || (opcao > 6)) {
                System.out.println("Erro: opcao inválida");
            }
        } while ((opcao < 0) || (opcao > 6));
        return opcao;
    }

    //SUBMENU   -------------------------------------------------

    public static void subMenu(List<Cliente> clientesLista){
        final int RETORNO = 0;
        int opcao = subMenuRelatorio();
        while (opcao != RETORNO) {
            switch (opcao) {
                case 1:
                    //listarTodos(clientesLista);
                    System.out.println("//listarTodos(clientesLista);\n");
                    break;
                case 2:
                    //clientesSaldoPositivos(clientesLista);
                    System.out.println("//clientesSaldoPositivos(clientesLista);\n");
                    break;
                case 3:
                    System.out.println("//clientesAcimaDe(clientesLista);\n");
                    //clientesAcimaDe(clientesLista);
                    break;
                case 4:
                    System.out.println("//clienteMarioCredito(clientesLista);\n");
                    //clienteMarioCredito(clientesLista);
                    break;
            }
            opcao = subMenuRelatorio();
        }
    }

    public static int subMenuRelatorio(){
        int opcao;
        Scanner entrada = new Scanner(System.in);

        do {
            System.out.println("[1] - Listar Todos clientes");
            System.out.println("[2] - Listar semsaldo negativo");
            System.out.println("[3] - Listar clientes acima de um valor");
            System.out.println("[4] - Cliente com maior número de crédito");
            System.out.println("[0] - Voltar");
            opcao = leNumero("Entre com uma opção: ");
            if ((opcao < 0) || (opcao > 4)) {
                System.out.println("Erro: opcao inválida");
            }
        } while ((opcao < 0) || (opcao > 4));
        return opcao;
    }
    //end SUBMENU

    // METODOS  -----------------------------------------------------

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


    //METODOS Submenu



    //MOTODOS Auxiliares.
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

                System.out.print("Entre com o Telefone de 8 numeros (ex.: 88885555): ");
                String numero="";
                if (in.hasNextLine()){
                    numero = in.nextLine();
                }

                ok = validaTelefone(numero);

                if (ok){
                    num = Integer.parseInt(numero);
                    boolean repetido = testaNumeroRepetido(num);
                    if (!repetido) ok = true;
                    else{
                        ok = false;
                        System.out.println("Número já Existe");
                    }
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
        String regex = "^[2-9][0-9]{7}$";  // 1° = 2-9
        boolean validacao = Pattern.compile(regex).matcher(numero).matches();
        return validacao;
    }

    public static boolean testaNumeroRepetido(long numero){
        for (Cliente cliente: clientesLista) {
            if (cliente.getNumeroCelular() == numero){
                return true;
            }
        }
        return false;
    }

    public static void terminouEscolha(){
        System.out.print("\nprecione alguma tecla...\n");
        Scanner in = new Scanner(System.in);
        in.nextLine();
    }
}
