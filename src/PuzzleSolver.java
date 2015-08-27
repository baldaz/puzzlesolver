import puzzlesolver.*;

/**
 * Puzzlesolver class providing main for the application. Accept input and
 * output path of the files needed.
 */

public class PuzzleSolver {

    public static void main(String args[]) {
        IPuzzleView view = new PuzzleView(new IOPuzzle(args[0], args[1]));
        view.inputPuzzle();
        IPuzzleController controller = new PuzzleController(view);
		long startTime = System.currentTimeMillis();
        controller.sort();
		long stopTime = System.currentTimeMillis();
		System.out.println(stopTime-startTime);
        controller.output();
    }
}
