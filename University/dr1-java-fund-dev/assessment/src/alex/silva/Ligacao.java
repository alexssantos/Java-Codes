package alex.silva;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Ligacao {

    private long ligador;
    private long recebedor;
    private Date inicio;
    private Date fim;
    private long duracaoMin;   //diferença em minutos entre o inicio e fim

    public SimpleDateFormat SDF = new SimpleDateFormat("dd/MM/yy HH:mm");

    public Ligacao(long ligador, long recebedor, Date inicio, Date fim) {
        this.ligador = ligador;
        this.recebedor = recebedor;
        this.inicio = inicio;
        this.fim = fim;
        setDuracaoMin(this.inicio, this.fim);
    }

    // GET SET
    public long getLigador() {
        return ligador;
    }

    public void setLigador(long ligador) {
        this.ligador = ligador;
    }

    public long getRecebedor() {
        return recebedor;
    }

    public void setRecebedor(long recebedor) {
        this.recebedor = recebedor;
    }

    public Date getInicio() {
        return inicio;
    }

    public void setInicio(Date inicio) {
        this.inicio = inicio;
    }

    public Date getFim() {
        return fim;
    }

    public void setFim(Date fim) {
        this.fim = fim;
    }

    public long getDuracaoMin() {
        return duracaoMin;
    }

    public void setDuracaoMin(Date inicio, Date fim) {
        long diff = fim.getTime() - inicio.getTime();
        long diffMinutos = TimeUnit.MILLISECONDS.toMinutes(diff);
        this.duracaoMin = duracaoMin;
    }

    public static Ligacao pegarPorNumero(List<Ligacao> ligacoes, long ligador){
        for (Ligacao call: ligacoes) {
            if (call.getLigador() == ligador){
                return call;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return "Ligador: "+getLigador()
                +" | "+
                "Recebedor: "+getRecebedor()
                +" | "+
                "Inicio: "+SDF.format(getInicio())
                +" | "+
                "Fim: "+SDF.format(getFim())
                +" | "+
                "Duração (min): "+getDuracaoMin()
                +"\n";

    }

    public String salvarLigacao(){
        return getLigador()
                +" | "+
                getRecebedor()
                +" | "+
                SDF.format(getInicio())
                +" | "+
                SDF.format(getFim())
                +" | "+
                getDuracaoMin();
    }
}
