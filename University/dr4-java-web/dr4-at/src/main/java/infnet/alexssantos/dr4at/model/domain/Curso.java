package infnet.alexssantos.dr4at.model.domain;


import javax.persistence.*;

@Entity
@Table(name = "curso")
public class Curso {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "curso_id", updatable = false, nullable = false)
    private Integer id;

    @Column(name = "nome")
    private String nome;


    // =======================
    // CONSTRUCTOR
    // =======================

    public Curso() {
    }

    public Curso(String nome) {
        this.nome = nome;
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

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
