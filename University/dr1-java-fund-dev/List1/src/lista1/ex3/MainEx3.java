package lista1.ex3;

import java.util.Scanner;

public class MainEx3 {
    public static void main(String[] args) {
        executeEx();
    }

    public static void executeEx(){
        Scanner sc = new Scanner(System.in);

        System.out.print("Digite o valor da NOTA 1: ");
        int n1 = Integer.parseInt(sc.next());
        System.out.println("N1 = " + n1);

        System.out.print("Digite o valor da NOTA 2: ");
        int n2 = Integer.parseInt(sc.next());
        System.out.println("N2 = "+n2);
        sc.close();

        System.out.println("CALCULANDO MEDIA...");

        double media = (n1 + n2*2)/2;
        System.out.println("MEDIA: " + media);
    }
}
