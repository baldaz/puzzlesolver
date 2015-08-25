import puzzlesolver.*;
import java.rmi.*;

public class PuzzleSolverClient {
	private static final String HOST = "localhost";

	public static void main(String[] args) throws Exception {
		String inp = args[0]; // input file
		String out = args[1]; // output file
		String hst = args[2]; // host server name
		IPuzzleView view = new PuzzleView(new IOPuzzle(inp, out));
		view.inputPuzzle();
		Puzzle puzzle = view.puzzle();
		IPuzzleController controller = new PuzzleController(view);
		controller.sort(HOST + "/" + hst);
		controller.output();
	}
}
