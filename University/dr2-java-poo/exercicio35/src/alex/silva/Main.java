package alex.silva;

import alex.silva.Entities.*;

import java.util.List;

public class Main {

    public static void main(String[] args) {
	// write your code here

        Conta c1 = new ContaComum(1520,001);
        Conta c2 = new ContaEspecial(1500,002,500);
        Conta c3 = new ContaPoupanca(2000,003);



        // <Intanciado> instanceof <Tipo>
        Banco banco = new Banco();
        banco.setManyContas();
        if (c3 instanceof ContaPoupanca){

        }
    }
}
