package puzzlesolver;

import java.util.Vector;
import java.util.Collections;

/**
 * Sorting class derived from abstract base SortAlg, contains the override of
 * the method void sort() and the private utility methods used by the
 * algorithm.
 */

public class SortAlgFromBottom extends SortAlg implements Runnable {

	private Vector<IPiece> result = new Vector<IPiece>();
	private IPiece[] p_arr;

	/**
	 * Constructor
	 * @param model puzzle object to sort
	 * @param size size of the part of the puzzle that must be sorted
	 * @param shared reference to the shared object needed to allow
	 * communication between threads
	 */

	public SortAlgFromBottom(Puzzle model, int size, SharedSortStat shared) {
		super(model, size, shared);
		p_arr = model.pieces().toArray(new IPiece[model.size()]);
	}

	/**
	 * @return A Vector of pieces representing the sorted part of the puzzle
	 */

	public Vector<IPiece> result() {
		return result;
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
		for(IPiece p : p_arr) {
			if(p.southBorder() && p.eastBorder()) {
				subOne();
				return p;
			}
		}
		return null;
	}

	/**
	 * Private method that find the piece whose ID equals the east information
	 * of a given piece.
	 * @param p piece object.
	 * @return returns a reference to a piece object, representing the east
	 * piece of the given piece.
	 */

	private IPiece nextInRow(IPiece p) {
		for(IPiece pp : p_arr) {
			if(p.westSide(pp)) {
				subOne();
				return pp;
			}
		}
		return null;
	}

	/**
	 * Private method that find the piece whose ID equals the south information
	 * of a given piece.
	 * @param p a reference to a piece object.
	 * @return returns a reference to a piece object, representing the south
	 * piece of the given piece.
	 */

	private IPiece nextInCol(IPiece p) {
		for(IPiece pp : p_arr) {
			if(p.northSide(pp)) {
				subOne();
				return pp;
			}
		}
		return null;
	}

	/**
	 * Private method that sort a row of the puzzle, starting from a given
	 * piece by using nextInRow() methods in a loop.
	 * @param p a reference to a piece object.
	 * @return returns a vector of pieces, representing the sorted row.
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
	 * vector of Piece created to the puzzle member.
	 */

	@Override
	public void sort() {
		IPiece first = firstPiece(); // first piece
		while(size() > 0) {
			result.addAll(sortRow(first));
			first = nextInCol(first);
		}
		Collections.reverse(result);
	}

	/**
	 * start the sorting method
	 */

	@Override
	public void run() {
		sort();
		getShared().setBotDone();
		synchronized(puzzle()) {
			while(!getShared().topDone() || !getShared().topWritten()) {
				puzzle().notify();
				try {
					puzzle().wait();
				} catch(InterruptedException e) {
					e.printStackTrace();
				}
			}
			puzzle().pieces().addAll(result);
		}
	}
}
