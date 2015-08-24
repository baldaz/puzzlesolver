package puzzlesolver;

import java.io.IOException;
import java.util.Vector;
import java.util.Iterator;

/**
 * View class, implementation of IPuzzleView interface.
 */

public class PuzzleView implements IPuzzleView {

    private IOFile io;

    /**
     * Constructor
     * @param io IOFile type representing the puzzle file, provides input and output features.
     */

    public PuzzleView(IOFile io) {
        this.io = io;
    }

	/**
	 * @return puzzle reference
	 */

    public Puzzle puzzle() {
        return io.puzzle();
    }

    /**
	 * @override
     * Read input from file.
     */

    public void inputPuzzle() {
		try {
			io.read();
		} catch(IOException e) {
			System.out.println(e);
		}
    }

    /**
	 * @override
     * Write output to file.
     */

    public void outputPuzzle() {
        io.write();
    }
}
