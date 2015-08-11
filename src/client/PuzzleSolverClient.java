import puzzlesolver.*;
import java.rmi.*;

public class PuzzleSolverClient {
    private static final String HOST = "localhost";

    public static void main(String[] args) throws Exception {
       String inp = args[0];
       String out = args[1];
       String hst = args[2];
       IPuzzleView view = new PuzzleView(new IOPuzzle(inp, out));
       view.inputPuzzle();
       Puzzle puzzle = view.puzzle();
       IPuzzleController controller = new PuzzleController(view);
       controller.sort(HOST + "/" + hst);
       controller.output();
    }
}