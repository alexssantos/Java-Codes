package lista1.ex1;

import java.util.Scanner;

//RUN THIS FILE: Ctrl + Shift + F10
public class MainEx1 {

    public static void main(String[] args) {
        executeEx();
    }

    public static void executeEx(){
        Scanner sc = new Scanner(System.in);

        System.out.println("Digite o Valor de n1: ");
        String n1 = sc.next();
        System.out.println("N1 = " + n1);

        System.out.println("Digite o Valor de n2: ");
        String n2 = sc.next();
        System.out.println("N2 = "+n2);

        sc.close();
        System.out.println("TROCANDO VALORES");

        String aux = n1;
        n1 =n2;
        n2 =aux;
        System.out.println("N1 = "+n1);
        System.out.println("N2 = "+n2);
    }
}
