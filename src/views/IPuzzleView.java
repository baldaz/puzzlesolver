package puzzlesolver;

public interface IPuzzleView {
    public Puzzle puzzle();
    // read from file and populate puzzle
    public void inputPuzzle();
    // write sorted puzzle on file
    public void outputPuzzle();
    // print puzzle in table form, utility
    public void printPuzzle(Puzzle p);
    // print puzzle in text form, utility
    public void printPuzzleText(Puzzle p);
}