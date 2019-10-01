package infnet.alexssantos.dr4at.model.domain;

import javax.persistence.*;

@Entity
@Table(name = "usuario")
public class Usuario {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "usuario_id", updatable = false, nullable = false)
    private Integer id;

    @Column(name = "matricula")
    private Integer matricula;

    @Column(name = "senha")
    private String senha;

    @Column(name = "nome")
    private String nome;

    @Column(name = "email")
    private String email;


    // =======================
    // RELATIONSHIPS
    // =======================

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "perfil_id", referencedColumnName = "perfil_id")
    private Perfil perfil;


    // =======================
    // CONSTRUCTOR
    // =======================


    public Usuario() {
    }

    public Usuario(Integer matricula, String senha, String nome, String email, Perfil perfil) {
        this.matricula = matricula;
        this.senha = senha;
        this.nome = nome;
        this.email = email;
        this.perfil = perfil;
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

    public Integer getMatricula() {
        return matricula;
    }

    public void setMatricula(Integer matricula) {
        this.matricula = matricula;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Perfil getPerfil() {
        return perfil;
    }

    public void setPerfil(Perfil perfil) {
        this.perfil = perfil;
    }
}
