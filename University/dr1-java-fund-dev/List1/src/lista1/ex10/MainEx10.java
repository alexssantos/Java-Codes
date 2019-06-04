package lista1.ex10;

import java.util.Scanner;

public class MainEx10 {
    public static void main(String[] args) {
        executeEx();
    }

    public static void executeEx() {
        Scanner sc = new Scanner(System.in);

        System.out.println("CALCULO DO VOLUME DE UM CILINDRO!");
        System.out.print("Digite o valor do raio: ");
        double radius = Double.parseDouble(sc.next());
        System.out.print("Digite o valor da altura: ");
        double height = Double.parseDouble(sc.next());

        sc.close();


        // base_area = circle area = PI * radius^2
        double base_area = Math.PI * Math.pow(radius, 2);
        // Volume Cilindro = base_area * Height,
        double volume = base_area * height;
        String volumeStr = String.format("%.2f", volume);

        System.out.println("VOLUME: " + volumeStr +" m²");
    }
}
