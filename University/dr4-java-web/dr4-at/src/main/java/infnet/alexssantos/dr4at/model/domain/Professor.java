package infnet.alexssantos.dr4at.model.domain;

import org.hibernate.annotations.ValueGenerationType;

import javax.persistence.*;

@Entity
@Table(name = "professor")
public class Professor {

    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "professor_id", updatable = false, nullable = false)
    private Integer id;

    @Column(name="titulacao")
    private String titulacao;


    // =======================
    // RELATIONSHIPS
    // =======================

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "usuario_id", referencedColumnName = "usuario_id", unique = true)
    private Usuario usuario;


    // =======================
    // CONSTRUCTOR
    // =======================

    public Professor() {
    }

    public Professor(String titulacao, Usuario usuario) {
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

    public String getTitulacao() {
        return titulacao;
    }

    public void setTitulacao(String titulacao) {
        this.titulacao = titulacao;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
