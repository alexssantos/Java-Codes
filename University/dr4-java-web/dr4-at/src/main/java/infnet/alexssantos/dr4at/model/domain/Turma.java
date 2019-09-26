package infnet.alexssantos.dr4at.model.domain;


import javax.persistence.*;

@Entity
@Table(name = "turma")
public class Turma {

    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "turma_id", updatable = false, nullable = false)
    private Integer id;

    @Column(name = "codigo")
    private String codigo;

    @Column(name = "sala")
    private String sala;


    // =======================
    // RELATIONSHIPS
    // =======================

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "professor_id", referencedColumnName = "professor_id", unique = true)
    private Professor professor;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "disciplina_id", referencedColumnName = "disciplina_id", unique = true)
    private Disciplina disciplina;


    // =======================
    // CONSTRUCTOR
    // =======================

    public Turma() {
    }

    public Turma(String codigo, String sala, Professor professor, Disciplina disciplina) {
        this.codigo = codigo;
        this.sala = sala;
        this.professor = professor;
        this.disciplina = disciplina;
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

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getSala() {
        return sala;
    }

    public void setSala(String sala) {
        this.sala = sala;
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    public Disciplina getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(Disciplina disciplina) {
        this.disciplina = disciplina;
    }
}
