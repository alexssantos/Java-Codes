package infnet.alexssantos.dr4at.model.domain;


import javax.persistence.*;

@Entity
@Table(name = "perfil")
public class Perfil {

    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "perfil_id", updatable = false, nullable = false)
    private Integer id;

    @Column(name = "nome")
    private String nome;


    // =======================
    // CONSTRUCTOR
    // =======================


    public Perfil() {
    }

    public Perfil(String nome) {
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
