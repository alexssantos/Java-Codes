package alex.silva;

import java.time.Duration;

public class Cliente
{
    public long NumeroCelular;
    public String NomeCliente;
    public ClientePlanoTipo PlanoCliente;
    public int Creditos;

    public long getNumeroCelular() {
        return NumeroCelular;
    }

    public void setNumeroCelular(long numeroCelular) {
        NumeroCelular = numeroCelular;
    }

    public String getNomeCliente() {
        return NomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        NomeCliente = nomeCliente;
    }

    public ClientePlanoTipo getPlanoCliente() {
        return PlanoCliente;
    }

    public void setPlanoCliente(ClientePlanoTipo planoCliente) {
        PlanoCliente = planoCliente;
    }

    //TODO: trabalhar com itpo data e retornar string pra salvar no arquivo.
    public int getCreditos() {
        return Creditos;
    }

    public void setCreditos(int creditos) {
        Creditos = creditos;
    }

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
