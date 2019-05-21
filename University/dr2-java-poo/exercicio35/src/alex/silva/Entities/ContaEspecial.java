package alex.silva.Entities;

public class ContaEspecial extends Conta{

    private float LIMITE_EXTRA;

    public ContaEspecial(float saldo, int contaNumero, float limite) {
        super(saldo, contaNumero);
        this.LIMITE_EXTRA = limite;
    }

    public float getLIMITE_EXTRA() {
        return LIMITE_EXTRA;
    }

    public void setLIMITE_EXTRA(float LIMITE_SALDO_NEGATIVO) {
        this.LIMITE_EXTRA = LIMITE_SALDO_NEGATIVO;
    }

    @Override
    public boolean sacar(float quantidade) {

        boolean saqueOk = false;

        if ((this.saldo+LIMITE_EXTRA-quantidade) >= 0){
            saldo -= quantidade;
            saqueOk =true;
        }

        return saqueOk;
    }
}
