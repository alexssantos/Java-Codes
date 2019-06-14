package alex.silva;

public class Aluno {
    private String nome;
    private int n1, n2;
    
    public Aluno() {
    }

    public Aluno(String nome, int n1, int n2) {
        this.nome = nome;
        this.n1 = n1;
        this.n2 = n2;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getN1() {
        return n1;
    }

    public void setN1(int n1) {
        this.n1 = n1;
    }

    public int getN2() {
        return n2;
    }

    public void setN2(int n2) {
        this.n2 = n2;
    }

    @Override
    public String toString() {
        return (nome + " " + n1 + " " + n2);
    }
}
