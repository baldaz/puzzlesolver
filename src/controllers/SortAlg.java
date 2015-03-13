package puzzlesolver;

public abstract class SortAlg {

    private Puzzle model;

    public SortAlg(Puzzle m) {
        model = m;
    }

    public Puzzle puzzle() {
        return model;
    }

    public abstract void sort();
}