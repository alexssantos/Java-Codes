package infnet.alexssantos.dr4at.model.domain;


import infnet.alexssantos.dr4at.model.enums.TipoPerfilEnum;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "perfil")
public class Perfil {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "perfil_id", updatable = false, nullable = false)
    private Integer id;


    @Enumerated(EnumType.STRING)
    @Column(name = "nome", unique = true)
    private TipoPerfilEnum nome;


    public static List<Perfil> allPerfils = new ArrayList<>();
    // =======================
    // CONSTRUCTOR
    // =======================


    public Perfil() {
    }

    public Perfil(TipoPerfilEnum nome) {
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

    public TipoPerfilEnum getNome() {
        return nome;
    }

    public void setNome(TipoPerfilEnum nome) {
        this.nome = nome;
    }
}
