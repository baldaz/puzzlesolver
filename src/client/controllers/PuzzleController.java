package puzzlesolver;

// This class will contain sorting logic of the puzzle
import java.util.Vector;
import java.rmi.*;

/**
 * Controller class, implementation of IPuzzleController interface.
 */

public class PuzzleController implements IPuzzleController {

	private IPuzzleView view;

	/**
	 * Constructor
	 * @param v IPuzzleView reference representing a puzzle view, provides input and
	 * output features.
	 */

	public PuzzleController(IPuzzleView v) {
		view = v;
	}

	/**
	 * @override
	 * Sorting method, sorts the puzzle using SortAlg type object.
	 * @param host name of the host server to connect with to sort the puzzle
	 */

	public void sort(String host) {
		try {
			IPuzzleServerController psc = (IPuzzleServerController) Naming.lookup("rmi://" + host + "/Resolve");
			Puzzle p = psc.sort(view.puzzle());
			Vector<IPiece> t = p.pieces();
			view.puzzle().setPieces(t);
		}catch(ConnectException e) {
			System.out.println("Connection problems");
		}catch(Exception exc) {
			exc.printStackTrace();
		}
	}

	/**
	 * @override
	 * Output sorted puzzle to the view
	 */

	public void output() {
		view.outputPuzzle();
	}
}
