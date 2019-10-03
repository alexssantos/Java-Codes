package infnet.alexssantos.dr4at.model.domain;

import javax.persistence.*;

@Entity
@Table(
    name = "nota",
    uniqueConstraints=@UniqueConstraint(columnNames={"turma_id", "aluno_id"}) //Aluno não pode estar 2x na mesma turma
)
public class Nota {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "nota_id", updatable = false, nullable = false)
    private Integer id;

    @Column(name = "av1")
    private float av1;

    @Column(name = "av2")
    private float av2;


    // =======================
    // RELATIONSHIPS
    // =======================

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "aluno_id", referencedColumnName = "aluno_id")
    private Aluno aluno;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "turma_id", referencedColumnName = "turma_id")
    private Turma turma;


    // =======================
    // CONSTRUCTOR
    // =======================

    public Nota() {
    }

    public Nota(float av1, float av2, Aluno aluno, Turma turma) {
        this.av1 = av1;
        this.av2 = av2;
        this.aluno = aluno;
        this.turma = turma;
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

    public float getAv1() {
        return av1;
    }

    public void setAv1(float av1) {
        this.av1 = av1;
    }

    public float getAv2() {
        return av2;
    }

    public void setAv2(float av2) {
        this.av2 = av2;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public Turma getTurma() {
        return turma;
    }

    public void setTurma(Turma turma) {
        this.turma = turma;
    }
}
