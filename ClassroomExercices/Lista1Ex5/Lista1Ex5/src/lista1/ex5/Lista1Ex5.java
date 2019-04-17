package lista1.ex5;

import java.util.Scanner;

public class Lista1Ex5 {
    public static void main(String[] args) throws Exception {
        double salario, reajuste, novoSalario;
        Scanner entrada = new Scanner(System.in);

        System.out.print("Entre com o salario: ");
        salario = entrada.nextDouble();
        System.out.print("Reajuste: ");
        reajuste = entrada.nextDouble();
        novoSalario = salario + (salario * reajuste /100);
        System.out.println("Novo Salario = " + novoSalario);
    }
}