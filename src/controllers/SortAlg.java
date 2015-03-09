package puzzlesolver;

import java.util.Vector;
import java.util.Iterator;

public abstract class SortAlg {

    protected int size;

    private Puzzle model;

    public SortAlg(Puzzle m, int s) {
        model = m;
        size = s;
    }

    public Puzzle puzzle() {
        return model;
    }

    public abstract void sort();
}