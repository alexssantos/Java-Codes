//package infnet.alexssantos.dr4at.model.domain;
//
//import org.springframework.data.annotation.Id;
//
//import javax.persistence.*;
//
//@Entity
//@Table(name = "aluno")
//public class Aluno {
//
//    @Id
//    @GeneratedValue(strategy= GenerationType.IDENTITY)
//    @Column(name = "aluno_id", updatable = false, nullable = false)
//    private Integer id;
//
//    @Column(name = "datanasc")
//    private String dataNasc;
//
//
//    // =======================
//    // RELATIONSHIPS
//    // =======================
//
//    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
//    @JoinColumn(name = "usuario_id", referencedColumnName = "usuario_id", unique = true)
//    private Usuario usuario;
//
//    @ManyToOne(fetch = FetchType.EAGER)
//    @JoinColumn(name = "curso_id", referencedColumnName = "curso_id", unique = true)
//    private Curso curso;
//
//    // =======================
//    // CONSTRUCTOR
//    // =======================
//
//    public Aluno() {
//    }
//
//    public Aluno(String dataNasc, Usuario usuario) {
//        this.dataNasc = dataNasc;
//        this.usuario = usuario;
//    }
//
//
//    // =======================
//    // GET/SET
//    // =======================
//
//    public Integer getId() {
//        return id;
//    }
//
//    public void setId(Integer id) {
//        this.id = id;
//    }
//
//    public String getDataNasc() {
//        return dataNasc;
//    }
//
//    public void setDataNasc(String dataNasc) {
//        this.dataNasc = dataNasc;
//    }
//
//    public Usuario getUsuario() {
//        return usuario;
//    }
//
//    public void setUsuario(Usuario usuario) {
//        this.usuario = usuario;
//    }
//
//    public Curso getCurso() {
//        return curso;
//    }
//
//    public void setCurso(Curso curso) {
//        this.curso = curso;
//    }
//}
