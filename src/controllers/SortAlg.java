package puzzlesolver;

import java.util.Vector;
import java.util.Iterator;

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