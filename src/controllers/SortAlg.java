package puzzlesolver;

/**
 * Sorting algorithm abstract base
 */

public abstract class SortAlg {

	private Puzzle model;

	/**
	 * Constructor
	 * @param m reference to a puzzle model to sort.
	 */

	public SortAlg(Puzzle m) {
		model = m;
	}

	/**
	 * @return puzzle model
	 */

	public Puzzle puzzle() {
		return model;
	}

	/**
	 * Abstract sort method, must be overridden.
	 */

	public abstract void sort();
}
