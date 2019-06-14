package alex.silva;

public class Cliente
{
    public int NumeroCelular;
    public String NomeCliente;
    public ClientePlanoTipo PlanoCliente;
    public double NumeroCreditos;

    public enum ClientePlanoTipo{
        PrePago,
        PosPago
    }

}
