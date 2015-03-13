package puzzlesolver;

import java.util.Vector;

public class Puzzle {

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
}