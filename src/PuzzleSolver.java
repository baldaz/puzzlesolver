import puzzlesolver.*;

public class PuzzleSolver {

    public static void main(String args[]) {
        Puzzle puzzle = new Puzzle();
        IPuzzleView view = new PuzzleView(new IOPuzzle(args[0], args[1]));
        view.inputPuzzle();
        puzzle = view.puzzle();
        IPuzzleController controller = new PuzzleController(puzzle, view);
        controller.display();
        controller.sort();
        controller.display();
    }
}
