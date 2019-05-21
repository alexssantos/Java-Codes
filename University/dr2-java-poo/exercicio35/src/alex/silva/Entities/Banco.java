package alex.silva.Entities;

import java.util.ArrayList;
import java.util.List;

public class Banco {
    private int codigo;
    private String nome;
    private Conta contas[];

    public Banco(int codigo, String nome, int qtdMaxContas) {
        this.codigo = codigo;
        this.nome = nome;
        this.contas = new Conta[qtdMaxContas];
    }

    

}
