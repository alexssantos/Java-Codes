package lista1.ex5;

import java.util.Scanner;

public class MainEx5 {
    public static void main(String[] args) {
        executeEx();
    }

    public static void executeEx(){
        Scanner sc = new Scanner(System.in);

        System.out.print("Digite o valor do salario: ");
        double salary = Double.parseDouble(sc.next());
        System.out.println("SALARIO: R$ " + salary);
        System.out.print("Digite o percentual (%) do reajuste: ");
        double percent = Double.parseDouble(sc.next());
        System.out.println("REAJUSTE: " + percent + " %");
        sc.close();

        System.out.println("CALCULANDO REAJUSTE...");
        double result = salary + (salary * (percent/100));

        System.out.println("Salario Reajustado: R$" + result);
    }
}
