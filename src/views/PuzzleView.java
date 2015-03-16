package puzzlesolver;

import java.util.Vector;
import java.util.Iterator;

/**
 * MVC Pattern view class, implementation of IPuzzleView interface.
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

    public Puzzle puzzle() {
        return io.puzzle();
    }

    /**
     * Read input from file.
     */

    public void inputPuzzle() {
        io.read();
    }

    /**
     * Write output to file.
     */

    public void outputPuzzle() {
        io.write();
    }
}