package puzzlesolver;

import java.util.Vector;

/**
 * MVC Pattern, puzzle model representing a text puzzle formed by a Vector of pieces.
 */

public class Puzzle {

    private Vector<Piece> pieces;

    public Puzzle() {
        pieces = new Vector<Piece>();
    }

    /**
     * @return size, an int value representing size of the puzzle.
     */

    public int size() {
        return pieces.size();
    }

    /**
     * Add a piece to the Vector of pieces.
     * @param p, reference to a Piece.
     */

    public void addPiece(Piece p) {
        pieces.add(p);
    }

    /**
     * @return A Vector of pieces representing the puzzle.
     */

    public Vector<Piece> pieces() {
        return pieces;
    }

    /**
     * Set a new puzzle.
     * @param pcs, a Vector of pieces that will replace the current Vector.
     */

    public void setPieces(Vector<Piece> pcs) {
        pieces = pcs;
    }
}