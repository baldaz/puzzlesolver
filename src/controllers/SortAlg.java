package puzzlesolver;

/**
 * MVC Pattern sorting algorithm abstract base
 */

public abstract class SortAlg {

    private Puzzle model;

    /**
     * Constructor
     * @param m puzzle model to sort.
     */

    public SortAlg(Puzzle m) {
        model = m;
    }

    public Puzzle puzzle() {
        return model;
    }

    /**
     * Abstract sort method, must be overridden.
     */

    public abstract void sort();
}