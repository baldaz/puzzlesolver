package puzzlesolver;

import java.util.Vector;
import java.util.Iterator;

/**
 * Sorting class derived from abstract base SortAlg, contains the override of
 * the method void sort() and the private utility methods used by the
 * algorithm.
 */

public class SortAlgSeq extends SortAlg {

	/**
	 * Constructor
	 * @param model reference to a puzzle object to sort.
	 */

	public SortAlgSeq(Puzzle model) {
		super(model);
	}

	/**
	 * First piece scouter method. Private method that find the first piece of
	 * the puzzle iterating through the vector of piece that represent the
	 * puzzle itself using a loop that check if the current piece has north and
	 * west sides setted at "VUOTO", else returns null.
	 * @return returns a reference to a piece object, representing the first
	 * piece of the puzzle.
	 */

	private IPiece firstPiece() {
		Iterator<IPiece> it = puzzle().pieces().iterator();
		while(it.hasNext()) {
			IPiece ret = it.next();
			if(ret.northBorder() && ret.westBorder()) return ret;
		}
		return null;
	}

	/**
	 * Private method that find the piece whose ID equals the east information
	 * of a given piece.
	 * @param p reference to a piece object.
	 * @return returns a reference to a piece object, representing the east
	 * piece of the given piece.
	 */

	private IPiece nextInRow(IPiece p) {
		Iterator<IPiece> it = puzzle().pieces().iterator();
		while(it.hasNext()) {
			IPiece ret = it.next();
			if(p.eastSide(ret)) return ret;
		}
		return null;
	}

	/**
	 * Private method that find the piece whose ID equals the south information
	 * of a given piece.
	 * @param p reference to a piece object.
	 * @return returns a reference to a piece object, representing the south
	 * piece of the given piece.
	 */

	private IPiece nextInCol(IPiece p) {
		Iterator<IPiece> it = puzzle().pieces().iterator();
		while(it.hasNext()) {
			IPiece ret = it.next();
			if(p.southSide(ret)) return ret;
		}
		return null;
	}

	/**
	 * Private method that sort a row of the puzzle, starting from a given
	 * piece by using nextInRow() methods in a loop.
	 * @param p reference to a piece object.
	 * @return returns a vector of piece, representing the sorted row.
	 */

	private Vector<IPiece> sortRow(IPiece p) {
		Vector<IPiece> ret = new Vector<IPiece>();
		ret.add(p);
		IPiece nxt = nextInRow(p);
		while(nxt != null) {
			ret.add(nxt);
			nxt = nextInRow(nxt);
		}
		return ret;
	}

	/**
	 * Public method that sort the puzzle by using private methods to find the
	 * first piece and the following ones.  After locating the first piece,
	 * through a while loop, this method sort every row giving at every cycle
	 * the first piece of the current row to sort, by calling nextInCol on the
	 * first piece of the previous row (already sorted) until a piece with
	 * south information equals to "VUOTO" is found. In the end it sets the new
	 * vector of Piece created to the puzzle member.
	 */

	@Override
	public void sort() {
		boolean loop = true;
		IPiece first = firstPiece(); // first piece
		Vector<IPiece> row = new Vector<IPiece>();
		while(loop) {
			Vector<IPiece> tmp = sortRow(first);
			row.addAll(tmp);
			if(first.southBorder()) loop = false;
			else first = nextInCol(tmp.firstElement());
		}
		puzzle().setPieces(row);
	}
}
