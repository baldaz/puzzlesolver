package puzzlesolver;

/**
 * Sorting algorithm abstract base
 */

public abstract class SortAlg {

	private int size;
	private Puzzle model;

	/**
	 * Constructor
	 * @param m puzzle model to sort
	 * @param s size of the part of the puzzle that must be sorted
	 */

	public SortAlg(Puzzle m, int s) {
		model = m;
		size = s;
	}

	/**
	 * @return puzzle model
	 */

	public Puzzle puzzle() {
		return model;
	}

	/**
	 * @return size of the part of the puzzle
	 */

	public int size() {
		return size;
	}

	/**
	 * Subtract a unit from the size of the part of the puzzle
	 */

	protected void subOne() {
		size--;
	}

	/**
	 * Abstract sort method, must be overridden.
	 */

	public abstract void sort();
}
