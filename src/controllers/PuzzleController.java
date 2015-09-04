package puzzlesolver;

/**
 * Controller class, implementation of IPuzzleController interface.
 */

public class PuzzleController implements IPuzzleController {

	private IPuzzleView view;

	/**
	 * Constructor
	 * @param v IPuzzleView reference representing a puzzle view, provides
	 * input and output features.
	 */

	public PuzzleController(IPuzzleView v) {
		view = v;
	}

	/**
	 * Sorting method, sorts the puzzle using SortAlg derived objects. First
	 * off all it get a point near the middle of the Vector of pieces
	 * representing the puzzle, then it launch 2 threads passing to them a
	 * reference to the sorting algorithm, top and bot side respectively, and a
	 * reference of a shared object to allow communication between the threads.
	 */

	@Override
	public void sort() {
		int m_size = view.puzzle().size();
		int h_size = 0;
		if((m_size % 2) == 0) {
			h_size = m_size / 2;
		}
		else {
			h_size = (m_size / 2) + 1;
		}
		SharedSortStat shared = new SharedSortStat();
		SortAlgFromBottom bot_sa = new SortAlgFromBottom(view.puzzle(), h_size, shared);
		SortAlgFromTop top_sa = new SortAlgFromTop(view.puzzle(), m_size / 2, shared);
		Thread top = new Thread(top_sa);
		Thread bot = new Thread(bot_sa);
		top.start();
		bot.start();
		try {
			top.join();
			bot.join();
		} catch(InterruptedException e) {
			System.err.println(e);
		}
	}

	/**
	 * Output sorted puzzle to the view.
	 */

	@Override
	public void output() {
		view.outputPuzzle();
	}
}
