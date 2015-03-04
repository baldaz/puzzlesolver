package puzzlesolver;

import java.util.Vector;
import java.util.Iterator;

public class SortAlgFromTop extends SortAlg implements Runnable {

    public SortAlgFromTop(Puzzle model) {
        super(model);
    }

    public Piece firstPiece() {
        Iterator<Piece> it = puzzle().pieces().iterator();
        while(it.hasNext()) {
            Piece ret = it.next();
            if(ret.north().equals("VUOTO") && ret.west().equals("VUOTO")) return ret;
        }
        return null;
    }

    public Piece nextInRow(Piece p) {
        Iterator<Piece> it = puzzle().pieces().iterator();
        while(it.hasNext()) {
            Piece ret = it.next();
            if(ret.id().equals(p.east())) return ret;
        }
        return null;
    }
    public Piece nextInCol(Piece p) {
        Iterator<Piece> it = puzzle().pieces().iterator();
        while(it.hasNext()) {
            Piece ret = it.next();
            if(ret.id().equals(p.south())) return ret;
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

    public void run() {
        boolean loop = true;
        Piece first = firstPiece(); // first piece
        Vector<Piece> row = sortRow(first); // first row
        Piece tmp = nextInCol(row.firstElement()); // first column
        while(loop) {
            Vector<Piece> rowtmp = sortRow(tmp);
            row.addAll(rowtmp);
            if(tmp.south().equals("VUOTO")) loop = false;
            else tmp = nextInCol(tmp);
        }
        puzzle().setPieces(row);
    }
}