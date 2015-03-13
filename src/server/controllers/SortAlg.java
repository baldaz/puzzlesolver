package puzzlesolver;

public abstract class SortAlg {

    private Puzzle model;
    private int size;

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