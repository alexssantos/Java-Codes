package ex20;


/**
 * Sequencia
 */
public class Sequencia {

    private int first;
    private int last;

    public Sequencia(int _first, int _last) {
        super();
        this.first = _first;
        this.last = _last;
    }

    /**
     * @return the first
     */
    public int getFirst() {
        return first;
    }

    /**
     * @param first the first to set
     */
    public void setFirst(int first) {
        this.first = first;
    }

    /**
     * @return the last
     */
    public int getLast() {
        return last;
    }

    /**
     * @param last the last to set
     */
    public void setLast(int last) {
        this.last = last;
    }

    public void printSequence() {
        for (int i = this.first; i <= this.last; i++) {
            System.out.printf("%d\t", i);
        }
        System.out.println("\n");
    }; 

    public void printSequence(int p) {
        for (int i = this.first; i <= this.last; i+=p) {
            System.out.printf("%d\t", i);
        }
    }
}