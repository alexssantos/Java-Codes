package lista1.ex9;

import java.util.Scanner;

public class MainEx9 {
    public static void main(String[] args) {
        executeEx();
    }

    public static void executeEx() {
        Scanner sc = new Scanner(System.in);

        System.out.println("CALCULO DA AREA DA ESFERA!");
        System.out.print("Digite o valor do raio: ");
        double radius = Double.parseDouble(sc.next());

        sc.close();

        //Area Circle = pi * r^2
        double area = 4 * Math.PI * Math.pow(radius, 2);
        String areaStr = String.format("%.2f", area);

        System.out.println("AREA: " + areaStr +" m²");
    }
}
