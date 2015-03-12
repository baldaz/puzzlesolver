package puzzlesolver;

import java.util.Vector;
import java.util.Iterator;
import java.io.Serializable;

public class Puzzle implements Serializable {

    private Vector<Piece> pieces;

    public Puzzle() {
        pieces = new Vector<Piece>();
    }

    public int size() {
        return pieces.size();
    }

    public void addPiece(Piece p) {
        pieces.add(p);
    }

    public Vector<Piece> pieces() {
        return pieces;
    }

    public void setPieces(Vector<Piece> pcs) {
        pieces = pcs;
    }

    public String toString() {
        String ret = "Puzzle pieces:\n";
        Iterator it = pieces.iterator();
        while(it.hasNext())
            ret += it.next().toString() + "\n";
        return ret;
    }
}