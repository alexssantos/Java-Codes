package lista1.ex7;

import java.util.Scanner;

public class Lista1Ex7 {
    public static void main(String[] args) throws Exception {
        double altura, base, area;
        Scanner entrada = new Scanner(System.in);

        System.out.println("Entre com a altura: ");
        altura = entrada.nextDouble();
        System.out.println("Entre com a base: ");
        base = entrada.nextDouble();
               
        area = altura * base;
        System.out.println("Area = " + area);
    }
}