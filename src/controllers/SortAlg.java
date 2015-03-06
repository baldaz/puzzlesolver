package puzzlesolver;

import java.util.Vector;
import java.util.Iterator;

public abstract class SortAlg {

    protected static int size;
    protected static int halfsize;

    private Puzzle model;

    public SortAlg(Puzzle m) {
        model = m;
    }

    public Puzzle puzzle() {
        return model;
    }

    public static void setSize(int s) {
        size = s;
    }

    public static void setHalfSize(int s) {
        halfsize = s;
    }

    public static int size() {
        return size;
    }

    public abstract void sort();
}