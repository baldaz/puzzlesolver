package puzzlesolver;

/**
 * Controller class, implementation of IPuzzleController interface.
 */

public class PuzzleController implements IPuzzleController {

	private IPuzzleView view;

	/**
	 * Constructor
	 * @param v IPuzzleView referencerepresenting a puzzle view, provides input
	 * and output features.
	 */

	public PuzzleController(IPuzzleView v) {
		view = v;
	}

	/**
	 * Sorting method, sorts the puzzle using SortAlg type object.
	 */

	@Override
	public void sort() {
		SortAlg alg = new SortAlgSeq(view.puzzle());
		alg.sort();
	}

	/**
	 * Output sorted puzzle to the view.
	 */

	@Override
	public void output() {
		view.outputPuzzle();
	}
}
