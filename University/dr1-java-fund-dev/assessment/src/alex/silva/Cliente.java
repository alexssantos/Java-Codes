package alex.silva;

import java.time.Duration;

public class Cliente
{
    public long NumeroCelular;
    public String NomeCliente;
    public ClientePlanoTipo PlanoCliente;
    public int Creditos;

    public Cliente(long numeroCelular, String nomeCliente, ClientePlanoTipo planoCliente, int creditos) {
        NumeroCelular = numeroCelular;
        NomeCliente = nomeCliente;
        PlanoCliente = planoCliente;
        Creditos = creditos;
    }

    public enum ClientePlanoTipo{
        PrePago,
        PosPago
    }

}
