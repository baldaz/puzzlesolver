package puzzlesolver;

import java.util.Vector;

public class SortAlgFromTop extends SortAlg implements Runnable {

    private SortAlgFromBottom bottom;
    private Vector<Piece> result = new Vector<Piece>();

    public SortAlgFromTop(Puzzle model, SortAlgFromBottom bot, int size) {
        super(model, size);
        bottom = bot;
    }

    public Vector<Piece> result() {
        return result;
    }

    private Piece firstPiece() {
        Piece[] p = puzzle().pieces().toArray(new Piece[puzzle().pieces().size()]);
        for(int i = 0; i < puzzle().pieces().size(); ++i) {
            if(p[i].north().equals("VUOTO") && p[i].west().equals("VUOTO")) {
                subOne();
                return p[i];
            }
        }
        return null;
    }

    private Piece nextInRow(Piece p) {
        Piece[] pa = puzzle().pieces().toArray(new Piece[puzzle().pieces().size()]);
        for(int i = 0; i < puzzle().pieces().size(); ++i) {
            if(pa[i].id().equals(p.east())) {
                subOne();
                return pa[i];
            }
        }
        return null;
    }

    private Piece nextInCol(Piece p) {
        Piece[] pa = puzzle().pieces().toArray(new Piece[puzzle().pieces().size()]);
        for(int i = 0; i < puzzle().pieces().size(); ++i) {
            if(pa[i].id().equals(p.south())) {
                subOne();
                return pa[i];
            }
        }
        return null;
    }

    private Vector<Piece> sortRow(Piece p) {
        Vector<Piece> ret = new Vector<Piece>();
        ret.add(p);
        Piece nxt = nextInRow(p);
        while(nxt != null) {
            ret.add(nxt);
            nxt = nextInRow(nxt);
        }
        return ret;
    }

    public void sort() {
        Piece first = firstPiece(); // first piece
        Vector<Piece> row = new Vector<Piece>();
        while(size() > 0) {
            Vector<Piece> tmp = sortRow(first);
            row.addAll(tmp);
            first = nextInCol(tmp.firstElement());
            System.out.println("topThread");
        }
        result = row;
        System.out.println("FromTop: " + row.size());
    }

    public void run() {
        sort();
    }
}