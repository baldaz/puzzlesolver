package puzzlesolver;

import java.util.Vector;
import java.util.Iterator;

public class PuzzleView implements IPuzzleView {

    private IOPuzzle io;

    public PuzzleView(IOPuzzle io) {
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

    public void printPuzzleText(Puzzle p) {
        Vector<Piece> puzzle = p.pieces();
        Iterator<Piece> it = puzzle.iterator();
        while(it.hasNext())
            System.out.print(it.next().ch());
        System.out.println();
    }
}