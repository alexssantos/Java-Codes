package lista1.ex7;

import java.util.Scanner;

public class MainEx7 {
    public static void main(String[] args) {
        executeEx();
    }

    public static void executeEx() {
        Scanner sc = new Scanner(System.in);

        System.out.println("CALCULO DA AREA DO QUADRADO!");
        System.out.print("Digite o valor da altura: ");
        double height = Double.parseDouble(sc.next());
        System.out.print("Digite o valor da base: ");
        double base = Double.parseDouble(sc.next());

        sc.close();

        //Area = b * h
        double area = height * base;

        System.out.println("AREA: " + area +" m²");
    }
}
