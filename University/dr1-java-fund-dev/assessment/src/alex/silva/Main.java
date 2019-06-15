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

        //MENU
 /*       opcao = menu();
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

*/
    }
/*

    public static void excluir(ArrayList<Aluno> turma) {

        if (turma.isEmpty()) {
            System.out.println("Turma vazia");
            return;
        }
        listar(turma);
        String nome = leNome();
        int pos = pesquisaNome(turma, nome);
        if (pos == -1) {
            System.out.println("Erro: nome não encontrado");
            return;
        }
        turma.remove(pos);
    }

    public static void alterar(ArrayList<Aluno> turma) {

        if (turma.isEmpty()) {
            System.out.println("Turma vazia");
            return;
        }
        String nome = leNome();
        int pos = pesquisaNome(turma, nome);
        if (pos == -1) {
            System.out.println("Erro: nome não encontrado");
            return;
        }
        int n1 = leNumero("Entre com a nota: ");
        int n2 = leNumero("Entre com a nota: ");
        turma.get(pos).setN1(n1);
        turma.get(pos).setN2(n2);
    }

    public static int pesquisaNome(ArrayList<Aluno> turma, String nome) {
        int pos = -1;

        nome = nome.toLowerCase();
        for (int i = 0; i < turma.size(); i++) {
            if (turma.get(i).getNome().toLowerCase().equals(nome)) {
                pos = i;
                break;
            }
        }
        return pos;
    }

    public static void incluir(ArrayList<Aluno> turma) {
        String nome;
        int n1, n2;

        nome = leNome();
        n1 = leNumero("Entre com a nota: ");
        n2 = leNumero("Entre com a nota: ");
        turma.add(new Aluno(nome, n1, n2));
    }

    public static void listar(ArrayList<Aluno> turma) {

        if (turma.isEmpty()) {
            System.out.println("Turma vazia");
            return;
        }
        System.out.println("---------------");
        for (Aluno aluno: turma) {
            System.out.println(aluno);
        }
        System.out.println("---------------");
    }
*/

    public static String leNome() {
        String nome;
        Scanner entrada = new Scanner(System.in);

        System.out.print("Entre com o nome: ");
        nome = entrada.nextLine();
        return nome;
    }

    public static int menu() {
        int opcao;
        Scanner entrada = new Scanner(System.in);

        do {
            System.out.println("[1] - Incluir");
            System.out.println("[2] - Alterar");
            System.out.println("[3] - Excluir");
            System.out.println("[4] - Listar");
            System.out.println("[0] - Sair");
            opcao = leNumero("Entre com uma opção: ");
            if ((opcao < 0) || (opcao > 4)) {
                System.out.println("Erro: opcao inválida");
            }
        } while ((opcao < 0) || (opcao > 4));
        return opcao;
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
