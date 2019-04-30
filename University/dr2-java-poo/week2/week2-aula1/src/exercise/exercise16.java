package exercise;

import java.util.Scanner;

/**
 * exercise16
 */
public class exercise16 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int x, y, larg, alt;

        System.out.println("Digite o valor da coord X: ");
        x = sc.nextInt();
        System.out.println("Digite o valor da coord Y: ");
        y = sc.nextInt();
        System.out.println("Digite o valor da Largula: ");
        larg = sc.nextInt();
        System.out.println("Digite o valor da Altura: ");
        alt = sc.nextInt();

        sc.close();
        
        Retangulo r1 = new Retangulo(x, y, larg, alt);
        r1.mover(2, 6);
        r1.desenhar();
        r1.printTest();

    }
}
