package puzzlesolver;

public interface IPuzzleView {
    public Puzzle puzzle();
    // read from file and populate puzzle
    public void inputPuzzle();
    // write sorted puzzle on file
    public void outputPuzzle();
}