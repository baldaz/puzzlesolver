package puzzlesolver;

import java.util.Vector;
import java.util.Iterator;

public class SortAlgSeq extends SortAlg {

    public SortAlgSeq(Puzzle model) {
        super(model);
    }

    private Piece firstPiece() {
        Iterator<Piece> it = puzzle().pieces().iterator();
        while(it.hasNext()) {
            Piece ret = it.next();
            if(ret.north().equals("VUOTO") && ret.west().equals("VUOTO")) return ret;
        }
        return null;
    }

    private Piece nextInRow(Piece p) {
        Iterator<Piece> it = puzzle().pieces().iterator();
        while(it.hasNext()) {
            Piece ret = it.next();
            if(ret.id().equals(p.east())) return ret;
        }
        return null;
    }
    private Piece nextInCol(Piece p) {
        Iterator<Piece> it = puzzle().pieces().iterator();
        while(it.hasNext()) {
            Piece ret = it.next();
            if(ret.id().equals(p.south())) return ret;
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
        boolean loop = true;
        Piece first = firstPiece(); // first piece
        Vector<Piece> row = new Vector<Piece>();
        while(loop) {
            Vector<Piece> tmp = sortRow(first);
            row.addAll(tmp);
            if(first.south().equals("VUOTO")) loop = false;
            else first = nextInCol(tmp.firstElement());
        }
        puzzle().setPieces(row);
    }
}