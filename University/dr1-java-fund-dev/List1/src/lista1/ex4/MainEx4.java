package lista1.ex4;

import java.util.Scanner;

public class MainEx4 {
    public static void main(String[] args) {
        executeEx();
    }

    public static void executeEx(){
        Scanner sc = new Scanner(System.in);

        System.out.print("Digite o valor da conta: ");
        double bill = Double.parseDouble(sc.next());
        System.out.println("CONTA: R$ " + bill);
        sc.close();

        System.out.println("CALCULANDO GORJETA...");

        double tipPercent = 0.1;
        double tip = bill * tipPercent;
        System.out.println("GORJETA: " + tip);
    }
}
