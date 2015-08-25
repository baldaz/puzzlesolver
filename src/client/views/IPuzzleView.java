package puzzlesolver;

/**
 * Public interface for a puzzle.
 */

public interface IPuzzleView {

	// return puzzle

	public Puzzle puzzle();

	// update puzzle

	public void updatePuzzle(Puzzle p);

	// read from file and populate puzzle

	public void inputPuzzle();

	// write sorted puzzle on file

	public void outputPuzzle();
}
