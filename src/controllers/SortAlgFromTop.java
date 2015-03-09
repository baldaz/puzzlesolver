package puzzlesolver;

import java.util.Vector;
import java.util.Iterator;

public class SortAlgFromTop extends SortAlg implements Runnable {

    private SortAlgFromBottom bottom;

    public SortAlgFromTop(Puzzle model, SortAlgFromBottom bot, int size) {
        super(model, size);
        bottom = bot;
    }

    private Piece firstPiece() {
        Iterator<Piece> it = puzzle().pieces().iterator();
        while(it.hasNext()) {
            Piece ret = it.next();
            if(ret.north().equals("VUOTO") && ret.west().equals("VUOTO")) {
                size--;
                return ret;
            }
        }
        return null;
    }

    private Piece nextInRow(Piece p) {
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
    private Piece nextInCol(Piece p) {
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
        synchronized(puzzle()) {
            while(size > 0) {
                Vector<Piece> tmp = sortRow(first);
                row.addAll(tmp);
                first = nextInCol(tmp.firstElement());
                System.out.println("checktop");
            }
            puzzle().pieces().addAll(0, row);
            bottom.setSuspend(false);
            puzzle().notify();
        }
        System.out.println("FromTop: " + row.size());
    }

    public void run() {
        sort();
    }
}