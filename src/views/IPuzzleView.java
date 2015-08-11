package puzzlesolver;

/**
 * Public interface for a puzzle.
 */

public interface IPuzzleView {

    // getter

    public Puzzle puzzle();

    // read from file and populate puzzle

    public void inputPuzzle();

    // write sorted puzzle on file

    public void outputPuzzle();
}
