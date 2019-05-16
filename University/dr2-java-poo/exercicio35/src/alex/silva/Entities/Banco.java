package alex.silva.Entities;

import java.util.ArrayList;
import java.util.List;

public class Banco {
    private static List<Conta> contas;

    public Banco() {
        if (contas == null){
            contas = new ArrayList<>();
        }
    }

    public void setConta(Conta newConta){
        if (newConta != null){
            contas.add(newConta);
        }
    }

    public void setManyContas(List<Conta> contas){
        for (Conta conta: contas) {
            this.contas.add(conta);
        }
    }

}
