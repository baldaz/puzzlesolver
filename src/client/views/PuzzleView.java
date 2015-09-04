package puzzlesolver;

import java.io.IOException;

/**
 * View class, implementation of IPuzzleView interface.
 */

public class PuzzleView implements IPuzzleView {

	private IOFile io;

	/**
	 * Constructor
	 * @param io IOFile type representing the puzzle file, provides input and
	 * output features.
	 */

	public PuzzleView(IOFile io) {
		this.io = io;
	}

	/**
	 * @return a reference to a puzzle
	 */

	public Puzzle puzzle() {
		return io.puzzle();
	}

	/**
	 * Read input from file.
	 */

	@Override
	public void inputPuzzle() {
		try {
			io.read();
		} catch(IOException e) {
			System.out.println(e);
		}
	}

	/**
	 * Write output to file.
	 */

	@Override
	public void outputPuzzle() {
		io.write();
	}

	/**
	 * Set a new puzzle
	 * @param p a reference to a puzzle object
	 */

	@Override
	public void updatePuzzle(Puzzle p) {
		io.setPuzzle(p);
	}
}
