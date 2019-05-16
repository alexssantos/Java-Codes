package alex.silva.Entities;

public class Conta {

    protected float saldo;
    protected int contaNumero;


    //CONSTRUTORES  =============
    public Conta() {
    }

    public Conta(float saldo, int contaNumero) {
        this.saldo = saldo;
        this.contaNumero = contaNumero;
    }


    //GET SET  ============

    /*public void setSaldo(float saldo) {
        this.saldo = saldo;
    }
     */

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
    public boolean Depositar(float quantidade){
        boolean depositoOk = false;

        if (quantidade != 0){
            saldo += quantidade;
            depositoOk = true;
        }

        return depositoOk;
    }

    public boolean Sacar(float quantidade){
        boolean depositoOk = false;

        if (quantidade != 0){
            saldo -= quantidade;
            depositoOk = true;
        }

        return depositoOk;
    }

    public float ConsultarSaldo(){
        return saldo;
    }
}
