package alex.silva;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.TemporalAdjusters;
import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;

public class Main {

    public static  List<Cliente> clientesLista;
    public static  List<Ligacao> ligacoesLista;

    public static void main(String[] args)
    {
        //Pegar o arquivo de Clientes
        final int FIM = 0;
        final String CLIENTES = "clientes_db.txt";
        final String LIGACOES = "ligacoes_db.txt";
        clientesLista = new ArrayList<>();
        ligacoesLista = new ArrayList<>();


        // LÊ O ARQUIVO
        Arquivo arquivoCliente = new Arquivo(CLIENTES);
        Scanner entrada = arquivoCliente.abreArquivo();
        if (entrada != null) {
            arquivoCliente.pegaCliente(entrada, clientesLista);
            System.out.println("> CLIENTES ARQUIVO"+"\nQuantidade: "+clientesLista.size()+"\n"+clientesLista);
            arquivoCliente.fechaLeitor(entrada);
        }

        Arquivo arquivoLigacoes = new Arquivo(LIGACOES);
        entrada = arquivoLigacoes.abreArquivo();
        if (entrada != null) {
            arquivoLigacoes.pegaLigacoes(entrada, ligacoesLista);
            System.out.println("> LIGAÇOES ARQUIVO"+"\nQuantidade: "+ligacoesLista.size()+"\n"+ligacoesLista);
            arquivoLigacoes.fechaLeitor(entrada);
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
                    subMenu(clientesLista);
                    break;
                case 5:
                    fazerLigacao();
                    break;
                case 6:
                    gerarBoleto();   //RELATORIO
                    break;
            }
            opcao = menu();
        }

        Formatter gravaCliente = arquivoCliente.abreArquivoGravar();
        if (gravaCliente != null) {
            arquivoCliente.gravaClientes(gravaCliente, clientesLista);
            arquivoCliente.fechaGravador(gravaCliente);
        }

        Formatter gravaLigacao = arquivoLigacoes.abreArquivoGravar();
        if (gravaLigacao != null) {
            arquivoLigacoes.gravaLigacoes(gravaLigacao, ligacoesLista);
            arquivoLigacoes.fechaGravador(gravaLigacao);
        }
    }

    public static int menu() {
        int opcao;
        Scanner entrada = new Scanner(System.in);

        do {
            System.out.println("\n--------------------------------");
            System.out.println("[1] - Incluir Cliente");
            System.out.println("[2] - Alterar Cliente");
            System.out.println("[3] - Excluir Cliente");
            System.out.println("[4] - Relatórios gerenciais");
            System.out.println("[5] - Fazer Ligação");
            System.out.println("[6] - Gerar boleto do cliente");
            System.out.println("[0] - Sair");
            System.out.println("--------------------------------\n");
            opcao = leNumero("Entre com uma opção: ");
            if ((opcao < 0) || (opcao > 6)) {
                System.out.println("Erro: opcao inválida");
            }
        } while ((opcao < 0) || (opcao > 6));
        return opcao;
    }

    //  -------- SUBMENU

    public static void subMenu(List<Cliente> clientesLista){
        final int RETORNO = 0;
        int opcao = subMenuRelatorio();
        while (opcao != RETORNO) {
            switch (opcao) {
                case 1:
                    listar(clientesLista);
                    break;
                case 2:
                    clientesSaldoPositivos(clientesLista);
                    break;
                case 3:
                    clientesAcimaDe(clientesLista);
                    break;
                case 4:
                    clienteMaiorCredito(clientesLista);
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
            System.out.println("[2] - Listar sem saldo negativo");
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

    //  -------- METODOS MENU

    public static void incluir(List<Cliente> clientesLista)
    {
        String nome = leNome();
        long telefone = leTelefone(true);
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
        long numero = leTelefone(false);
        if (numero == 0) return;

        boolean removido = clientes.removeIf(x -> x.getNumeroCelular() == numero);

        if (!removido) {
            System.out.println("ERRO: Nenhum cliente encontrado");
            return;
        }else{
            System.out.println("SUCESSO: cliente removido");
        }
    }

    public static void alterar(List<Cliente> clientes)
    {
        if (clientes.isEmpty()) {
            System.out.println("Não há clientes cadastrados");
            return;
        }

        long telefone = leTelefone(false);
        if (telefone == 0) return;

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

    public static void fazerLigacao(){
        long tell = leTelefone(false);
        if (tell == 0) return;

        Cliente ligador = pegaCliete(tell);
        if (ligador == null){
            System.out.println("Cliente não existe.");
            return;
        }

        long tell2 = leTelefone(false);
        if (tell2 == 0) return;

        Cliente recebedor = pegaCliete(tell);
        if (recebedor == null){
            System.out.println("Cliente não existe.");
            return;
        }

        Date inicio = pegaDataHora("INICIO: \nDia (dd/MM/yy): ");
        Date fim = pegaDataHora("FIM: \nDia (dd/MM/yy): ");
        if (fim == null || inicio == null){
            System.out.println("ERRO: Data Formato invalido");
            return;
        }

        long duracao = fim.getTime() - inicio.getTime();
        if (duracao < 0){
            System.out.println("ERRO: data INICIO maior que data FIM");
            return;
        }

        Ligacao ligacao = new Ligacao(ligador.getNumeroCelular(), recebedor.getNumeroCelular(),inicio,fim);
        ligacoesLista.add(ligacao);
        long creditos = ligador.getCreditos() - ligacao.getDuracaoMin();
        ligador.setCreditos(creditos);

        System.out.println("Ligação: "+ligacao.toString());
        System.out.println("Ligador: "+ligador.toString());
    }

    public static void gerarBoleto(){
        System.out.println("GERAR BOLETO PARA CLIETE:\n");

        long numero = leTelefone(false);
        if (numero == 0){
            return;
        }

        Cliente cliente = pegaCliete(numero);
        Cliente.ClientePlanoTipo plano = cliente.getPlanoCliente();
        List<Ligacao> ligacoes = new ArrayList<>();
        int somaDuracao=0;

        for (Ligacao item: ligacoesLista) {
            if (item.getLigador() == numero){
                ligacoes.add(item);
                somaDuracao += item.getDuracaoMin();
            }
        }

        if (plano.equals(Cliente.ClientePlanoTipo.PrePago)){
            if (ligacoes.size() == 0){
                System.out.println("Nenhuma ligação Feita");
                System.out.println("Plano: "+plano);
                System.out.println("Creditos: C$ "+ cliente.getCreditos());
                return;
            }
            else {
                System.out.println("-------------------------------------");
                for (Ligacao item: ligacoes) {
                    System.out.println(item);
                }
                System.out.println("Total de Ligações: "+ligacoes.size());
                System.out.println("Total debitado: C$ "+(-somaDuracao));
                System.out.println("Creditos : C$ "+(cliente.getCreditos()-somaDuracao));
                System.out.println("-------------------------------------");
            }
        }
        if (plano.equals(Cliente.ClientePlanoTipo.PosPago)){
            if (ligacoes.size() == 0){
                LocalDate now = LocalDate.now(); //2015-11-23
                LocalDate lastDay = now.with(TemporalAdjusters.lastDayOfMonth());

                System.out.println("Nenhuma ligação Feita");
                System.out.println("Plano: "+plano);
                System.out.println("Plano Expira em : "+lastDay.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM)));
                return;
            }
            else {
                System.out.println("-------------------------------------");
                for (Ligacao item: ligacoes) {
                    System.out.println(item);
                }
                System.out.println("Total de Ligações: "+ligacoes.size());
                System.out.println("Total duração (min): "+somaDuracao);
                System.out.println("Creditos: C$ "+(cliente.getCreditos()-somaDuracao));
                System.out.println("-------------------------------------");
            }
        }
    }

    //  -------- METODOS DUBMENU

    public static void clientesSaldoPositivos(List<Cliente> clientesLista){
        List<Cliente> saldoPositivo = new ArrayList<>();

        for (Cliente cliente: clientesLista) {
            if (cliente.getCreditos() >= 0){
                saldoPositivo.add(cliente);
            }
        }
        listar(saldoPositivo);
    }

    public static void clientesAcimaDe(List<Cliente> clientesLista){
        List<Cliente> saldoPositivo = new ArrayList<>();
        long numero = leNumero("Clientes com créditos acima de:");

        for (Cliente cliente: clientesLista) {
            if (cliente.getCreditos() >= numero){
                saldoPositivo.add(cliente);
            }
        }
        listar(saldoPositivo);
    }

    public static void clienteMaiorCredito(List<Cliente> clientesLista){
        long maior=0;
        int pos=-1;

        for (int i=0; i<clientesLista.size();i++){
            long cretido = clientesLista.get(i).getCreditos();
            if ( cretido > maior){
                maior = cretido;
                pos = i;
            }
        }

        if (pos == -1){
            System.out.println("Não encontrado cliente com maior crédito.");
            return;
        }
        System.out.println(clientesLista.get(pos)+"\n");
    }

    //  -------- MOTODOS

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

    public static long leTelefone(boolean validacao) {
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
                }
                if (validacao){
                    boolean repetido = testaTelefoneRepetido(num);
                    if (!repetido)
                        ok = true;
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

    public static Date pegaDataHora(String msg){
        Date data = new Date(Date.UTC(0,0,0,0,0,0));
        boolean ok = false;
        Scanner entrada = new Scanner(System.in);
        int tentativas = 3;

        do {
            try
            {
                if (tentativas == 0) {
                    System.out.println("Tentativas encerradas. Inicie novamente.\n");
                    break;
                };

                System.out.print(msg);
                String diaStr = entrada.nextLine();
                System.out.print("horario (HH:mm): ");
                String horaStr = entrada.nextLine();
                data = criarDataHora(diaStr, horaStr);
                if (data != null) ok = true;
                else {
                    System.out.println("ERRO: Formato Data Hora não bate com o padrão. \n");
                }
            }
            catch (ParseException e){
                System.out.println("Erro: Data no padrão errado");
                entrada.nextLine();
                ok = false;
            }
            tentativas--;
        } while (!ok);
        return data;
    }

    public static Date criarDataHora(String Dia, String hora) throws ParseException {

        String regexDia = "^([0-2][0-9]|(3)[0-1])(\\/)(((0)[0-9])|((1)[0-2]))(\\/)\\d{2}$";  // dd/MM/yy
        boolean diaOk = Pattern.compile(regexDia).matcher(Dia).matches();

        String regexHora = "^(0[0-9]|1[0-9]|2[0-3]|[0-9]):[0-5][0-9]$";
        boolean horaOk = Pattern.compile(regexHora).matcher(hora).matches();        //HH:mm

        if (diaOk && horaOk){
            SimpleDateFormat SDF = new SimpleDateFormat("dd/MM/yy HH:mm");
            Date dateOut = SDF.parse(Dia+" "+hora);
            return dateOut;
        }
        return null;
    }

    public static boolean validaTelefone(String numero){
        String regex = "^[2-9][0-9]{7}$";  // 1° = 2-9
        boolean validacao = Pattern.compile(regex).matcher(numero).matches();
        return validacao;
    }

    public static boolean testaTelefoneRepetido(long numero){
        for (Cliente cliente: clientesLista) {
            if (cliente.getNumeroCelular() == numero){
                return true;
            }
        }
        return false;
    }

    public static Cliente pegaCliete(long numero){
        for (Cliente cliente: clientesLista) {
            if (cliente.getNumeroCelular() == numero){
                return cliente;
            }
        }
        return null;
    }

    public static void terminouEscolha(){
        System.out.print("\nprecione alguma tecla...\n");
        Scanner in = new Scanner(System.in);
        in.nextLine();
    }
}
