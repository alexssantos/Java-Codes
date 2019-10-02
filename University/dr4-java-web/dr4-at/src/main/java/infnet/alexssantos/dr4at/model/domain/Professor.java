package infnet.alexssantos.dr4at.model.domain;

import infnet.alexssantos.dr4at.model.enums.TitulacaoEnum;
import org.hibernate.annotations.ValueGenerationType;

import javax.persistence.*;

@Entity
@Table(name = "professor")
public class Professor {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "professor_id", updatable = false, nullable = false)
    private Integer id;

    //MESTRE, DOUTOR ou LIVRE-DOCENTE
    @Enumerated(EnumType.STRING)
    @Column(name="titulacao")
    private TitulacaoEnum titulacao;


    // =======================
    // RELATIONSHIPS
    // =======================

    @OneToOne(cascade = CascadeType.DETACH, fetch = FetchType.EAGER)
    @JoinColumn(name = "usuario_id", referencedColumnName = "usuario_id", unique = true)
    private Usuario usuario;


    // =======================
    // CONSTRUCTOR
    // =======================

    public Professor() {
    }

    public Professor(TitulacaoEnum titulacao, Usuario usuario) {
        this.titulacao = titulacao;
        this.usuario = usuario;
    }


    // =======================
    // GET/SET
    // =======================


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public TitulacaoEnum getTitulacao() {
        return titulacao;
    }

    public void setTitulacao(TitulacaoEnum titulacao) {
        this.titulacao = titulacao;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
