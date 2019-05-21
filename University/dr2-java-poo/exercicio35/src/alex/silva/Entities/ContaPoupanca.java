package alex.silva.Entities;

public class ContaPoupanca extends Conta{

    public ContaPoupanca(float saldo, int contaNumero) {
        super(saldo, contaNumero);
    }


    public void CalculaRendimento(float percentual){
        this.saldo = this.saldo +(saldo*(percentual/100));
    }
}
