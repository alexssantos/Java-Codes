package alex.silva.Entities;

public class Conta {

    protected float saldo;
    protected int contaNumero;


    //CONSTRUTORES  =============
    public Conta(float saldo, int contaNumero) {
        this.saldo = saldo;
        this.contaNumero = contaNumero;
    }


    //GET SET  ============
    public int getContaNumero() {
        return contaNumero;
    }

    public void setContaNumero(int contaNumero) {
        this.contaNumero = contaNumero;
    }

    public float getSaldo() {
        return saldo;
    }


    //METODOS
    public boolean depositar(float quantidade){
        boolean depositoOk = false;

        if (quantidade != 0){
            saldo += quantidade;
            depositoOk = true;
        }

        return depositoOk;
    }

    public boolean sacar(float quantidade){
        boolean depositoOk = false;

        if (quantidade != 0){
            saldo -= quantidade;
            depositoOk = true;
        }

        return depositoOk;
    }

    public void consultarSaldo(){
        System.out.println("Saldo = " + saldo);
        //return saldo;
    }
}
