package puzzlesolver;

import java.util.Vector;
import java.util.Iterator;

public class PuzzleView implements IPuzzleView {

    private IOFile io;

    public PuzzleView(IOFile io) {
        this.io = io;
    }

    public Puzzle puzzle() {
        return io.puzzle();
    }

    public void inputPuzzle() {
        io.read();
    }

    public void outputPuzzle() {
        io.write();
    }
}