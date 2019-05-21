package alex.silva.Entities;

import java.util.List;

public class Banco {
    private int codigo;
    private String nome;
    private Conta contas[];
    private int qtdMaxContas = 0;
    private int qtdContas = 0;

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Banco(int codigo, String nome, int qtdMaxContas) {
        this.codigo = codigo;
        this.nome = nome;
        this.contas = new Conta[qtdMaxContas];
        this.qtdMaxContas = qtdMaxContas;
    }

    public void addConta(Conta newConta){
        if (qtdContas >= qtdMaxContas){return;}

        if (newConta instanceof ContaPoupanca){
            this.contas[qtdContas] = newConta;
        }
        if (newConta instanceof ContaComum){

        }
        if (newConta instanceof ContaEspecial){

        }
        qtdContas++;
    }

    public void setManyContas(List<Conta> contas){
        for (Conta conta: contas) {
            if (conta != null){
                addConta(conta);
            }
        }
    }

    public void deleteConta(int numeroConta){
        for (int i=0; i < qtdMaxContas; i++){
            if (this.contas[i].getContaNumero() == numeroConta){
                contas[i] = contas[qtdContas--];
                qtdContas--;
                contas[qtdContas--] = null;      //remove duplicate scraps
            }
        }
    }

    public void sacar(){

    }

    public void depositar(){

    }

    public void listar(){

    }

    public void imprimirTotal(){
        //Imprime soma de todas as contas
    }

}
