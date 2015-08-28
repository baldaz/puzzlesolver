package puzzlesolver;

/**
 * Sorting algorithm abstract base
 */

public abstract class SortAlg {

	private int size;
	private Puzzle model;
	private static SharedSortStat shared;

	/**
	 * Constructor
	 * @param m puzzle model to sort
	 * @param s size of the part of the puzzle that must be sorted
	 */

	public SortAlg(Puzzle m, int s, SharedSortStat shared) {
		model = m;
		size = s;
		this.shared = shared;
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

	public SharedSortStat getShared() {
		return shared;
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
