package puzzlesolver;

public interface IPuzzleView {
    // read from file and populate puzzle
    public Puzzle inputPuzzle();
    // write sorted puzzle on file
    public void outputPuzzle();
    // print puzzle in table form, utility
    public void printPuzzle(Puzzle p);
    // print puzzle in text form, utility
    public void printPuzzleText(Puzzle p);
}