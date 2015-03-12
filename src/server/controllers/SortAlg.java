package puzzlesolver;

public abstract class SortAlg {

    private int size;

    private Puzzle model;

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

    public abstract void sort();
}