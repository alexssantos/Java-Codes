package lista1.ex8;

import java.util.Scanner;

public class MainEx8 {
    public static void main(String[] args) {
        executeEx();
    }

    public static void executeEx() {
        Scanner sc = new Scanner(System.in);

        System.out.println("CALCULO DA AREA DO CIRCULO!");
        System.out.print("Digite o valor do raio: ");
        double radius = Double.parseDouble(sc.next());

        sc.close();

        //Area Circle = pi * r^2
        double area = Math.PI * Math.pow(radius, 2);
        String areaStr = String.format("%.2f", area);

        System.out.println("AREA: " + areaStr +" m²");
    }
}
