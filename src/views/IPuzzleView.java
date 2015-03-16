package puzzlesolver;

/**
 * MVC pattern, public interface for a puzzle.
 */

public interface IPuzzleView {

    // simple getter

    public Puzzle puzzle();

    // read from file and populate puzzle

    public void inputPuzzle();

    // write sorted puzzle on file

    public void outputPuzzle();
}