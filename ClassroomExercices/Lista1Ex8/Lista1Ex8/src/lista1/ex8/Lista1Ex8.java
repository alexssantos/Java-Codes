package lista1.ex8;

import java.util.Scanner;

public class Lista1Ex8 {
    public static void main(String[] args) throws Exception {
        double raio, area;
        Scanner entrada = new Scanner(System.in);

        System.out.println("Entre com o raio: ");
        raio = entrada.nextDouble();
        System.out.println("Entre com a base: ");
        area = Math.PI * Math.pow(raio, 2)
               
        
        System.out.println("Area = " + area);
    }
}