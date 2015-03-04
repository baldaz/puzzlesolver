package puzzlesolver;

import java.util.Vector;
import java.util.Iterator;

public class SortAlgFromBottom extends SortAlg implements Runnable {

    public SortAlgFromBottom(Puzzle model) {
        super(model);
    }

    public Piece firstPiece() {
        Iterator<Piece> it = puzzle().pieces().iterator();
        while(it.hasNext()) {
            Piece ret = it.next();
            if(ret.south().equals("VUOTO") && ret.east().equals("VUOTO")) return ret;
        }
        return null;
    }

    public Piece nextInRow(Piece p) {
        Iterator<Piece> it = puzzle().pieces().iterator();
        while(it.hasNext()) {
            Piece ret = it.next();
            if(ret.id().equals(p.west())) return ret;
        }
        return null;
    }
    public Piece nextInCol(Piece p) {
        Iterator<Piece> it = puzzle().pieces().iterator();
        while(it.hasNext()) {
            Piece ret = it.next();
            if(ret.id().equals(p.north())) return ret;
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

    public void run() {}
}