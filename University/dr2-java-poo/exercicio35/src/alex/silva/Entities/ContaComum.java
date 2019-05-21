package alex.silva.Entities;

public class ContaComum extends Conta{


    public ContaComum(float saldo, Integer contaNumero) {
        super(saldo, contaNumero);
    }

    @Override
    public boolean sacar(float quantidade) {
        boolean saqueOk = false;

        if ((saldo - quantidade) >= 0){
            saldo -= quantidade;
            saqueOk = true;
        }
        return saqueOk;
    }


}
