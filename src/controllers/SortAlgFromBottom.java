package puzzlesolver;

import java.util.Vector;
import java.util.Iterator;
import java.util.Collections;

public class SortAlgFromBottom extends SortAlg implements Runnable {

    public SortAlgFromBottom(Puzzle model) {
        super(model);
    }

    public Piece firstPiece() {
        Iterator<Piece> it = puzzle().pieces().iterator();
        while(it.hasNext()) {
            Piece ret = it.next();
            if(ret.south().equals("VUOTO") && ret.east().equals("VUOTO")) {
                --size;
                return ret;
            }
        }
        return null;
    }

    public Piece nextInRow(Piece p) {
        Iterator<Piece> it = puzzle().pieces().iterator();
        while(it.hasNext()) {
            Piece ret = it.next();
            if(ret.id().equals(p.west())) {
                --size;
                return ret;
            }
        }
        return null;
    }
    public Piece nextInCol(Piece p) {
        Iterator<Piece> it = puzzle().pieces().iterator();
        while(it.hasNext()) {
            Piece ret = it.next();
            if(ret.id().equals(p.north())) {
                --size;
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
            ret.add(nxt); // last
            nxt = nextInRow(nxt);
        }
        return ret;
    }

    public void sort() {
        boolean loop = true;
        Piece first = firstPiece(); // first piece
        Vector<Piece> row = sortRow(first); // first row
        Piece tmp = nextInCol(row.firstElement()); // first column
        while(size > 0) {
            Vector<Piece> rowtmp = sortRow(tmp);
            row.addAll(rowtmp);
            if(tmp.north().equals("VUOTO")) loop = false;
            else tmp = nextInCol(tmp);
        }
        Collections.reverse(row);
        synchronized(puzzle()) {
            try {
                puzzle().wait();
            } catch(InterruptedException e) {
                System.err.println(e);
            }
            puzzle().pieces().addAll(row);
        }
    }

    public void run() {
        sort();
    }
}