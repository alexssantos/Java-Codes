package alex.silva;

public class Ligacao {

    //private long protocolo
    //private Cliente ligador;
    //private Cliente recebedor;
    //Date inicio;
    //Date fim;
    //int duracaoMin;   //diferença em minutos entre o inicio e fim

    private long numero;
    private String inicio;
    private String fim;


    public Ligacao(long numero, String inicio, String fim) {
        this.numero = numero;
        this.inicio = inicio;
        this.fim = fim;
    }

    //GET SETs
    public long getNumero() {
        return numero;
    }

    public void setNumero(long numero) {
        this.numero = numero;
    }

    public String getInicio() {
        return inicio;
    }

    public void setInicio(String inicio) {
        this.inicio = inicio;
    }

    public String getFim() {
        return fim;
    }

    public void setFim(String fim) {
        this.fim = fim;
    }

}
