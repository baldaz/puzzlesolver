import puzzlesolver.*;

public class PuzzleSolver {

    public static void main(String args[]) {
        Puzzle puzzle = new Puzzle();
        IPuzzleView view = new PuzzleView(new IOPuzzle(args[0]));
        puzzle = view.inputPuzzle();
        IPuzzleController controller = new PuzzleController(puzzle, view);
        controller.display();
        controller.sort();
        controller.display();
    }
}
