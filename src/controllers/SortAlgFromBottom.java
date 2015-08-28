package puzzlesolver;

import java.util.Vector;
import java.util.Iterator;
import java.util.Collections;

/**
 * Sorting class derived from abstract base SortAlg, contains the override of
 * the method void sort() and the private utility methods used by the
 * algorithm.
 */

public class SortAlgFromBottom extends SortAlg implements Runnable {

	private Vector<IPiece> result = new Vector<IPiece>();
	private IPiece[] p_arr;	// support array, faster navigation

	/**
	 * Constructor
	 * @param model puzzle object to sort
	 * @param size size of the part of the puzzle that must be sorted
	 */

	public SortAlgFromBottom(Puzzle model, int size) {
		super(model, size);
		p_arr = model.pieces().toArray(new IPiece[model.size()]);
	}

	/**
	 * @return reference to a sorted Vector representing the sorted part of the
	 * puzzle
	 */

	public Vector<IPiece> result() {
		return result;
	}

	/**
	 * First piece scouter method. Private method that find the first piece of
	 * the puzzle iterating through the vector of piece that represent the
	 * puzzle itself using a loop that check if the current piece has north and
	 * west sides setted at "VUOTO", else returns null.
	 * @return returns a reference to a piece object, representing the first piece of the puzzle.
	 */

	private IPiece firstPiece() {
		for(int i = 0; i < puzzle().pieces().size(); ++i) {
			if(p_arr[i].southBorder() && p_arr[i].eastBorder()) {
				subOne();
				return p_arr[i];
			}
		}
		return null;
	}

	/**
	 * Private method that find the piece whose ID equals the east information
	 * of a given piece.
	 * @param p a reference to a piece object.
	 * @return reference to a piece object, representing the east piece of the
	 * given piece.
	 */

	private IPiece nextInRow(IPiece p) {
		for(int i = 0; i < puzzle().pieces().size(); ++i) {
			if(p.westSide(p_arr[i])) {
				subOne();
				return p_arr[i];
			}
		}
		return null;
	}

	/**
	 * Private method that find the piece whose ID equals the south information
	 * of a given piece.
	 * @param p piece object.
	 * @return a reference to a piece object, representing the south piece of
	 * the given piece.
	 */

	private IPiece nextInCol(IPiece p) {
		for(int i = 0; i < puzzle().pieces().size(); ++i) {
			if(p.northSide(p_arr[i])) {
				subOne();
				return p_arr[i];
			}
		}
		return null;
	}

	/**
	 * Private method that sort a row of the puzzle, starting from a given
	 * piece by using nextInRow() methods in a loop.
	 * @param p refernece to a piece object.
	 * @return reference to a Vector of piece, representing the sorted row.
	 */

	private Vector<IPiece> sortRow(IPiece p) {
		Vector<IPiece> ret = new Vector<IPiece>();
		ret.add(p);
		IPiece nxt = nextInRow(p);
		while(nxt != null) {
			ret.add(nxt); // last
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
	 * vector of Piece created to the puzzle
	 * member.
	 */

	public void sort() {
		IPiece first = firstPiece(); // first piece
		while(size() > 0) {
			result.addAll(sortRow(first));
			first = nextInCol(first);
		}
		Collections.reverse(result);
	}

	/**
	 * @override
	 * Override of the run method of the interface Runnable
	 */

	public void run() {
		sort();
	}
}
