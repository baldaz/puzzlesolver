package puzzlesolver;

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
	 * Sorting method, sorts the puzzle using SortAlg type object.
	 * @param host name of the host server to connect with to sort the puzzle
	 */

	@Override
	public void sort(String host) {
		try {
			IPuzzleServerController psc = (IPuzzleServerController) Naming.lookup("rmi://" + host + "/Resolve");
			Puzzle p = psc.sort(view.puzzle());
			view.updatePuzzle(p);
		} catch(ConnectException e) {
			System.out.println("Connection problems");
		} catch(Exception ex) {
			ex.printStackTrace();
		}
	}

	/**
	 * Output sorted puzzle to the view
	 */

	@Override
	public void output() {
		view.outputPuzzle();
	}
}
