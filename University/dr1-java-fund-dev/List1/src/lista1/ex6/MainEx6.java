package lista1.ex6;

import java.util.Scanner;

public class MainEx6 {
    public static void main(String[] args) {
        executeEx();
    }

    public static void executeEx() {
        Scanner sc = new Scanner(System.in);

        System.out.println("CALCULO DA AREA DO QUADRADO!");
        System.out.print("Digite o valor do lado: ");
        double side = Double.parseDouble(sc.next());

        sc.close();

        //Area = L^2
        double area = Math.pow(side, 2);

        System.out.println("AREA: " + area +" m²");
    }
}
