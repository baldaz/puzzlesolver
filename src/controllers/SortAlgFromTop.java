package puzzlesolver;

import java.util.Vector;
import java.util.Iterator;

public class SortAlgFromTop extends SortAlg implements Runnable {

    private SortAlgFromBottom bottom;

    public SortAlgFromTop(Puzzle model, SortAlgFromBottom bot) {
        super(model);
        bottom = bot;
    }

    public Piece firstPiece() {
        Iterator<Piece> it = puzzle().pieces().iterator();
        while(it.hasNext()) {
            Piece ret = it.next();
            if(ret.north().equals("VUOTO") && ret.west().equals("VUOTO")) {
                // size--;
                return ret;
            }
        }
        return null;
    }

    public Piece nextInRow(Piece p) {
        Iterator<Piece> it = puzzle().pieces().iterator();
        while(it.hasNext()) {
            Piece ret = it.next();
            if(ret.id().equals(p.east())) {
                size--;
                return ret;
            }
        }
        return null;
    }
    public Piece nextInCol(Piece p) {
        Iterator<Piece> it = puzzle().pieces().iterator();
        while(it.hasNext()) {
            Piece ret = it.next();
            if(ret.id().equals(p.south())) {
                size--;
                return ret;
            }
        }
        return null;
    }

    public Vector<Piece> sortRow(Piece p) {
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
        Vector<Piece> row = sortRow(first); // first row
        Piece tmp = nextInCol(row.firstElement()); // first column
        synchronized(bottom) {
            while(size > 0) {
                Vector<Piece> rowtmp = sortRow(tmp);
                row.addAll(rowtmp);
                tmp = nextInCol(tmp);
            }
            puzzle().setPieces(row);
            System.out.println("FromTop: " + row.size());
            bottom.setSuspend(false);
            bottom.notify();
        }
    }

    public void run() {
        sort();
    }
}