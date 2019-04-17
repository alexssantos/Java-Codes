package lista1.ex10;

import java.util.Scanner;

public class Lista1Ex10 {
    public static void main(String[] args) throws Exception {
        double raio, altura, volume;
        Scanner entrada = new Scanner(System.in);

        System.out.print("Entre com o raio: ");
        raio = entrada.nextDouble();
        System.out.print("Entre com a altura: ");
        altura  = entrada.nextDouble();
        
        volume = Math.PI * Math.pow(raio, 2) * altura;               
        
        System.out.println("Volume = " + volume);
    }
}