package puzzlesolver;

import java.util.Vector;
import java.util.Iterator;

/**
 * MVC Pattern sorting class derived from abstract base SortAlg, contains the override of the method void sort()
 * and the private utility methods used by the algorithm.
 */

public class SortAlgSeq extends SortAlg {

    /**
     * Constructor
     * @param model, puzzle object to sort.
     */

    public SortAlgSeq(Puzzle model) {
        super(model);
    }

    /**
     * First piece scouter method. Private method that find the first piece of the puzzle iterating through the vector of piece
     * that represent the puzzle itself using a loop that check if the current piece has north and west sides setted at "VUOTO",
     * else returns null.
     * @return returns a piece object, representing the first piece of the puzzle.
     */

    private Piece firstPiece() {
        Iterator<Piece> it = puzzle().pieces().iterator();
        while(it.hasNext()) {
            Piece ret = it.next();
            if(ret.north().equals("VUOTO") && ret.west().equals("VUOTO")) return ret;
        }
        return null;
    }

    /**
     * Private method that find the piece whose ID equals the east information of a given piece.
     * @param p, piece object.
     * @return returns a piece object, representing the east piece of the given piece.
     */

    private Piece nextInRow(Piece p) {
        Iterator<Piece> it = puzzle().pieces().iterator();
        while(it.hasNext()) {
            Piece ret = it.next();
            if(ret.id().equals(p.east())) return ret;
        }
        return null;
    }

    /**
     * Private method that find the piece whose ID equals the south information of a given piece.
     * @param p, piece object.
     * @return returns a piece object, representing the south piece of the given piece.
     */

    private Piece nextInCol(Piece p) {
        Iterator<Piece> it = puzzle().pieces().iterator();
        while(it.hasNext()) {
            Piece ret = it.next();
            if(ret.id().equals(p.south())) return ret;
        }
        return null;
    }

    /**
     * Private method that sort a row of the puzzle, starting from a given piece by using nextInRow() methods in a loop.
     * @param p, piece object.
     * @return returns a vector of piece, representing the sorted row.
     */

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

    /**
     * Public method that sort the puzzle by using private methods to find the first piece and the following ones.
     * After locating the first piece, through a while loop, this method sort every row giving at every cycle the first piece
     * of the current row to sort, by calling nextInCol on the first piece of the previous row (already sorted) until a piece
     * with south information equals to "VUOTO" is found. In the end it sets the new vector of Piece created to the puzzle
     * member.
     */

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