import puzzlesolver.*;

public class PuzzleSolver {

    public static void main(String args[]) {
        IPuzzleView view = new PuzzleView(new IOPuzzle(args[0], args[1]));
        view.inputPuzzle();
        IPuzzleController controller = new PuzzleController(view);
        controller.display();
        controller.sort();
        controller.display();
    }
}
