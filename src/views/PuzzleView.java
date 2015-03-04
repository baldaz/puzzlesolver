package puzzlesolver;

import java.util.Vector;
import java.util.Iterator;

// Here i'll make output to file logic

public class PuzzleView implements IPuzzleView {

    private IOFile io;

    public PuzzleView(IOFile io) {
        this.io = io;
    }

    public Puzzle inputPuzzle() {
        return io.read();
    }

    public void outputPuzzle() {
        io.write();
    }

    public void printPuzzle(Puzzle p) {
        System.out.println(p);
    }

    public void printPuzzleText(Puzzle p) {
        Vector<Piece> puzzle = p.pieces();
        Iterator<Piece> it = puzzle.iterator();
        while(it.hasNext())
            System.out.print(it.next().ch());
        System.out.println();
    }
}