package puzzlesolver;

/**
 * MVC Pattern sorting algorithm abstract base
 */

public abstract class SortAlg {

    private int size;
    private Puzzle model;

    /**
     * Constructor
     * @param m puzzle model to sort
     * @param s size of the part of the puzzle that must be sorted
     */

    public SortAlg(Puzzle m, int s) {
        model = m;
        size = s;
    }

    public Puzzle puzzle() {
        return model;
    }

    public int size() {
        return size;
    }

    public void subOne() {
        size--;
    }

    /**
     * Abstract sort method, must be overridden.
     */

    public abstract void sort();
}